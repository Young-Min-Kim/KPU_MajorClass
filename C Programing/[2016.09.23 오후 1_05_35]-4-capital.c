#include<stdio.h>

int main(){
	
	char alp ,cap;
	
	printf("소문자 입력 :");
	scanf("%c",&alp);
	
	cap = alp-32;

	printf("대문자 : %c\n",cap);
	
	return 0;
}