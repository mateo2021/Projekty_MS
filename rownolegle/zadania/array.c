#include <math.h>
#include <string.h>
#include <openacc.h>
#include <omp.h>
#include <stdio.h>
#include <time.h>
#include <stdlib.h>

// void multiply(int mat1[][N], int mat2[][N], int res[][N]) 
// { 
//     int i, j, k; 
//     for (i = 0; i < N; i++) 
//     { 
//         for (j = 0; j < N; j++) 
//         { 
//             res[i][j] = 0; 
//             for (k = 0; k < N; k++) 
//                 res[i][j] += mat1[i][k]*mat2[k][j]; 
//         } 
//     } 
// } 

int main(){
   /* 2D array declaration*/


   int a = 25000;
   int b = 25000;
   int disp[a][b];
   int disp2[a][b];
   

   int sum[a][b];
   /*Counter variables for the loop*/

     srandom( (unsigned) time(NULL) );

    double runtime3 = omp_get_wtime();

    double runtime = omp_get_wtime();
     
    int i, j;

 
   for(i=0; i<a; i++) {
      for(j=0;j<b;j++) {

        disp[i][j]=random( ) ;
        disp2[i][j]=random( ) ;

        //  printf("Enter value for disp[%d][%d]:", i, j);
        //  scanf("%d", &disp[i][j]);
      }
   }


     runtime = omp_get_wtime() - runtime;
 
    printf(" Czas wykonania: %f s\n", runtime);

 //printf("Sum of entered matrices:-\n");

  acc_init(acc_device_nvidia); 


double runtime2 = omp_get_wtime();
    int c,d;

    // #pragma acc data ...

   // #pragma acc kernels  
      #pragma acc loop
   for (c = 0; c < a; c++) {
      #pragma acc parallel loop
      for (d = 0 ; d < b; d++) {
         sum[c][d] = disp[c][d] + disp2[c][d];
         //printf("%d\t", sum[c][d]);
      }
     // printf("\n");
   }
  runtime2 = omp_get_wtime() - runtime2;
 
    printf(" Czas wykonania dodawania : %f s\n", runtime2);



     runtime3 = omp_get_wtime() - runtime3;
 
    printf(" Czas całkowity: %f s\n", runtime3);


    // int c;
    // int d;
    // int res[c][d]; // To store result 
    // int x, y; 
    // multiply(disp, disp2, res); 
  
    // printf("Result matrix is \n"); 
    // for (x = 0; x < c; x++) 
    // { 
    //     for (y = 0; y < d; y++) 
    //        printf("%d ", res[x][y]); 
    //     printf("\n"); 
    // } 
  

   //Displaying array elements
//    printf("Two Dimensional array elements:\n");
//    for(i=0; i<a; i++) {
//       for(j=0;j<b;j++) {
//          printf("%d ", disp[i][j]);
//          if(j==b){
//             printf("\n");
//          }
//       }
//    }
   return 0;
}