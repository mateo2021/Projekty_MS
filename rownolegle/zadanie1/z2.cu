#include<stdio.h>
#include<cuda.h>
#include<time.h>
__global__ void zad2(float *a,float *b,float *c, int N)
{
 int idx = blockIdx.x * blockDim.x + threadIdx.x;
 if(idx<N) c[idx] = a[idx] + b[idx];
}

int main(void)
{
clock_t t1,t2,t5,t6,t7,t8;
float *a_h,*b_h,*c_h;
float *a_d,*b_d,*c_d;
const int N = 50000000;

size_t size = N * sizeof(float);
t1=clock();
a_h = (float *)malloc(size);
b_h = (float *)malloc(size);
c_h = (float *)malloc(size);
cudaMalloc((void **) &a_d,size);
cudaMalloc((void **) &b_d,size);
cudaMalloc((void **) &c_d,size);
t2=clock();

for(int i=0;i<N;i++)
{
 a_h[i]=(float)(i+1);
 b_h[i]=(float)(i+1);
 c_h[i]=(float)(i+1);
}
cudaEvent_t start, stop;
float time;
cudaEventCreate(&start);
cudaEventCreate(&stop);

t5=clock();
cudaMemcpy(a_d,a_h,size,cudaMemcpyHostToDevice);
cudaMemcpy(b_d,b_h,size,cudaMemcpyHostToDevice);
cudaMemcpy(c_d,c_h,size,cudaMemcpyHostToDevice);
t6=clock();

int block_size = 1024;
int n_blocks = N/block_size + (N%block_size == 0 ? 0:1);

cudaEventRecord(start, 0);
zad2<<<n_blocks,block_size>>>(a_d,b_d,c_d,N);
cudaEventRecord(stop, 0);
cudaEventSynchronize(stop);

t7=clock();
cudaMemcpy(a_h,a_d,size,cudaMemcpyDeviceToHost);
cudaMemcpy(b_h,b_d,size,cudaMemcpyDeviceToHost);
cudaMemcpy(c_h,c_d,size,cudaMemcpyDeviceToHost);
t8=clock();

//for(int i=0;i<N;i++)
//{
//printf("%d rekord to: %f\n",i,c_h[i]);
//}

printf("Czas alokowania danych: %f s\n",(float)(t2-t1)/CLOCKS_PER_SEC);

printf("Czas przesyłu danych: %f s\n",(float)((t6-t5)+(t8-t7))/CLOCKS_PER_SEC);
free(a_h);
free(b_h);
free(c_h);
cudaFree(a_d);
cudaFree(b_d);
cudaFree(c_d);
cudaEventElapsedTime(&time, start, stop);
printf ("Czas wykonania dodawania wektorów: %f ms\n", time);

}


