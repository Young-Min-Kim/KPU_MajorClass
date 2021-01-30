//중식당의 주문과정을 프로그램으로 구현
#include<iostream>
using namespace std;

int main()
{
	cout << "***** 동춘원에 오신 것을 환영합니다. ***** \n";
	int menu,num;//manu : 메뉴를 정할 숫자를 저장할 변수 //num : 몇 인분인지 저장

	while (1) {
		cout << "짬뽕 : 1, 짜장 : 2, 군만두 : 3, 종료 : 4 >>";//메뉴 선택
		cin >> menu;
	
		if (menu == 4)//if 문으로 분기를 나눠서 메뉴와 종료 명령 수행
		{
			cout << "오늘 영업은 끝났습니다.\n";
			return 0;
		}
		if (menu == 1)
		{
			cout << "몇 인분? : ";
			cin >> num;
			cout << "짬뽕 " << num << "인분 나왔습니다\n";
		}
		else if (menu == 2)
		{
			cout << "몇 인분? : ";
			cin >> num;
			cout << "짜장 " << num << "인분 나왔습니다\n";
		}
		else if (menu == 3)
		{
			cout << "몇 인분? : ";
			cin >> num;
			cout << "군만두 " << num << "인분 나왔습니다\n";
		}
		else if (menu!=1||2||3||4)//예외 구문시 출력
		{
			cout << "다시 주문하세요!!\n";
		}

	}
}