package com.nepplus.day05.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nepplus.day05.ProfileActivity
import com.nepplus.day05.R
import com.nepplus.day05.adapters.StoreListViewAdapter
import com.nepplus.day05.datas.StoreData
import kotlinx.android.synthetic.main.fragment_pizza.*
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment: Fragment(){

    val REQ_FOR_NICK = 1000

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

        val myIntent = Intent(requireContext(), ProfileActivity::class.java)
        startActivityForResult(myIntent, REQ_FOR_NICK)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            val changeNick = data?.getStringExtra("changeNick")
            nickTxt.text = changeNick
        }
    }

}