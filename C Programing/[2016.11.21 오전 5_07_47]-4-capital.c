#include<stdio.h>
int main(){
	char str[40] ="1234 Banana Good";
	int i,a;
	printf("1234 Banana Good\n");
	for (i = 0;i < 40;i++) {
		if (str[i] >= 97 && str[i] <= 122) {

			str[i] = str[i] - 32;
		}

		printf("%c", str[i]);
	}
	printf("\n");
	return 0;


}