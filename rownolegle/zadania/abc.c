#include <math.h>
#include <string.h>
#include <openacc.h>
#include <omp.h>
#include <stdio.h>
#include <time.h>
#include <stdlib.h>

int main( void )
{
   int i  = 0;

   int c =100000000;
   int a[c];

 

   int min;
   int max;

   srandom( (unsigned) time(NULL) );

for (i=0;i<c;i++)
       a[i]=random( ) ;

min = a[0];
max = a[0];

double runtime = omp_get_wtime();

 acc_init(acc_device_nvidia);   

 //#pragma acc kernels //error 700
//#pragma acc loop // 4.20s
#pragma acc parallel loop //3.80s
//#pragma acc loop reduction(max:error)
for (i=1;i<c;i++)
     {
      // printf("%d\n", a[i]);

       if (a[i] > max)
            {
          max = a[i];
            }
       else if (a[i] < min)
            {
          min = a[i];
            }
    }


    runtime = omp_get_wtime() - runtime;
 
    printf(" Czas wykonania: %f s\n", runtime);


             printf("Min: %d\n", min);
             printf("Max: %d\n", max);

return ( 0 ) ;
}