//add() 함수를 호출하는 main() 함수는 다음과 같다. 아래의 요구사항을 만족하는 프로그램
//add() 함수를 중복 작성
#include<iostream>
using namespace std;

int add(int a[], int n) {
	int sum = 0;
	for (int i = 0; i < n; ++i)
		sum = a[i]+ sum;
	return sum;
}
int add(int a[], int n, int b[]) {//중복 작성
	int sum = 0;
	for (int i = 0; i < n; ++i)
		sum = sum + a[i] + b[i];
	return sum;
}


int main() {
	int a[] = { 1,2,3,4,5 };
	int b[] = { 6,7,8,9,10 };
	int c = add(a, 5); // 배열 a의 정수를 모두 더한 값 리턴
	int d = add(a, 5, b); // 배열 a와 b의 정수를 모두 더한 값 리턴
	cout << c << endl; // 15 출력
	cout << d << endl; // 55출력
}