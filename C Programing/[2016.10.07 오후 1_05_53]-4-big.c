#include<stdio.h>
int main(){

int a,b;

printf("두 수 입력 : ");
scanf("%d",&a);
scanf("%d",&b);

if(a>b){
	printf("큰 수는 %d입니다.\n",a);
}
else if(a<b){
	printf("큰 수는 %d입니다.\n",b);
}
else if(a==b){
	printf("두 수는 같습니다.\n");
}

return 0;

}