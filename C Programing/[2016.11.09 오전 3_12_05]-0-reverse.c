#include<stdio.h>
	int main(){
		int i;
		int ary[5] = { 1, 2, 3, 4, 5 };
		printf("처음 값 : ");
		for (i = 0;i < 5;i++) {
			printf("%d", ary[i]);
		}
		printf("\n");
		printf("나중 값 : ");
		for (i = 4;i >= 0;i--) {
			printf("%d", ary[i]);
		}
		printf("\n");
}