#include<stdio.h>
int main(){
   int i,j,k=0;
   char *ptr[]={"Wonderful", "New", "World"};
   char str[80];

   for(i=0;i<sizeof(ptr)/sizeof(ptr[0]);i++){
	   for(j=0;ptr[i][j]!=0;i++){
	      str[k]=*(*ptr);
		  k++;
	   }
   }
   str[k]='\0';
   printf("%s\n",str);
   return 0;
}