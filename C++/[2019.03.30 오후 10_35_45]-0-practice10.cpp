//영문 텍스트를 입력받아 알파벳 히스토그램을 그리는 프로그램
#include<iostream>
using namespace std;
int main()
{
	char buf[10000];//10000크기의 문장을 넣을 버퍼 설정
	cout << "영문 텍스트를 입력하세요. 히스토그램을 그립니다.\n텍스트의 끝은 ; 입니다. 10000개까지 가능합니다. \n";
	cin.getline(buf, 10000, ';');

	int i,n,num=0;//for문을 돌릴 i와 n 설정, num은 총 알파벳 수
	int alp[30];//각각의 알파벳의 개수를 저장할 배열
	for (n = 0; n < 26; n++)//배열 공간을 0으로 초기화
	{
		alp[n] = 0;
	}
	for (i = 0; buf[i] != '\0'; i++)
	{
		if (isalpha(buf[i]))//알파벳이면 if문 실행
		{
			if (buf[i] >= 65 &&buf[i <= 90])
			{
				buf[i] = tolower(buf[i]);//대문자를 소문자로 바꿔줘서 buf에 저장
			}
			alp[buf[i] - 97]++;//각각의 알파벳 수 증가
		
			num++;//총 알파벳 수 증가
		}
	}
	cout << "총 알파벳 수 " << num << "\n";
	i = 0;//for문 한번 더돋리기 위해 0으로 초기화
	int j = 0;//이중 for문을 위한 변수 선언
	for (i = 0; i < 26; i++)
	{
		cout << (char)(i + 97) << "(" << alp[i] << ")  :  ";//각각의 알파벳 개수 출력
		for (j = 0; j < alp[i]; j++)//개수만큼 * 출력
		{
			cout << "*";
		}
		cout << "\n";
	}


}
