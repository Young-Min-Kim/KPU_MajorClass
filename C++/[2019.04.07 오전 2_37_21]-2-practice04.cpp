//높이를 알려주는 Tower클래스를 작성
#include <iostream>
using namespace std;
class Tower {
	int high;
public:
	Tower();//생성자(받는 인자가 없을때)
	Tower(int h);//생성자(받는 인자가 있을때)
	int getHeight();
};
Tower:: Tower(){
	high = 1;
}
Tower::Tower(int h) {
	high = h;
}
int Tower::getHeight() {
	return high;
}
int main() {
	Tower myTower;
	Tower seoulTower(100);
	cout << "높이는 " << myTower.getHeight() << "미터" << endl;
	cout << "높이는 " << seoulTower.getHeight() << "미터" << endl;
	system("pause");
}