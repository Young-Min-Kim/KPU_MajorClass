#include<stdio.h>

int main(){
	int mon , price , ob , b ,os , s;

	printf("넣은 돈 입력 : ");
	scanf("%d",&mon);
	printf("음료수 값 입력 : ");
	scanf("%d",&price);

	ob = (mon - price)/500;
	b = (mon - price)%500/100;
	os = (mon - price)%500%100/50;
	s = (mon - price)%500%100%50/10;

	printf("500원 : %d , 100원 : %d , 50원 : %d , 10원 :%d ",ob,b,os,s);


return 0;
}