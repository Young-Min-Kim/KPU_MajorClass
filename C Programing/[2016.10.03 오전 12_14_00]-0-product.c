#include<stdio.h>

int main() {


	int a, count = 0;
	int b;

	printf("양의 정수 입력 : ");
	scanf("%d", &b);

	a = b;

	while (a <= 100) {
		printf("%3d\n", a);
		
	
		a = a + b;
		count++;
		
	}
	printf("%d의 개수 : %d\n", b, count);

	return 0;
}