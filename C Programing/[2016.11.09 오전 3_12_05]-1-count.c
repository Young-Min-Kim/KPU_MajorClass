#include<stdio.h>
int main() {
	int ary[] = { 1, 2, 5, 6, 19, 18, 13, 6, 7, 8, 4, 5, 20, 4, 4, 1, 16, 17, 9,
		18, 19, 17, 20, 18, 5, 6, 3, 7, 20, 19, 20 };
	int i, k=0,j;
	for (j = 1;j < 21;j++){
		for (i = 0;i < 20;i++) {
			if (ary[i] == j) {
				k = k + 1;
			}
		}
		printf("%d인 숫자 개수 : %d \n",j,k);
		k = 0;
	}
	return 0;
}