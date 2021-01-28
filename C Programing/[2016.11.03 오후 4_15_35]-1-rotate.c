#include<stdio.h>
int main(){
	int array1[2][4] ={1,2,3,4,5,6,7,8};
	int array2[4][2];
	int i,j;

	for(i=0;i<4;i++){
		for(j=0;j<2;j++){
			array2[j][1-i]=array1[i][j];
		}
	}
	for(i=0;i<4;i++){
		for(j=0;j<2;j++){
			printf("%5d",array2[i][j]);
			printf("\n");
		}
	}
	return 0;
}