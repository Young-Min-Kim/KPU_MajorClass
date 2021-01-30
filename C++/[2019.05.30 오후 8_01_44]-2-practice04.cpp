//LoopAdder클래스를 상속받아 다음 main()함수와 실행 결과처럼 되도록 WhileLoopAdder, DoWhileLoopAdder 클래스를 작성
#include <iostream>
#include <string>
using namespace std;
class LoopAdder { // 추상 클래스
	string name; // 루프의 이름
	int x, y, sum; // x에서 y까지의 합은 sum
	void read(); // x, y 값을 읽어 들이는 함수
	void write(); // sum을 출력하는 함수
protected:
	LoopAdder(string name = "") { // 루프의 이름을 받는다. 초깃값은 ""
		this->name = name;
	}
	int getX() { return x; }
	int getY() { return y; }
	virtual int calculate() = 0; // 순수 가상 함수 /이름은 같지만 다른 기능을 가진 함수를 실행
public:
	void run(); // 계산
};
void LoopAdder::read() { // x, y 입력
	cout << name << ":" << endl;
	cout << "처음 수에서 두번째 수까지 더합니다. 두 수를 입력하세요 >> ";
	cin >> x >> y;
}
void LoopAdder::write() { // sum 출력
	cout << x << "에서 " << y << "까지의 합 = " << sum << " 입니다" << endl;
}
void LoopAdder::run() {
	read(); // x, y를 읽는다.
	sum = calculate(); // 계산
	write(); // 결과 sum을 출력
}
class WhileLoopAdder : public LoopAdder {
protected:
	int calculate();
public:
	WhileLoopAdder(string name) : LoopAdder(name) {}
};
int WhileLoopAdder::calculate() {
	int sum = 0;
	int i = getX();
	while (i <= getY()) {
		sum += i;
		++i;
	}

	return sum;
}
class DoWhileLoopAdder : public LoopAdder {
protected:
	int calculate();
public:
	DoWhileLoopAdder(string name) : LoopAdder(name) {}
};
int DoWhileLoopAdder::calculate() {
	int sum = 0;
	int i = getX();
	do {
		sum += i;
		++i;
	} while (i <= getY());
	return sum;
}
int main() {
	WhileLoopAdder whileLoop("While Loop");
	DoWhileLoopAdder doWhileLoop("Do while Loop");
	whileLoop.run();
	doWhileLoop.run();
}
