#include<stdio.h>
int mylength(char *);
int main(){
    char str1[80]="house";
    char str2[]="home";
    char *p1="building";

    printf("%s, 크기 :%d, 길이 : %d\n",str1,sizeof(str1),mylength(str1));
    printf("%s, 크기 :%d, 길이 : %d\n",str1,sizeof(str2),mylength(str2));
    printf("%s, 크기 :%d, 길이 : %d\n",p1,sizeof(p1),mylength(p1));

    return 0;


}
int mylength(char p[]){
	int length=0;
		while(*p){
		   p++;
		   length++;
		}
}