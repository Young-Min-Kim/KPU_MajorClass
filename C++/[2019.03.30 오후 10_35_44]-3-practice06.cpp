//한 라인에 ';'으로 5개의 이름을 구분하여 입력받아, 각 이름을 끊어내어 화면에 출력하고 가장 긴 이름을 판별하는 프로그램
#include<iostream>
using namespace std;

int main()
{
	cout << "5 명의 이름을 ';'으로 구분하여 입력하세요\n>>";

	char name[100];//5명의 이름을 넣을 배열 선언
	char temp[100];//임시로 이름을 넣을 배열 선언
	int len = 0;//이름의 길이를 저장하는 변수 선언
	int i;//for문을 위한 변수 선언
	
	for (i = 1; i < 6; i++)
	{
		cin.getline(name, 100, ';');//읽어들이다가 ';'를 만나면 if문을 처리하고 그전 문자열은 버린다.
		//다시 for문을 통해 getline을 실행하면 그다음 문자열부터';'를 만날때까지 문자열을 읽고 if문을 처리한 후 그 문자열을 버린다. 이렇게 for문을 반복한다.
		cout << i << " : " << name << "\n";//5명의 이름 출력
		if (len < strlen(name))//가장 긴 이름 선별
		{
			len = strlen(name);
			strcpy_s(temp, name);
		}
	}
	cout << "가장 긴 이름은 " << temp;//가장 긴 이름 출력

	
}


