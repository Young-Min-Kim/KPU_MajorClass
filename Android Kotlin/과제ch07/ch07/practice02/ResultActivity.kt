package com.example.practice7_2

import android.graphics.ImageFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        setTitle("투표 결과")
        val bundle = intent.getBundleExtra("bundle") ?: null//번들로 값을 받아옴 //?: null -> 값이 없으면 null을 넣어주겠다.

        val imageName = bundle?.getSerializable("ImageName") as? ArrayList<String> // ? -> 값이 있으면 ? 뒤에 식 처리해줌
        //as -> 뒤에 식으로 형변환 해줌 //as 뒤에 ? 는 혹시 널일까봐
        val voteResult = bundle?.getSerializable("VoteCount") as? Array<Int>// ? -> 값이 있으면 ? 뒤에 식 처리해줌

        var textView = arrayListOf<TextView>(tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9) // 텍스트 이름 배열
        val ratingBar = arrayListOf<RatingBar>(rbar1,rbar2,rbar3,rbar4,rbar5,rbar6,rbar7,rbar8,rbar9)// 레이팅바 배열
        var imageFiled = arrayListOf(R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
            R.drawable.pic4, R.drawable.pic5, R.drawable.pic6,
            R.drawable.pic7, R.drawable.pic8, R.drawable.pic9)


        var maxIndex = 0// 가장 많은 표를 받은 그림 인덱스
        if (voteResult != null) {
            for(i in 1 until voteResult.size){
                if( voteResult[maxIndex] < voteResult[i] )
                    maxIndex = i;
            }
            tvTop.text = imageName?.get(maxIndex)//텍스트를 1등에서 그림 이름으로 치환
            ivTop.setImageResource(imageFiled[maxIndex])// 가장 많은 표를 받은 그림으로 치환
        }





        var i = 0
        textView.forEach { tv -> //forEach -> for 문과 유사 배열의 값을 하나하나 받아와서 for 문처럼 수행
            tv.text = imageName?.get(i) // imageName 에서 넘겨받은 이름을 하나씩 넘겨받아서 버튼 이름 수정
            i++
        }
        i = 0 // 0으로 초기화
        ratingBar.forEach { rbar ->
            rbar.rating = voteResult?.get(i)?.toFloat()!! // 레이팅 바는 실수로 넣어줘야 하기때문에 toFloat()
            i++
        }

        btnReturn.setOnClickListener {
            finish()
        }

    }
}
