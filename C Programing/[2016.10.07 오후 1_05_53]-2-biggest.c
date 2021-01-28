#include<stdio.h>
int main(){

int a,b,c;

printf("정수 3개 입력 :");

scanf("%d",&a);
scanf("%d",&b);
scanf("%d",&c);

if(a>b&&a>c){
	printf("bigest : %d\n",a);
}
else if(b>a&&b>c){
	printf("bigest : %d\n",b);
}
else if(c>a&&c>b){
	printf("bigest : %d\n",c);
}
else if(a==b&&b==a&&c==a){
	printf("세 수가 모두 같습니다. : %d\n",a);
}
else if(a==b&&a>c){
	printf("bigest : %d\n",a);
}
else if(a==c&&a>b){
	printf("bigest : %d\n",a);
}
else if(b==c&&b>a){
	printf("bigest : %d\n",b);
}

return 0;
}