//아래 멤버를 참고하여 주어진 사각형에 내접하는 타원을 추상화한 Oval 클래스를 작성하시오.
class Oval(width : Int = 1, height : Int = 1){ // 너비와 높이를 1로 초기화 하는 기본 생성자
    var width : Int = width// 너비 멤버 선언
        get() {//getter, setter 함수를 직접 작성
            return field
        }
        set(value) {
            field = value
        }
    var height : Int = height// 높이 멤버 선언
        get() {//getter, setter 함수를 직접 작성
        return field
        }
        set(value) {
            field = value
        }
    fun change(width : Int, height : Int){//타원의 너비와 높이를 한꺼번에 변경하는 함수 작성
        this.width = width
        this.height = height
    }
    fun show(){
        println("너비 : ${this.width} 높이 : ${this.height}")
    }
}

fun main() {
    var oval = Oval( 4 , 4)
    oval.show()
    oval.change(7, 7)
    oval.show()
}