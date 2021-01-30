//main() 함수가 실행되도록 Point 클래스를 상속받는 ColorPoint 클래스를 작성, 전체 프로그램 완성
#include <iostream>
#include <string>
using namespace std;
class Point {
	int x, y;
public:
	Point(int x, int y) { this->x = x; this->y = y; }
	int getX() { return x; }
	int getY() { return y; }
protected:
	void move(int x, int y) { this->x = x; this->y = y; }
};
class ColorPoint : public Point { // point 클래스 상속
	string name;
public:
	ColorPoint() : Point(0, 0) { name = "BLACK"; }			
	ColorPoint(int x, int y) : Point(x, y) { name = "BLACK"; }
	void setPoint(int x, int y) { move(x, y); }		//private를 접근하기 위함
	void setColor(string name) { this->name = name; }//private를 접근하기 위함
	void show() { cout << name << "색으로 (" << getX() << "," << getY() << ")에 위치한 점입니다." << endl; }
};
int main() {
	ColorPoint zeroPoint; // BLACK 색에 (0, 0) 위치의 점
	zeroPoint.show(); // zeroPoint를 출력한다.
	ColorPoint cp(5, 5);
	cp.setPoint(10, 20);
	cp.setColor("BLUE");
	cp.show(); // cp를 출력한다.
}