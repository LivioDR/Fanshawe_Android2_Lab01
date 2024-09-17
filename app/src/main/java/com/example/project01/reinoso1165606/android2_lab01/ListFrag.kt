package com.example.project01.reinoso1165606.android2_lab01

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment

class ListFrag:ListFragment() {
    private val happinessLevels = arrayOf("Level 1", "Level 2", "Level 3", "Level 4")
    private var onItemClick:OnItemClick? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        onItemClick = context as? OnItemClick
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_fragment, container, false)
        val adapter = ArrayAdapter(requireActivity(),android.R.layout.simple_list_item_1, happinessLevels)
        listAdapter = adapter
        return view
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        onItemClick?.changeDataWithIndex(position)
        // highlight the selected item
        listView.setSelector(android.R.color.holo_blue_bright)
    }

    interface OnItemClick{
        fun changeDataWithIndex(index:Int)
    }
}