package com.example.practice7_3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        setTitle("세컨드 액티비티")
        val intent = getIntent()

        var operator = intent.getStringExtra("Operator") // 연산자를 입력받음
        var num1 = intent.getIntExtra("Num1",0) // 첫번째 피연산자
        var num2 = intent.getIntExtra("Num2", 0)// 두번째 피연산자
        var result = 0

        if(operator == "+"){// +일때
            result = num1 + num2
        }
        else if(operator == "-"){// -일때
            result = num1 - num2
        }
        else if(operator == "*"){// *일때
            result = num1 * num2
        }
        else if(operator == "/"){// /일때
            if(num2 == 0)
            {
                Toast.makeText(this, "두번째 피연산자가 0입니다.", Toast.LENGTH_SHORT).show() // 두번째 피연산자가 0인 경우
            }
            else{
                result = num1 / num2
            }
        }

        btnReturn.setOnClickListener {//데이터 다시 돌려주기
            val rIntent = Intent(this, MainActivity::class.java)
            rIntent.putExtra("Result",result)
            setResult(Activity.RESULT_OK, rIntent)
            finish()
        }
    }
}
