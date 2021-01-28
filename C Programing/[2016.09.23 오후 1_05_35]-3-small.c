#include<stdio.h>

int main(){
int a,b ,c;
printf("첫번째 숫자 입력 : ");
scanf("%d",&a);

printf("두번째 숫자 입력 : ");
scanf("%d",&b);

c=(a>b)?b : a ;
(a!=b)? printf("더 작은 숫자 : %d",c) : printf("같음");

return 0;

}