//사칙연산을 수행하는 프로그램을 작성하시오.
import java.util.Scanner
fun main() {
    val sc: Scanner = Scanner(System.`in`)
    var cal = CalcSub()
    while(true){
        print("두 정수와 연산자를 입력하시오 : ")
        var num1 : Int = sc.nextInt()
        var num2 : Int = sc.nextInt()
        var op : String = sc.next()
        if (num1 == 0) {//첫번째 피연사자가 0일 경우 프로그램 종료
            println("프로그램 종료")
            break
        }
        if (op == "+") {
            cal.add(num1, num2)
        } else if (op == "-") {
            cal.sub(num1, num2)
        } else if (op == "*") {
            cal.mul(num1, num2)
        } else if (op == "/") {
            cal.div(num1, num2)
        }
        else{
            println("잘못 입력하셨습니다. 다시 입력하세요.")
        }
    }
}
abstract class CalcSuper(){//CalcSuper 클래스 내부에 add, sub, mul, div의 추상 함수로 구성된 추상클래스를 작성
    abstract fun add(num1 : Int, num2 : Int)// 덧셈
    abstract fun sub(num1 : Int, num2 : Int)// 뺄셈
    abstract fun mul(num1 : Int, num2 : Int)// 곱셈
    abstract fun div(num1 : Int, num2 : Int)// 나눗셈
}

class CalcSub() : CalcSuper(){//CalcSub 클래스는 CalcSub 클래스를 상속받아서 를 구현하여 사칙 연산을 계산
    override fun add(num1 : Int, num2 : Int){//구현
        println("${num1 + num2}")
    }
    override fun sub(num1 : Int, num2 : Int){//구현
        println("${num1 - num2}")
    }
    override fun mul(num1 : Int, num2 : Int){//구현
        println("${num1 * num2}")
    }
    override fun div(num1 : Int, num2 : Int){//구현
        println("${num1 / num2}")
    }
}

