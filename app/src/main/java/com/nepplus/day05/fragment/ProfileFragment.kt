package com.nepplus.day05.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nepplus.day05.R
import com.nepplus.day05.datas.StoreData

class ProfileFragment: Fragment(){

    //사용할 곳 위에 데이터를 둬야한다
    val mPizzaList = ArrayList<StoreData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {                                  ////false는 중복추가를 못하게 하려고 false 이유는 이미 add해주는게 있어서 그거 방지
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    //프레그먼트 클래스의 동작 코드
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //더미데이터 //실제로는 여기에서 서버 데이터 받아온다
        mPizzaList.add(StoreData("피자헛", 4.3))
        mPizzaList.add(StoreData("파파존스", 3.8))
        mPizzaList.add(StoreData("도미노피자", 4.5))
        mPizzaList.add(StoreData("미스터피자", 3.2))


    }

}