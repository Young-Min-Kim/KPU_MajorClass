//키보드의 Enter 키가 입력될 때까지 문자들을 읽고
//입력된 문자열에서 문자 'x'의 개수를 화면에 출력하는 프로그램
#include<iostream>
using namespace std;
int main() {
	cout << "문자 입력(100개 미만) : ";
	char letter[100];//문자열을 넣어줄 공간이 100인 배열 letter선언

	cin.getline(letter, 100, '\n');//최대 99개의문자를읽어 letter배열에 저장하고 도중에 <Enter> 키를만나면 입력 중단
	
	int i,count=0;//for문을 위한 변수 i 선언 ,count에 x의 개수 저장
	for (i = 0; letter[i] != '\0'; i++)//널문자를 만나면 중단하는 for문
	{
		if (letter[i] == 'x')
			count++;//x의 개수 세기
	}
	
	cout << "x의 개수는 " << count << "개 입니다.";
}