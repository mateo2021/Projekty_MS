#include<stdio.h>
#include<cuda.h>
#include<time.h>
#include<math.h>

__global__ void zad3(float *a,float *b,float *c, int N)
{
 int idx = blockIdx.x * blockDim.x + threadIdx.x;
 if(idx<N) c[idx] = a[idx] + b[idx];
}

int main(void)
{

clock_t t1,t2;
float *a_h,*b_h,*c_h;
float *a_d,*b_d,*c_d;
const int N = 50000000;
cudaEvent_t start1,start2,start3,start4,start5,stop1,stop2,stop3,stop4,stop5;
float time1,time2,time3,time4,time5;

cudaEventCreate(&start1);
cudaEventCreate(&start2);
cudaEventCreate(&stop1);
cudaEventCreate(&stop2);
cudaEventCreate(&stop3);
cudaEventCreate(&stop4);
cudaEventCreate(&stop5);
cudaEventCreate(&start3);
cudaEventCreate(&start4);
cudaEventCreate(&start5);

size_t size = N * sizeof(float);

t1=clock();
cudaMallocHost((void**)&a_h,size);  //alokowanie na hoscie (pamiec przypinana)
cudaMallocHost((void**)&b_h,size);
cudaMallocHost((void**)&c_h,size);

cudaMalloc((void **) &a_d,size);   //alokowanie pamieci na device 
cudaMalloc((void **) &b_d,size);
cudaMalloc((void **) &c_d,size);
t2=clock();

for(int i=0;i<N;i++)
{
 a_h[i]=(float)(i+1);
 b_h[i]=(float)(i+1);
 c_h[i]=(float)(i+1);
}

cudaStream_t strumien1, strumien2;
cudaStreamCreate(&strumien1);
cudaStreamCreate(&strumien2);

cudaEventRecord(start3, 0);
cudaMemcpyAsync(a_d,a_h,size/2,cudaMemcpyHostToDevice,strumien1);
cudaMemcpyAsync(b_d,b_h,size/2,cudaMemcpyHostToDevice,strumien1);
cudaMemcpyAsync(c_d,c_h,size/2,cudaMemcpyHostToDevice,strumien1);
cudaEventRecord(stop3, 0);
cudaEventSynchronize(stop3);

cudaEventRecord(start1, 0);
 zad3<<<N/2/N+1,N,0,strumien1>>>(a_d,b_d,c_d,N/2);
cudaEventRecord(stop1, 0);
cudaEventSynchronize(stop1);

cudaEventRecord(start4, 0);
cudaMemcpyAsync(a_h,a_d,size/2,cudaMemcpyDeviceToHost,strumien1); 
cudaMemcpyAsync(b_h,b_d,size/2,cudaMemcpyDeviceToHost,strumien1); 
cudaMemcpyAsync(c_h,c_d,size/2,cudaMemcpyDeviceToHost,strumien1);
cudaMemcpyAsync(a_d+N/2,a_h+N/2,size/2,cudaMemcpyHostToDevice,strumien2);
cudaMemcpyAsync(b_d+N/2,b_h+N/2,size/2,cudaMemcpyHostToDevice,strumien2);
cudaMemcpyAsync(c_d+N/2,c_h+N/2,size/2,cudaMemcpyHostToDevice,strumien2);
cudaEventRecord(stop4, 0);
cudaEventSynchronize(stop4);

cudaEventRecord(start2, 0);
zad3<<<N/2/N+1,N,0,strumien2>>>(a_d+N/2,b_d+N/2,c_d+N/2,N/2);
cudaEventRecord(stop2, 0);
cudaEventSynchronize(stop2);

cudaEventRecord(start5, 0);
cudaMemcpyAsync(a_h+N/2,a_d+N/2,size/2,cudaMemcpyDeviceToHost,strumien2);
cudaMemcpyAsync(b_h+N/2,b_d+N/2,size/2,cudaMemcpyDeviceToHost,strumien2);
cudaMemcpyAsync(c_h+N/2,c_d+N/2,size/2,cudaMemcpyDeviceToHost,strumien2);
cudaEventRecord(stop5, 0);
cudaEventSynchronize(stop5);

printf("Czas alokowania danych: %f s\n",(float)(t2-t1)/CLOCKS_PER_SEC);
//printf("Czas przesyłu danych: %f s\n",(float)(((t4-t3)+(t6-t5)+(t8-t7)))/CLOCKS_PER_SEC);

cudaStreamDestroy(strumien1);
cudaStreamDestroy(strumien2);
cudaFreeHost(a_h);
cudaFreeHost(b_h);
cudaFreeHost(c_h);
cudaFree(a_d);
cudaFree(b_d);
cudaFree(c_d);

cudaEventElapsedTime(&time1, start1, stop1);
cudaEventElapsedTime(&time2, start2, stop2);
cudaEventElapsedTime(&time3, start3, stop3);
cudaEventElapsedTime(&time4, start4, stop4);
cudaEventElapsedTime(&time5, start5, stop5);

printf ("Czas wykonania dodawania wektorów: %f ms\n", time1+time2);
printf("Czas przesyłu danych: %f ms\n",time3+time4+time5);

}


