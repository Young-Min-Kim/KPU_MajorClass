// "yes"가 입력될 때까지 종료되지 않는 프로그램
#include<iostream>
#include<string>//string 클래스를 사용하기 위한 헤더 파일
using namespace std;
int main()
{
	string answer;
	int a=0;
	string want_answer("yes");//문자열 want_answer
	while (1)//while문 무한루프
	{
		cout << "종료하고싶으면 yes를 입력하세요.>> ";
		
		getline(cin, answer);//getline()으로 string 타입의 문자열을 입력

		if (answer == want_answer) {
			break;//정답이면 무한루프 종료

		}

	}
	cout << "종료합니다...";

}
