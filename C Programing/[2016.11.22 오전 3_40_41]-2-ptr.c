#include<stdio.h>
void str_print(char**,int);

int main() {
	char *ptr[] = { "Wonderful", "New", "World"};
	str_print(ptr,sizeof(ptr)/sizeof(ptr[0]));

	return 0;
}
void str_print(char**p,int size) {
	int i;
	for (i = 0;i < size;i++)
		printf("%s\n", *(p + i));

}