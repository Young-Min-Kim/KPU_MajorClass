#include<stdio.h>
int main() {
	int ary[] = { 1,2,3,4,5,6,7,8,9,10 };
	int a, total=0;
	for (a = 0;a < 10;a++) {
		total = total + ary[a];
	}
	printf("total : %d\n", total);
	return 0;
}