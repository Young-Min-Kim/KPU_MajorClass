//음수를 입력하기 전까지 0이나 양수를 입력받고, 입력을 받을 때 마다 현재 입력한 상황에서 최솟값을 출력하는 프 로그램을 작성
fun main(){
    var min : Int = 100 // min 변수 설정 초기 값은 100으로 설정
    var currentMin : (Int, Int) -> Int = { givenNum : Int, minNum : Int -> // 람다 함수, 인자 두개 받음
        if(givenNum > minNum) { //givenNum은 입력받은 숫자 , minNum 은 입력받은 현재 최소값 ,사용자가 입력한 숫자가 현재 최소값보다 클 경우
            println("Current min is $minNum")
            minNum
        }
        else{ // 사용자가 입력한 값이 현재 최소값보다 작거나 같은 경우
            println("Current min is $givenNum")
            givenNum
        }

    }
    while(true) {
        println("Enter a number")
        var num: Int = readLine()!!.toInt()// readLine 함수 사용
        if (num > 100) { //입력한 값이 100을 넘은경우
            println("100 이하 숫자를 입력하시오.")
        }
        else if(num < 0){ //음수 입력시에 종료
            break
        }
        else
            min = giveNum(num ,min , currentMin) //고차함수 호출
    }

}
fun giveNum (givenNum : Int ,minNum : Int ,function : (Int,Int) -> Int): Int { // 고차함수
    var tmp: Int = function(givenNum ,minNum)
    return tmp
}