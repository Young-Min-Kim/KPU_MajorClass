// year를 10으로 초기화하는 생성자와 year 값을 리턴하는 getYear() 구현
class Calendar {
private:
	int year;
public:
	Calendar();
	int getYear();
};

Calendar::Calendar() {         //생성자 구현
	year = 10;
}

int Calendar::getYear() {      //getYear() 구현
	return year;

}