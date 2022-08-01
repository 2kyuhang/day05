package com.nepplus.day05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nepplus.day05.adapters.MainViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mPagerAdapter : MainViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPagerAdapter = MainViewPagerAdapter(supportFragmentManager)

        mainViewPager.adapter = mPagerAdapter

        mainTabLayout.setupWithViewPager(mainViewPager)

        //이건 페이지를 3개는 반드시 시켜놓아라 // 그래야 데이터가 onActivityCreated되어도 중복생성 X
        mainViewPager.offscreenPageLimit = 3

    }
}