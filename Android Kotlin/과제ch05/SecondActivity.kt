//계산기 만들기
package com.example.helloworld

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var num1: String? = null
        var num2: String? = null
        BtnAdd.setOnClickListener {
            //덧셈
            num1 = Edit1.text.toString()
            num2 = Edit2.text.toString()
            if(num1==""||num2=="")
                Toast.makeText(applicationContext, "입력받은 숫자가 없습니다.", Toast.LENGTH_SHORT).show()//잘못 입력시 오류
            else
                textResult.text = "계산결과 : "+(num1!!.toDouble() + num2!!.toDouble()).toString()
        }
        BtnSup.setOnClickListener {
            //뺄셈
            num1 = Edit1.text.toString()
            num2 = Edit2.text.toString()
            if(num1==""||num2=="")
                Toast.makeText(applicationContext, "입력받은 숫자가 없습니다.", Toast.LENGTH_SHORT).show()//잘못 입력시 오류
            else
                textResult.text = "계산결과 : "+(num1!!.toDouble() - num2!!.toDouble()).toString()
        }
        BtnMul.setOnClickListener {
            //곱셈
            num1 = Edit1.text.toString()
            num2 = Edit2.text.toString()
            if(num1==""||num2=="")
                Toast.makeText(applicationContext, "입력받은 숫자가 없습니다.", Toast.LENGTH_SHORT).show()//잘못 입력시 오류
            else
                textResult.text = "계산결과 : "+(num1!!.toDouble() * num2!!.toDouble()).toString()
        }
        BtnDiv.setOnClickListener {
            //나눗셈
            num1 = Edit1.text.toString()
            num2 = Edit2.text.toString()
            if (num2 == "0")
                Toast.makeText(applicationContext, "두번째 피연산자 값이 0입니다.", Toast.LENGTH_SHORT).show()//0 입력시 오류
            else if (num1==""||num2 =="")
                Toast.makeText(applicationContext, "입력받은 숫자가 없습니다.", Toast.LENGTH_SHORT).show()//잘못 입력시 오류
            else
                textResult.text = "계산결과 : "+(num1!!.toDouble() / num2!!.toDouble()).toString()
        }
        BtnMod.setOnClickListener {
            //나머지
            num1 = Edit1.text.toString()
            num2 = Edit2.text.toString()
            if (num2 == "0")
                Toast.makeText(applicationContext, "두번째 피연산자 값이 0입니다.", Toast.LENGTH_SHORT).show()//0 입력시 오류
            else if(num1==""||num2=="")
                Toast.makeText(applicationContext, "입력받은 숫자가 없습니다.", Toast.LENGTH_SHORT).show()//잘못 입력시 오류
            else
                textResult.text = "계산결과 : "+(num1!!.toDouble() % num2!!.toDouble()).toString()
        }


    }
}
