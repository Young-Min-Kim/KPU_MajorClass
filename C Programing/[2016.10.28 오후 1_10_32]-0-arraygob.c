#include<stdio.h>
int main(void){
	int i;
	double array1[5] = {2.2, 3.5, 2.5, 10.1, 4.0};
	double array2[5] = {3.3, 2.0, 4.0 ,1.0, 2.5};

	for(i=0; i<5; i++)
	{
		printf("%f\n",array1[i]*array2[i]);
	}

	return 0;
}