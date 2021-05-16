dzy #include <math.h>
#include <string.h>
#include <openacc.h>
#include <omp.h>
#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <malloc.h>



int main(void){
    // Deklaracja zmiennych
    int wier = 25000;
    int col = 25000;
    int **tab;
    int **tab2;
    int **sum;
    int **sum2;
    int **min_max;
    int temp, min_element, max_element, current_element;

    // Pobranie danych
    // printf("Wiersze: ");
    // scanf("%d", &wier);
    // printf("\nKolumny: ");
    // scanf("%d", &col);



    // Alokacja pamięci dla tablicy dwuwymiarowej 1
    tab=(int**)malloc(col*sizeof(int*)); // alokacja pamięci dla wierszy
    for(int i=0; i<col; i++)
        tab[i]=(int*)malloc(wier*sizeof(int)); // alokacja pamięci dla kolumn

    // Alokacja pamięci dla tablicy dwuwymiarowej 2
    tab2=(int**)malloc(col*sizeof(int*)); // alokacja pamięci dla wierszy
    for(int i=0; i<col; i++)
        tab2[i]=(int*)malloc(wier*sizeof(int)); // alokacja pamięci dla kolumn

    // Alokacja pamięci dla tablicy dwuwymiarowej sum
    sum=(int**)malloc(col*sizeof(int*)); // alokacja pamięci dla wierszy
    for(int i=0; i<col; i++)
        sum[i]=(int*)malloc(wier*sizeof(int)); // alokacja pamięci dla kolumn

  // Alokacja pamięci dla tablicy dwuwymiarowej min_max
    min_max=(int**)malloc(col*sizeof(int*)); // alokacja pamięci dla wierszy
    for(int i=0; i<col; i++)
        min_max[i]=(int*)malloc(wier*sizeof(int)); // alokacja pamięci dla kolumn

         // Alokacja pamięci dla tablicy dwuwymiarowej sum2
    sum2=(int**)malloc(col*sizeof(int*)); // alokacja pamięci dla wierszy
    for(int i=0; i<col; i++)
        sum2[i]=(int*)malloc(wier*sizeof(int)); // alokacja pamięci dla kolumn


    //random
    srandom( (unsigned) time(NULL) );



    double runtime = omp_get_wtime();


    // Przypisanie wartości dla tablicy 1
        for(int i=0 ; i<col ; i++)
        for(int j=0 ; j<wier ; j++)
            tab[i][j] = random( )%100;
  // Przypisanie wartości dla tablicy  2
    for(int i=0 ; i<col ; i++)
        for(int j=0 ; j<wier ; j++)
            tab2[i][j] = random( )%100;


    runtime = omp_get_wtime() - runtime;
    printf(" Czas wykonania wczytania plikow: %f s\n", runtime);

    acc_init(acc_device_nvidia);


    //dodawanie zamienilem col na wier !!!!!!!!

    double runtime2 = omp_get_wtime();

   // #pragma acc kernels
    //#pragma acc parallel
   #pragma acc loop
    for (int c = 0; c < col; c++) {
        #pragma acc parallel  loop
      for (int d = 0 ; d < wier; d++) {

         sum[c][d] = tab[c][d] + tab2[c][d];
         //printf("%d\t", sum[c][d]);
      }
     // printf("\n");
   }


   //min - max z wybranej tablicy


   min_element = min_max[0][0];
        max_element = min_max[0][0];

       // #pragma acc data copyin(sum) copyout(sum2)

        //#pragma acc parallel
        #pragma acc loop
        for (int i = 0; i < col; i++) {
            #pragma acc parallel loop
            for (int j = 0; j < wier; j++) {
                current_element = sum2[i][j];
                if (min_element > current_element)
                    min_element = current_element;
                if (max_element < current_element)
                    max_element = current_element;
            }
        }


    runtime2 = omp_get_wtime() - runtime2;


    printf(" Czas wykonania dodawania i wyznaczania max-min: %f s\n", runtime2);
    //  printf("Max element: %d \n", max_element);
    //  printf("Min element: %d \n", min_element);




    // // Wypisywanie wartości
    // for(int i=0 ; i<wier ; i++){
    //     for(int j=0 ; j<col ; j++){
    //         printf("%d", tab[i][j]);
    //     }
    //     printf("\n");
    // }

    // Czyszczenie pamięci
    for(int i=0; i<col; i++){
        free(tab[i]);
        free(tab2[i]);
        free(sum[i]);
        // free(min_max[i]);
    }
    free(tab);
    free(tab2);
    free(sum);
    // free(min_max);
    return 0;
}
