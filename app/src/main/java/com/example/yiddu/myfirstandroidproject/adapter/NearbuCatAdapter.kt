package com.example.yiddu.myfirstandroidproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.yiddu.myfirstandroidproject.R
import kotlinx.android.synthetic.main.my_cat_list.view.*

/**
 * Created by yiddu on 11/2/17.
 */
class NearbuCatAdapter(val context: Context, val data: List<String>): BaseAdapter() {
    val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View
        if(convertView == null) {
            view = inflater!!.inflate(R.layout.my_cat_list, null, false)

        }else{
            view = convertView
        }

        view.findViewById<TextView>(R.id.content).setText(data.get(position))
        return view
    }

    override fun getItem(position: Int): Any {
        return data.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.size
    }

}