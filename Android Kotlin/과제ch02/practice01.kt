//다음 조건에 따라 클래스를 작성하시오.
// 클래스명 Calendar//private 로 해당 클래스는 같은 파일 내에서만 접근 가능
private class Calendar(day : Int){ //기본생성자로 day 만 입력받아서 멤버 속성에 저장
    var year : Int //멤버 속성
        private set // 외부에서 입력을 받을 수 없게 만듬
    var month : Int//멤버 속성
    var day : Int//멤버 속성
    init{ // init 함수에서 year 는 2020 으로 초기화하고, month 는 3으로 초기화
        this.year = 2020
        this.month = 3
        this.day = day
    }

    //(월, 일) 정보를 입력받는 보조 생성자
    //this 에는 기본생성자가 가지고 있는 day 를 가짐
    constructor(month : Int , day : Int) : this(day){
        this.month = month
        this.day = day
    }
    //(년, 월, 일) 정보를 입력받는 보조 생성자
    constructor(year : Int, month : Int, day : Int) : this(day) {
        this.year = year
        this.month = month
        this.day = day
    }
    //public int setYear(){

    //}
}

fun main() {
    var calendar1 = Calendar(5)
    //calendar1.year = 3 //year 는 외부에서 입력을 받을 수 없음
    println("${calendar1.year}년 ${calendar1.month}월 ${calendar1.day}일")

    var calendar2 = Calendar(2021, 6, 20)
    //calendar1.year = 2022 //year 는 외부에서 입력을 받을 수 없음
    calendar2.month = 7// month 외부 수정 가능
    calendar2.day = 21// day 외부 수정
    println("${calendar2.year}년 ${calendar2.month}월 ${calendar2.day}일")
}