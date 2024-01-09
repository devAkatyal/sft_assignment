package com.sft.sftassignment.ui.activities.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sft.sftassignment.R
import com.sft.sftassignment.databinding.ActivityMainBinding
import com.sft.sftassignment.model.ListResponse
import com.sft.sftassignment.model.ListResponseItem
import com.sft.sftassignment.ui.common.ViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val mainItemAdapter: MainItemAdapter = MainItemAdapter(ArrayList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        dummyList()
    }

    private fun dummyList() {
        binding.rvList.adapter = mainItemAdapter
        val list = ListResponse()
        list.add(
            ListResponseItem(
                "Desc 1",
                "https://picsum.photos/id/20/3670/2462",
                0,
                "Title 1",
                "https://unsplash.com/photos/nJdwUHmaY8A",
                0
            )
        )
        list.add(
            ListResponseItem(
                "Desc 2",
                "https://picsum.photos/id/20/3670/2462",
                0,
                "Title 2",
                "https://unsplash.com/photos/nJdwUHmaY8A",
                0
            )
        )
        list.add(
            ListResponseItem(
                "Desc 3",
                "https://picsum.photos/id/20/3670/2462",
                0,
                "Title 3",
                "https://unsplash.com/photos/nJdwUHmaY8A",
                0
            )
        )
        list.add(
            ListResponseItem(
                "Desc 4",
                "https://picsum.photos/id/20/3670/2462",
                0,
                "Title 4",
                "https://unsplash.com/photos/nJdwUHmaY8A",
                0
            )
        )

        var viewModels = ArrayList<ViewModel>()

        list.forEach {
            val mainItemViewModel = MainItemViewModel(this, it)
            viewModels.add(mainItemViewModel)
        }
        mainItemAdapter.setList(viewModels)
    }
}