#include <stdlib.h>
#include <stdio.h>
#include <omp.h>
#include <math.h>

#define ALIGNSIZE 32


#define RADTODEG 57.29577951f


void curvature(int ncols, int nrows, float xcellsize, float ycellsize,
                  float* input, float *output, int ldx)
{

        
 int i,j;
 #pragma omp for private(j)
 for (i=1; i<nrows-1; i++) {
  for (j=1; j<ncols-1; j++) {
    float d=((input[i*ncols+j-1]+input[i*ncols+j+1])/2-input[i*ncols+j])/(xcellsize*xcellsize);
    float e=((input[(i-1)*ncols+j]+input[(i+1)*ncols+j])/2-input[i*ncols+j])/(ycellsize*ycellsize);
    output[i*ncols+j]=-2*(d+e)*100;
  }
 }

}


void slopeAspect(int ncols, int nrows, float xcellsize, float ycellsize,
		    float* input, float* outputS, float *outputA , int ldx)
{

  int i,j;
#pragma omp for private(j)
  for (i=1; i<nrows-1; i++) {
    for (j=1; j<ncols-1; j++) {
      float dzdx=( (input[(i-1)*ncols+j+1] + 2.0*input[i*ncols+j+1] + input[(i+1)*ncols+j+1])
		   - (input[(i-1)*ncols+j-1] + 2.0*input[i*ncols+j-1] + input[(i+1)*ncols+j-1]))/(8.0);
      float dzdy=( (input[(i+1)*ncols+j-1] + 2.0*input[(i+1)*ncols+j] + input[(i+1)*ncols+j+1])
		   - (input[(i-1)*ncols+j-1] + 2.0*input[(i-1)*ncols+j] + input[(i-1)*ncols+j+1]))/(8.0);

      outputA[i*ncols+j]=atan2(dzdy,-dzdx)*RADTODEG;
      
      dzdx/=xcellsize;
      dzdy/=ycellsize;

      float rise_run=sqrt(dzdx*dzdx+dzdy*dzdy);
      outputS[i*ncols+j]=atan(rise_run)*RADTODEG;

    }
  }    

}





int main(int argc, char *argv[])
{



    int             nBlockXSize, nBlockYSize;
    int             bGotMin, bGotMax;
    double          adfMinMax[2];
    float xcellsize,ycellsize;
    int   nXSize,nYSize;
        

      float *pafScanline;
      float *outData1;
      float *outData2;
      

      nXSize = atoi(argv[1]);
      nYSize = atoi(argv[2]);
      
      xcellsize=22.5 ;
      ycellsize=22.5 ;

      int ald=ALIGNSIZE/sizeof(float);


      int ldx=nXSize;

      int ii,j;




      int i;

      double t1,t2,ts=0.0;
      int nrep=atoi(argv[3]);
      int im;
      t1=1.0e+30;

     for(i=0;i<nrep;i++)  
	 {

      pafScanline =  malloc(sizeof(float)*ldx*nYSize);
      outData1 = malloc(sizeof(float)*ldx*nYSize);
      outData2 = malloc(sizeof(float)*ldx*nYSize);


      #pragma omp parallel for private(j)
      for(ii=0;ii<nYSize;ii++)
        for(j=0;j<nXSize;j++)
          pafScanline[ii*nXSize+j]=12.5f;

          t2=omp_get_wtime();
     

      #pragma omp parallel
      {

         // curvature(nXSize,nYSize,xcellsize,ycellsize,pafScanline,outData1,ldx);

	  slopeAspect(nXSize,nYSize,xcellsize,ycellsize,pafScanline,outData1,outData2,ldx);

	 }
          t2=omp_get_wtime()-t2;
          if(t2<t1){
            t1=t2;
            im=i;
          }
          ts+=t2;

      free(pafScanline);
      free(outData1);
      free(outData2);

      }

    //  printf("min time = %lf (%d) avg=%lf \n",(t1),im,ts/nrep);

      printf("%6d %6d  %10.6lf  %10.6lf \n",nXSize,nYSize,ts/nrep,t1);
        

}

