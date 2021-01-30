//반복문을 이용해서 개행할때마다 하나씩 늘어나는 *출력
#include <iostream>
using namespace std;
int main()
{
	int i,j; //이중 for문 변수 선언
	for (i = 1 ; i < 6 ; i++)//이중 for문
	{
		for (j = 0; j < i; j++)
		{
			cout << "*";
		}
		cout << "\n";//각 줄을 출력하면 개행
	}
}
