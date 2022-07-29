package com.nepplus.day05.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.nepplus.day05.datas.StoreData
import kotlinx.android.synthetic.main.store_list_item.view.*

class StoreListViewAdapter(
    val mcontext : Context,
    val resId : Int,
    val mList : ArrayList<StoreData>
) : ArrayAdapter<StoreData>(mcontext, resId, mList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //convertView 이 val 이라서 새로 만들어주는 것
        var tompRow = convertView
        if(tompRow == null){
            tompRow = LayoutInflater.from(mcontext).inflate(resId, null)
        }
        //안전하게 하기 위해서 이렇게 다시 변수에 !! 붙여 넣는다
        val row = tompRow!!

        val data = mList[position]
        row.titleTxt.text = data.title
        row.scoreRatingBar.rating = data.score.toFloat()

        Glide.with(mcontext)//글라이드 활용할건데 이 화면에서 사용할거다
            .load(data.imgUrl)
            .into(row.storeImageView) //어디에 쓸건지 id 적어주기

        return row
    }

}