#include<stdio.h>
int main(){

	int a,b;
	

 for(a=0;a<5;a++){
	 for(b=0;b<5;b++){
		 if(a==b){
			 printf(" ");
		 }
		 else{printf("*");
		 }
	 }
	 printf("\n");
 }
 return 0;

}