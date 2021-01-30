//Person 클래스의 객체를 생성
//생성자를 중복 작성

#include <iostream>
using namespace std;
#include <string>
class Person {
	int id;
	double weight;
	string name;
public:
	Person() { this->id = 1; 
	this->weight = 20.5; this->name = "Grace"; }
	Person(int id, string name) 
	{ 
		this->id = id;
		this->weight = 20.5; this->name = name; 
	}
	Person(int id, string name, double weight) { this->id = id; this->weight = weight; this->name = name; }//중복 작성
	void show() { cout << id << ' ' << weight << ' ' << name << endl; }
};
int main() {
	Person grace, ashley(2, "Ashley"), helen(3, "Helen", 32.5);
	grace.show();
	ashley.show();
	helen.show();
}