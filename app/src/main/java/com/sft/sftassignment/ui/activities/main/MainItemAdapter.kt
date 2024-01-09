package com.sft.sftassignment.ui.activities.main

import android.annotation.SuppressLint
import com.sft.sftassignment.R
import com.sft.sftassignment.ui.common.DataBindingRecyclerViewAdapter
import com.sft.sftassignment.ui.common.ViewModel
class MainItemAdapter(viewModels: MutableList<ViewModel>) :
    DataBindingRecyclerViewAdapter(viewModels) {

    private val mViewModelMap = HashMap<Class<*>, Int>()

    init {

        setHasStableIds(true)
        mViewModelMap[MainItemViewModel::class.java] = R.layout.item_main
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(itemList: ArrayList<ViewModel>) {
        mViewModels = itemList
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearList() {
        mViewModels.clear()
        notifyDataSetChanged()
    }

    fun getList(): MutableList<ViewModel> {
        return mViewModels
    }

    override val viewModelLayoutMap: Map<Class<*>, Int>
        get() = mViewModelMap

}