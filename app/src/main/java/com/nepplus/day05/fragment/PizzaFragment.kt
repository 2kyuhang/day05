package com.nepplus.day05.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nepplus.day05.R
import com.nepplus.day05.adapters.StoreListViewAdapter
import com.nepplus.day05.datas.StoreData
import kotlinx.android.synthetic.main.fragment_pizza.*

class PizzaFragment: Fragment(){

    //사용할 곳 위에 데이터를 둬야한다
    val mPizzaList = ArrayList<StoreData>()

    //ListView사용될 어답터 클래스 생성
    lateinit var mPizzAdapter : StoreListViewAdapter

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
        mPizzaList.add(StoreData("피자헛", 4.3,"https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FnkQca%2FbtqwVT4rrZo%2FymhFqW9uRbzrmZTxUU1QC1%2Fimg.jpg"))
        mPizzaList.add(StoreData("파파존스", 3.8,"https://mblogthumb-phinf.pstatic.net/20160530_116/ppanppane_14646177654870uGy9_PNG/%C6%C4%C6%C4%C1%B8%BD%BA_%C7%C7%C0%DA_%B7%CE%B0%ED_%281%29.png?type=w800"))
        mPizzaList.add(StoreData("도미노피자", 4.5,"https://www.pngplay.com/wp-content/uploads/6/Dominos-Pizza-Logo-Background-PNG-Image.png"))
        mPizzaList.add(StoreData("미스터피자", 3.2,"https://mblogthumb-phinf.pstatic.net/20160530_62/ppanppane_14646177047843NP3E_PNG/%B9%CC%BD%BA%C5%CD%C7%C7%C0%DA_%B7%CE%B0%ED_%283%29.png?type=w800"))

        mPizzAdapter = StoreListViewAdapter(requireContext(), R.layout.store_list_item, mPizzaList)

        pizzaListView.adapter = mPizzAdapter

    }

}