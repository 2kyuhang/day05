package com.nepplus.day05

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {

    val autoLogin : Boolean = false
    val loginToken : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //자동로그인 확인


        //메인루퍼에게 명령을 내린다 //메인쓰레드와 통신을 한다!!
        val myHandler = Handler(Looper.getMainLooper())

        myHandler.postDelayed(
            {
                val myIntent = Intent(this, MainActivity::class.java)
                startActivity(myIntent)
                finish()
            }, 2500//2.5초 뒤에 실행해주세요
        )






    }
}