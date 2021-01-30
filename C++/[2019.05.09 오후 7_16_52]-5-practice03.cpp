//함수 big()을 호출하는 프로그램
// big() 함수를 2개 중복하여 작성

#include<iostream>
using namespace std;

int big(int a, int b)
{
	int x;
	x = (a > b) ? a : b;
	return (x < 100) ? x : 100;
}
int big(int a, int b, int m)//중복 작성
{
	int x;
	x = (a > b) ? a : b;
	return (x < m) ? x : m;
}



int main() {
	int x = big(3, 5); // 3과 5 중 큰 값 5는 최대값 100보다 작으므로, 5 리턴
	int y = big(300, 60); // 300과 60 중 큰 값 300이 최대값 100보다 크므로, 100 리턴
	int z = big(30, 60, 50); // 30과 60 중 큰 값 60이 최대값 50보다 크므로, 50 리턴
	cout << x << ' ' << y << ' ' << z << endl;
}