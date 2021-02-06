package com.example.practice7_3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTitle("메인액티비티") // 상단 이름
        val intent = Intent(this, SecondActivity::class.java)
        btnNewActivity.setOnClickListener {
            var num1 = edtNum1.text.toString().toInt()
            // 입력 받은 숫자 넣어주기//이후 계산을 위해.toInt()
            // 아무것도 없을때 Int 로는 바꿔줄수 없기 때문에 이 변수를 밖에서 선언하면 안됨
            var num2 = edtNum2.text.toString().toInt()
            // 입력 받은 숫자 넣어주기//이후 계산을 위해.toInt()
            // 아무것도 없을때 Int 로는 바꿔줄수 없기 때문에 이 변수를 밖에서 선언하면 안됨

            intent.putExtra("Num1", num1) // putExtra 로 인텐트에 값 넣어주기
            intent.putExtra("Num2", num2) // putExtra 로 인텐트에 값 넣어주기
            if(btnAdd.isChecked){
                intent.putExtra("Operator", "+")
            }
            else if(btnSup.isChecked){
                intent.putExtra("Operator", "-")
            }
            else if(btnMul.isChecked){
                intent.putExtra("Operator", "*")
            }
            else if(btnDiv.isChecked){
                intent.putExtra("Operator", "/")
            }
            else{
                Toast.makeText(this, "토글을 선택하세요.", Toast.LENGTH_SHORT).show()
            }

            startActivityForResult(intent, 0)
            // 0번 리퀘스트 코드를 같이 보내서 돌아오는지 안돌아 오는지 확인
            // 인텐트를 보내고 다시 입력을 돌려 받을땐 startActivityForResult 사용
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        var result = 0
        if(resultCode == Activity.RESULT_OK){
            result = data!!.getIntExtra("Result",0)
            Toast.makeText(this, "합계 : $result", Toast.LENGTH_SHORT).show()
        }
    }
}
