package com.nepplus.day05.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.nepplus.day05.fragment.PizzaFragment
import com.nepplus.day05.fragment.ProfileFragment

class MainViewPagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {

    //몇장짜리인가
    /*override fun getCount(): Int {
        return 3
    }
    */
    override fun getCount() = 2//아래처럼 축약 가능!!!


    //position 값에 따라 어떤 걸 return 해줄건지?
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> PizzaFragment()
            else -> ProfileFragment()
        }
    }

    //카테고리 이름
    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "피자주문"
            else -> "내 정보 설정"
        }
    }


}