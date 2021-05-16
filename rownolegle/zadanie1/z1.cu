#include <stdio.h>
#include <cuda.h>
#include <time.h>



int main(void) {

int *a_h;
int *b_h;
int *c_h;
int N = 50000000;
size_t size = N * sizeof(int);

cudaEvent_t start,stop,start1,stop1;
float time,time1;
cudaEventCreate(&start);
cudaEventCreate(&stop);
cudaEventCreate(&start1);
cudaEventCreate(&stop1);


cudaEventRecord(start, 0);
 a_h = (int *)malloc(size);
 b_h = (int *)malloc(size);
 c_h = (int *)malloc(size);
cudaEventRecord(stop, 0);
cudaEventSynchronize(stop);


 for(int i = 0; i < N; i++){ 
	a_h[i] = i;
        b_h[i]= i;
        c_h[i]=i;
	}
cudaEventRecord(start1, 0);
 for(int i = 0; i < N;i++){
         c_h[i]=a_h[i]+b_h[i];
  }
cudaEventRecord(stop1, 0);
cudaEventSynchronize(stop1);


//printf("czas alokowania %f \n",(float)(t2-t1)/CLOCKS_PER_SEC);
//printf("czas wykonywania programu %f \n",(float)(t4-t3)/CLOCKS_PER_SEC);
 free(a_h);
 free(b_h);
 free(c_h);

cudaEventElapsedTime(&time1, start1, stop1);
 printf("Czas wykonania programu: %f ms\n",time1);
cudaEventElapsedTime(&time, start, stop);
 printf("Czas alokowania: %f ms\n",time);
 return 0;
}
