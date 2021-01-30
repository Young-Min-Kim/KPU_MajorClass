//동일한 크기로 배열을 변환하는 다음 2개의 static 멤버 함수를 가진 ArrayUtility 클래스를 작성
#include<iostream>
using namespace std;

class ArrayUtility {
public:
	static void intToDouble(int source[], double dest[], int size)
	{
		for (int i = 0; i < size; i++)
		{
			dest[i] = source[i];// double형이 int형보다 크므로 강제 형변환하지 않아도 된다.
		}
	}
	static void doubleToInt(double source[], int dest[], int size)
	{
		for (int i = 0; i < size; i++)
		{
			dest[i] = (int)source[i];//double을 int형으로 형변환 해준 후 대입
		}
	}
};



int main() {
	int x[] = { 1,2,3,4,5 };
	double y[5];
	double z[] = { 9.9,8.8,7.7,6.6,5.6 };
	ArrayUtility::intToDouble(x, y, 5); // x[] -> y[]
	for (int i = 0; i < 5; ++i) cout << y[i] << ' ';
	cout << endl;
	ArrayUtility::doubleToInt(z, x, 5); // z[] -> x[]
	for (int i = 0; i < 5; ++i) cout << x[i] << ' ';
	cout << endl;
}
