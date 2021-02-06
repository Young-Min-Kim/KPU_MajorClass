package com.example.practice7_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("명화 선호도 투표") //var voteCount = intArrayOf(0,0,0,0,0,0,0,0,0) //상단 이름
        var intent = Intent(this, ResultActivity::class.java)
        var voteCount = Array<Int>(9, { i -> 0 })
        val imageId = arrayListOf<ImageView>(iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9) //버튼 id
        val imageName = arrayListOf<String>( //명화 이름
            "독서하는 소녀",
            "꽃장식 모자 소녀",
            "부채를 든 소녀",
            "이레느깡 단 베르양",
            " 잠자는 소녀",
            "테라스의 두 자매",
            "피아노 레슨",
            "피아노 앞의 소녀들",
            "해변에서"
        )

        var i = 0
        for (imageView in imageId) {
            var j = i //내부의 값을 순차적으로 사용하기 위해 j 사용
            imageView . setOnClickListener {
                voteCount[j]++
                Toast . makeText (this, "${imageName[j]} : 총 ${voteCount[j]}표", Toast.LENGTH_SHORT).show() }
            i ++
        }
        //번들 타입으로 배열을 넘겨주는 것이 가장 안전함
        val bundle = Bundle()
        bundle.putSerializable("ImageName", imageName)//번들에 배열을 넣어줌
        bundle.putSerializable("VoteCount", voteCount)//번들에 배열을 넣어줌
        btnResult.setOnClickListener {
            intent.putExtra("bundle",bundle)//인텐트에 번들을 넣어 전송
            startActivity(intent) }
    }
}
