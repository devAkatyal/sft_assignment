package com.sft.sftassignment.ui.activities.main

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ObservableField
import com.sft.sftassignment.model.ListResponseItem
import com.sft.sftassignment.ui.common.ViewModel

class MainItemViewModel(val mActivity: AppCompatActivity, private val item: ListResponseItem) : ViewModel {


    @JvmField
    val imageUrl = ObservableField<String>()

    @JvmField
    val title = ObservableField<String>()

    @JvmField
    val description = ObservableField<String>()

    init {
        imageUrl.set(item.download_url)
        title.set(item.id)
        description.set(item.author)
    }

    fun onItemClick(view: View) {
        //Open dialog
    }

    override fun close() {

    }
}