package com.example.helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clickButton.setOnClickListener{
            if(tv01.text.equals("헬로 월드!"))
                tv01.text = "클릭 되었습니다."
            else
                tv01.text = "헬로 월드!"
        }
    }
}
