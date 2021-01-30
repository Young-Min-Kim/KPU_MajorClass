//cout과 << 연산자를 이용하여 다음과 같이 구구단을 출력하는 프로그램
#include<iostream>
using namespace std;

int main()
{
	int i, j; //이중 for문 변수 선언
	for (i = 1; i < 10; i++)//이중 for문
	{
		for (j = 1; j < 10; j++)
		{
			cout << j << "*" << i << "=" << i * j<<"\t";//곱샘 후 탭으로 분리
		}
		cout << "\n";// 개행
	}

}
