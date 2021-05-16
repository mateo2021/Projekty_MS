#include <math.h>
#include <string.h>
#include <openacc.h>
#include <omp.h>

float maxerror(int n,float *error)
{
  float e=0;
  for(int i=0;i<n;i++)
    e=fmax(e,error[i]);
  return e;
}

int main(int argc, char** argv)
{
  int n = 4096;
  int m = 4096;
  int iter_max = 1000;
    
  const float pi  = 2.0 * asinf(1.0f);
  const float tol = 1.0e-5f;
  float error[]     = {1.0f, 1.0f};
    
  float A[n][m];
  float Anew[n][m];
  float y0[n];

  memset(A, 0, n * m * sizeof(float));
  memset(Anew, 0, n * m * sizeof(float));
    
  // set boundary conditions
  for (int i = 0; i < m; i++)
    {
      A[0][i]   = 0.f;
      A[n-1][i] = 0.f;
    }
    
  for (int j = 0; j < n; j++)
    {
      y0[j] = sinf(pi * j / (n-1));
      A[j][0] = y0[j];
      A[j][m-1] = y0[j]*expf(-pi);
    }

  acc_init(acc_device_nvidia);    
    
  int ndevs=acc_get_num_devices(acc_device_nvidia);


  printf("Jacobi relaxation Calculation: %d x %d mesh (ndevs=%d)\n", n, m, ndevs);
    
  double runtime = omp_get_wtime();

  int iter = 0;
    

  for (int i = 1; i < m; i++)
    {
      Anew[0][i]   = 0.f;
      Anew[n-1][i] = 0.f;
    }


  for (int j = 1; j < n; j++)
    {
      Anew[j][0]   = y0[j];
      Anew[j][m-1] = y0[j]*expf(-pi);
    }


  

#pragma omp parallel private(iter) num_threads(ndevs) if(ndevs>1) 
  {

    iter=0;

   int dn=omp_get_thread_num();

  #pragma acc set device_num(dn)
  
   int rsize=n/ndevs;
   int row1 = dn==0 ? 1 : dn*rsize;
   int row2 = dn==ndevs-1 ? n-2 : (dn+1)*rsize-1;
   //   int nrows= (dn==0)||(dn==ndevs-1) ? rsize+1 : rsize+2;
  
   int nrows=rsize+2;

   if(dn==0) nrows--;
   if(dn==ndevs-1) nrows--;

  #pragma acc enter data copyin(A[row1-1:nrows][0:m],Anew[row1-1:nrows][0:m]) 

   printf(">>>>> %d %d %d %d %d\n",dn, rsize,row1,row2,nrows);


   while ( maxerror(ndevs,error) > tol && iter < iter_max )
    {

   #pragma omp barrier


    float perror = 0.f;

    #pragma acc parallel  present(A[row1-1:nrows][0:m],Anew[row1-1:nrows][0:m])
      {
     #pragma acc loop reduction(max:perror)
     for( int j = row1; j <=row2 ; j++)
        {
          #pragma acc loop  reduction(max:perror)
	  for( int i = 1; i < m-1; i++ )
            {
	      Anew[j][i] = 0.25f * ( A[j][i+1] + A[j][i-1]
                                     + A[j-1][i] + A[j+1][i]);
	      perror = fmaxf( perror, fabsf(Anew[j][i]-A[j][i]));
            }
        }


      #pragma acc loop 
      for( int j = row1; j <=row2; j++)
        {
          #pragma acc loop 
	  for( int i = 1; i < m-1; i++ )
            {
	      A[j][i] = Anew[j][i];    
            }
        }

      }

      #pragma acc update self(A[row1:1][0:m],A[row2:1][0:m]) 

      error[dn] = perror;

      #pragma omp barrier

      #pragma acc update device(A[row1-1:1][0:m],A[row2+1:1][0:m]) 

      #pragma omp master 
      if(iter % 100 == 0) printf("%5d, %0.6f %0.6f %0.6f \n", iter, maxerror(ndevs,error),error[0],error[1]);
     
      iter++;

      //      #pragma omp barrier

    }

  #pragma acc exit data copyout(A[row1:rsize][0:m]) //delete(Anew) 

  }

  runtime = omp_get_wtime() - runtime;
 
  printf(" total: %f s\n", runtime);
}
