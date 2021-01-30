//BaseArray를 상속받아 큐처럼 작동하는 MyQueue 클래스를 작성
#include <iostream>
using namespace std;
class BaseArray {
private:
	int capacity; // 배열의 크기
	int *mem; // 정수 배열을 만들기 위한 메모리의 포인터
protected:
	BaseArray(int capacity = 100) {
		this->capacity = capacity; mem = new int[capacity];
	}
	~BaseArray() { delete[] mem; }
	void put(int index, int val) { mem[index] = val; }
	int get(int index) { return mem[index]; }
	int getCapacity() { return capacity; }
};
class MyQueue : public BaseArray {
	int enqindex;		//삽입에 필요한 인덱스
	int deindex;		//식제에 필요한 인덱스
public:
	MyQueue(int size) : BaseArray(size) { enqindex = 0; deindex = -1; }
	void enqueue(int n) {
		put(enqindex, n);
		enqindex++;
	}
	int capacity() { return getCapacity(); }
	int length() { return enqindex; }
	int dequeue() {
		enqindex--;
		deindex++; return get(deindex);
	}
};

int main() {
	MyQueue mQ(100);
	int n;
	cout << "큐에 삽입할 5개의 정수를 입력하라>> ";
	for (int i = 0; i < 5; ++i) {
		cin >> n;
		mQ.enqueue(n); // 큐에 삽입
	}
	cout << "큐의 용량:" << mQ.capacity() << ", 큐의 크기:" << mQ.length() << endl;
	cout << "큐의 원소를 순서대로 제거하여 출력한다>> ";
	while (mQ.length() != 0) {
		cout << mQ.dequeue() << ' '; // 큐에서 제거하여 출력
	}
	cout << endl << "큐의 현재크기 : " << mQ.length() << endl;
}