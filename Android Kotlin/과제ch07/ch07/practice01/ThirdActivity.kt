package com.example.practice7_1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        setTitle("서드 엑티비티")//상단 이름
        btnReturn.setTextColor(Color.WHITE)
        btnReturn.setOnClickListener{//버튼 클릭시에

            finish()//액티비티 종료
        }
    }
}
