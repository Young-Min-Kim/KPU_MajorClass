package com.example.practice7_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("메인 엑티비티")//액티비티 상단 이름

        var intentSecond = Intent(applicationContext, SecondActivity::class.java)//인텐트 생성
        var intentThird = Intent(applicationContext, ThirdActivity::class.java)//인텐트 생성
        btnNewActivity.setOnClickListener{
            if(btnSecondToggle.isChecked) {//두번째 액티비티 이동 토글 선택시
                startActivity(intentSecond)
            }
            else if(btnThirdToggle.isChecked){//세번째 액티비티 이동 토글 선택시
                startActivity(intentThird)
            }
            else{//토글을 입력하지 않은 경우
                Toast.makeText(applicationContext, "토글을 입력하세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
