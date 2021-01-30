//소수점을 포함한 5개의 실수를 입력 받아 제일 큰 수를 화면에 출력하는 프로그램
#include<iostream>
using namespace std;


int main()
{
	double num[5];//입력한 실수를 저장할 배열 선언
	int i;//for문 변수 선언
	
	cout << "실수 5개 입력\n>> ";
	for(i = 0; i < 5;i++ )
	{
		cin >> num[i];//i에 입력한 실수 저장
	}
	i = 0;//i값 초기화


	double max ;
	max = num[0];//최댓값을 저장해줄 max변수 선언

	for (i = 0; i < sizeof(num)/sizeof(double); i++)//sizeof(num)/sizeof(double)는 계산하면 5
	{
		if (num[i] > max)//num이 max값보다 크면 max에 num을 넣어준다.
		{
			max = num[i];
		}
	}
	
	cout << "최댓값은 " << max << "입니다.";

	return 0;
}
