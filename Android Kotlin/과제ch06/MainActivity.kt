//계산기 만들기
package com.example.chapter06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_table.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)
        var num1: String? = null// Edit1 값 넣어줄 변수
        var num2: String? = null//Edit2 값 넣어줄 변수
        var arrayNum = arrayOf<Button>( // 버튼 배열 만들기
            Btn0, Btn1, Btn2, Btn3, Btn4,
            Btn5, Btn6, Btn7,Btn8, Btn9)
        for(i in 0..9){ //10개 버튼 for 문 //arrayNum.indices
           arrayNum[i].setOnClickListener{
               if(Edit1.isFocused){
                   num1 = Edit1.text.toString() + arrayNum[i].text.toString()
                   // num1 = 현재 들어있는 숫자 + 방금 버튼을 눌러 추가한 숫자
                   Edit1.setText(num1)
               }
               else if(Edit2.isFocused){
                   num2 = Edit2.text.toString() + arrayNum[i].text.toString()
                   // num2 = 현재 들어있는 숫자 + 방금 버튼을 눌러 추가한 숫자
                   Edit2.setText(num2)
               }
               else{// 텍스트를 선택하지 않은 경우 오류 토스트 메세지 출력
                   Toast.makeText(this, "먼저 텍스트를 선택 하세요", Toast.LENGTH_SHORT).show()
               }
           }
        }
        //덧셈
        BtnAdd.setOnClickListener {
            num1 = Edit1.text.toString()
            num2 = Edit2.text.toString()
            if(Edit1.text.toString().trim().equals("")||Edit2.text.toString().trim().equals(""))
                Toast.makeText(applicationContext, "입력받은 숫자가 없습니다.", Toast.LENGTH_SHORT).show()//잘못 입력시 오류
            else
                textResult.text = "계산결과 : "+(Edit1.text.toString().toDouble() + Edit2.text.toString().toDouble()).toString()
        }
        //뺄셈
        BtnSub.setOnClickListener {
            num1 = Edit1.text.toString()
            num2 = Edit2.text.toString()
            if(Edit1.text.toString().trim().equals("")||Edit2.text.toString().trim().equals(""))
                Toast.makeText(applicationContext, "입력받은 숫자가 없습니다.", Toast.LENGTH_SHORT).show()//잘못 입력시 오류
            else
                textResult.text = "계산결과 : "+(Edit1.text.toString().toDouble() - Edit2.text.toString().toDouble()).toString()
        }
        //곱셈
        BtnMul.setOnClickListener {
            num1 = Edit1.text.toString()
            num2 = Edit2.text.toString()
            if(Edit1.text.toString().trim().equals("")||Edit2.text.toString().trim().equals(""))
                Toast.makeText(applicationContext, "입력받은 숫자가 없습니다.", Toast.LENGTH_SHORT).show()//잘못 입력시 오류
            else
                textResult.text = "계산결과 : "+(Edit1.text.toString().toDouble() * Edit2.text.toString().toDouble()).toString()
        }
        //나눗셈
        BtnDiv.setOnClickListener {
            num1 = Edit1.text.toString()
            num2 = Edit2.text.toString()
            if(Edit1.text.toString().trim().equals("")||Edit2.text.toString().trim().equals(""))
                Toast.makeText(applicationContext, "입력받은 숫자가 없습니다.", Toast.LENGTH_SHORT).show()//잘못 입력시 오류
            else if(Edit2.text.toString().equals("0")){
                Toast.makeText(applicationContext, "두번째 피연산자 값이 0입니다.", Toast.LENGTH_SHORT).show()
            }
            else
                textResult.text = "계산결과 : "+(Edit1.text.toString().toDouble() / Edit2.text.toString().toDouble()).toString()
        }






   }
}
