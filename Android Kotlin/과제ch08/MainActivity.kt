package com.example.chapter08_dialog

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            val dlgView = layoutInflater.inflate(R.layout.dialog, null)
            val dlgBuilder = AlertDialog.Builder(this) //dialog는 diolog빌더가 필요
            val etName = dlgView.findViewById<EditText>(R.id.dlgEdt1)
            //연결의 안정성을 위해 findViewBy 안써줘도 되지만 연결할 xml이 많아서 안정성 위해 사용
            val etEmail = dlgView.findViewById<EditText>(R.id.dlgEdt2)
            dlgBuilder.setTitle("사용자 정보 입력") //제목 입력
            dlgBuilder.setIcon(R.drawable.ic_menu_allfriends)//이미지 입력
            dlgBuilder.setView(dlgView) //뷰 설정

            //기본적으로 dialog 는 positive, negative 버튼 두개가 생김김
            dlgBuilder.setPositiveButton("확인") { dialogInterface, i ->
                tvName.text = etName.text.toString()
                tvEmail.text = etEmail.text.toString()
            }.setNegativeButton("취소") { dialogInterface, i ->
                val toast = Toast(this)
                val toastView = layoutInflater.inflate(R.layout.toast, null);
                val toastTextView = toastView.findViewById<TextView>(R.id.toastText)
                toastTextView.text = "취소했습니다."
                toast.setView(toastView)
                toast.show()
            }.show()
        }
    }
}
