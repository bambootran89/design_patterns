#include<stdio.h>
#include<stdlib.h>
#define max 100

void* *AlocateObject[max];

int count =0;

int main(){
 int *a = (int *) malloc(sizeof (int));
 AlocateObject[count++] = (void*)a;
 double *b = (double *) malloc (sizeof(double));


 
 AlocateObject[count++] = (void*)b;

 char * ch = ( char*) malloc (sizeof(float));
 AlocateObject[count++] = (void*)ch;

 float *c = (float *) malloc (sizeof(float));
 AlocateObject[count++] = (void*)c;  
 
 *a = 123;

 *b= 1234.45;
 *c = 343.3;

 *ch = 'd';
 printf(" main testing %d --- %lf \n", *a, *b);
 int i;

 for ( i = 0; i<=count; i++){
     free(AlocateObject[i]);
 }
return 0;
}
