//커피 주문 단계를 c++프로그램으로 작성
#include <iostream>
using namespace std;
int total;//모든 피용의 합산한 값을 저장, if문을 빠져놔와도 값을 유지해야 하기때문에 전역변수로 설정
int main()
{
	char coffie[100];//입력할 커피 문자열 저장
	int num;//입력할 커피 잔 수 저장
	int cost;//계산한 비용 저장

	
	
	while (1) {
		cout << "에스프레소 2000원, 아메리카노 2300원, 카푸치노 2500원입니다. : \n주문>>";
		cin >> coffie >> num;//커피 이름 저장 ,커피잔 수 저장

		if (strcmp(coffie, "에스프레소") == 0)//strcmp()로 입력한문자열이 일치하는지 비교
		{
			cost = num * 2000;//비용 계산
			total = total + cost;//지금까지 든 총 비용 계산
			cout << cost << "원입니다. 맛있게 드세요\n";

		}
		else if (strcmp(coffie, "아메리카노") == 0)//strcmp()로 입력한문자열이 일치하는지 비교
		{
			cost = num * 2300;//비용 계산
			total = total + cost;//지금까지 든 총 비용 계산
			cout << cost << "원입니다. 맛있게 드세요\n";
		}
		else if (strcmp(coffie, "카푸치노") == 0)//strcmp()로 입력한문자열이 일치하는지 비교
		{
			cost = num * 2500;//비용 계산
			total = total + cost;//지금까지 든 총 비용 계산
			cout << cost << "원입니다. 맛있게 드세요\n";
		}
		else
		{
			cout << "없는 커피입니다. 다시 입력해주세요.\n";//예외 문항 설정
		}

		if (total > 22200)
		{
			cout << "오늘 222000원을 판매하여 카페를 닫습니다. 내일 봐요~~~\n";//총합이 222000원이 넘으면 while문을 빠져나온다.
			break;
		}

	}

}