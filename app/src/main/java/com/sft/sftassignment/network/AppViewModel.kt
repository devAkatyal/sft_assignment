package com.sft.sftassignment.network

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sft.sftassignment.app.SingleLiveEvent
import com.sft.sftassignment.model.ListResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(private val appRepository: AppRepository) : ViewModel() {

    private var _fetchListLiveData = SingleLiveEvent<ListResponse>()
    val fetchListLiveData: SingleLiveEvent<ListResponse>
        get() = _fetchListLiveData

    fun fetchList(
        page: Int,
        limit: Int
    ) {
        viewModelScope.launch {
            try {
                appRepository.fetchList(
                    page = page,
                    limit = limit
                ).collect {
                    _fetchListLiveData.value = it
                }
            } catch (e: HttpException) {
                e.printStackTrace()
                manageApiError(e.code().toString(), e.message.toString())
            }
        }
    }

    // Manage API Response Exception
    fun manageApiError(errorCode: String, errorMessage: String) {
        Log.i("error", errorMessage)
    }

}
