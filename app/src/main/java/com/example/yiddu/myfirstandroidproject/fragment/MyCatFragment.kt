package com.example.yiddu.myfirstandroidproject.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.yiddu.myfirstandroidproject.R
import com.example.yiddu.myfirstandroidproject.adapter.NearbuCatAdapter

/**
 * Created by yiddu on 11/2/17.
 */
class MyCatFragment : Fragment() {
    private lateinit var mListView: ListView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.fragment_fragment_my_cat, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mListView = view!!.findViewById(R.id.listview)

        setupListView()
    }

    private fun setupListView(){
        var data = listOf("cat 1", "cat 2", "cat 4", "cat 5", "cat 6", "cat 1", "cat 2", "cat 4", "cat 5", "cat 6")

        var adapter = NearbuCatAdapter(activity, data)
        mListView.adapter = adapter
    }
}