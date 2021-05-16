#include <math.h>
#include <string.h>
#include <openacc.h>
#include <omp.h>

int main(int argc, char** argv)
{
  int n = 4096;
  int m = 4096;
  int iter_max = 1000;
    
  const float pi  = 2.0 * asinf(1.0f);
  const float tol = 1.0e-5f;
  float error     = 1.0f;
    
  float A[n][m];
  float Anew[n][m];
  float y0[n];

  memset(A, 0, n * m * sizeof(float));
    
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
    
  printf("Jacobi relaxation Calculation: %d x %d mesh\n", n, m);
    
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

#pragma acc data copy(A) copyin(Anew)
  {
  while ( error > tol && iter < iter_max )
    {
      error = 0.f;
     #pragma acc parallel present(A,Anew)
      {
     #pragma acc loop reduction(max:error)
     for( int j = 1; j < n-1; j++)
        {
          #pragma acc loop reduction(max:error)
	  for( int i = 1; i < m-1; i++ )
            {
	      Anew[j][i] = 0.25f * ( A[j][i+1] + A[j][i-1]
                                     + A[j-1][i] + A[j+1][i]);
	      error = fmaxf( error, fabsf(Anew[j][i]-A[j][i]));
            }
        }
      #pragma acc loop 
      for( int j = 1; j < n-1; j++)
        {
          #pragma acc loop 
	  for( int i = 1; i < m-1; i++ )
            {
	      A[j][i] = Anew[j][i];    
            }
        }

      }
      if(iter % 100 == 0) printf("%5d, %0.6f\n", iter, error);
        
      iter++;
    }

  }

  runtime = omp_get_wtime() - runtime;
 
  printf(" total: %f s\n", runtime);
}
