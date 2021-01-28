#include<stdio.h>
int main(){
	int array[3][3];
	int i,j;
	int total=0;

	for(i=0;i<3;i++){
		for(j=0;j<3;j++){
			printf("%d층 %d호 가족은 몇 명입니까?: ",i+1,j+1);
			scanf("%d",&array[i][j]);
			total+=array[i][j];

		}
	}
	printf("열혈아파트 총 인구수는 %d명입니다.\n",total);
	return 0;
}