package com.nepplus.day05.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nepplus.day05.R
import com.nepplus.day05.StoreDetailActivity
import com.nepplus.day05.adapters.StoreListViewAdapter
import com.nepplus.day05.datas.StoreData
import kotlinx.android.synthetic.main.fragment_pizza.*

class ChickenFragment: Fragment(){

    //사용할 곳 위에 데이터를 둬야한다
    val mChicken = ArrayList<StoreData>()

    //ListView사용될 어답터 클래스 생성
    lateinit var mChickenAdapter : StoreListViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {                                  ////false는 중복추가를 못하게 하려고 false 이유는 이미 add해주는게 있어서 그거 방지
        return inflater.inflate(R.layout.fragment_pizza, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //더미데이터 //실제로는 여기에서 서버 데이터 받아온다
        mChicken.add(StoreData("교촌치킨", 4.3,"1577-8080","https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FnkQca%2FbtqwVT4rrZo%2FymhFqW9uRbzrmZTxUU1QC1%2Fimg.jpg"))
        mChicken.add(StoreData("BBQ", 3.8,"1577-8080","https://mblogthumb-phinf.pstatic.net/20160530_116/ppanppane_14646177654870uGy9_PNG/%C6%C4%C6%C4%C1%B8%BD%BA_%C7%C7%C0%DA_%B7%CE%B0%ED_%281%29.png?type=w800"))
        mChicken.add(StoreData("땅땅치킨", 4.5,"1577-3082","https://www.pngplay.com/wp-content/uploads/6/Dominos-Pizza-Logo-Background-PNG-Image.png"))
        mChicken.add(StoreData("굽네치킨", 3.2,"1577-0077","https://mblogthumb-phinf.pstatic.net/20160530_62/ppanppane_14646177047843NP3E_PNG/%B9%CC%BD%BA%C5%CD%C7%C7%C0%DA_%B7%CE%B0%ED_%283%29.png?type=w800"))

        mChickenAdapter = StoreListViewAdapter(requireContext(), R.layout.store_list_item, mChicken)

        pizzaListView.adapter = mChickenAdapter

        pizzaListView.setOnItemClickListener { adapterView, view, i, l ->
            val myIntent = Intent(requireContext(), StoreDetailActivity::class.java)

            myIntent.putExtra("storeData", mChicken[i])

            startActivity(myIntent)
        }


    }

}