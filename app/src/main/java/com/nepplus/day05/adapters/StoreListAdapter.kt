package com.nepplus.day05.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.nepplus.day05.datas.StoreData

class StoreListAdapter(
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

        return row
    }

}