//중복된 생성자를 디폴트 매개 변수를 가진 하나의 생성자로 작성하고 테스트하는 프로그램
#include <iostream>
using namespace std;
class MyVector {
	int *mem;
	int size;
public:
	MyVector(int n, int val);
	~MyVector() { delete[]mem; }
};

MyVector::MyVector(int n=100, int val=0) {//디폴드 매개 변수를 설정해준다.
	mem = new int[n];
	size = n;
	for (int i = 0; i < size; ++i) {
		mem[i] = val;
		cout << mem[i] << ' ';
	}
	cout << endl;
}

int main() {

	MyVector a;
	MyVector b(5, 10);
}