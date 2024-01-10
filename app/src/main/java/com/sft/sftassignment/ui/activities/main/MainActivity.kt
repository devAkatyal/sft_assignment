package com.sft.sftassignment.ui.activities.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.MemoryCategory
import com.sft.sftassignment.R
import com.sft.sftassignment.base.BaseActivity
import com.sft.sftassignment.databinding.ActivityMainBinding
import com.sft.sftassignment.interfaces.ItemClickListener
import com.sft.sftassignment.model.ListResponse
import com.sft.sftassignment.model.ListResponseItem
import com.sft.sftassignment.network.AppViewModel
import com.sft.sftassignment.ui.common.ViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity(), ItemClickListener {
    lateinit var binding: ActivityMainBinding

    private val mainItemAdapter: MainItemAdapter = MainItemAdapter(ArrayList())
    private val appViewModel: AppViewModel by viewModels()

    val viewModelList = ArrayList<ViewModel>()

    var currentPage = 1
    var isMoreDataAvailable = true
    val itemsPerPage = 10
    var isLoading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.rvList.adapter = mainItemAdapter

        loadData()
        binding.swipeRefreshLayout.setOnRefreshListener {
            loadData()
        }
        binding.rvList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
                val totalItemCount = layoutManager.itemCount

                if (lastVisibleItemPosition == totalItemCount - 1 && !isLoading && isMoreDataAvailable) {
                    loadMoreData()
                }
            }
        })

        appViewModel.fetchListLiveData.observe(this) { response ->
            if (response.isNotEmpty()) {
                response.forEach {
                    val mainItemViewModel = MainItemViewModel(this, it)
                    viewModelList.add(mainItemViewModel)
                }
                mainItemAdapter.setList(viewModelList)
            } else {
                isMoreDataAvailable = false
            }
            binding.swipeRefreshLayout.isRefreshing = false
            isLoading = false
        }
    }

    private fun loadData() {
        currentPage = 1
        viewModelList.clear()
        mainItemAdapter.setList(viewModelList)

        fetchData()
    }

    private fun loadMoreData() {
        currentPage++

        fetchData()
    }

    private fun fetchData() {
        isLoading = true

        appViewModel.fetchList(page = currentPage, limit = itemsPerPage)
    }

    override fun onClick(description:String) {
        val alertDialogBuilder = AlertDialog.Builder(this)

        alertDialogBuilder.setMessage(description)

        alertDialogBuilder.setPositiveButton("OK") { dialog, which ->
            dialog.dismiss()
        }

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

}