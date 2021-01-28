#include<stdio.h>
int main(){
	int array[5];
	int i,min,max;
	printf("input : ");

	for(i=0;i<5;i++){
		scanf("%d",&array[i]);
	}
    max=array[0];
	min=array[0];
	for(i=0;i<5;i++){
		if(array[i]>=max){
			max=array[i];
		}
		else if(array[i]<=min){
			min=array[i];
		}
	}

	printf("최댓값 : %d\n",max);
	printf("최소값 : %d\n",min);
	return 0;
}