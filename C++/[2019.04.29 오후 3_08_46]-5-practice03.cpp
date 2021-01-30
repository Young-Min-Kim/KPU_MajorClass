#include<iostream>
using namespace std;

bool bigger(int a, int b, int& big)
{
	if (a == b)
		return true;
	else if (a > b) {
		big = a;
		return false;
	}
	else if (a < b)
	{
		big = b;
		return false;
	}
	
}

int main()
{
	int num1, num2;
	int big;
	cout << "두 개의 정수를 입력해주세요>>";
	cin >> num1 >> num2;
	if (bigger(num1, num2, big))
	{
		cout << "a와 b가 같습니다." << endl;
	}
	else
	{
		cout << "더 큰수>>" << big << endl;
	}

}