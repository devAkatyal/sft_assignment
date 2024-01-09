package com.sft.sftassignment.network

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(private val appRepository: AppRepository) : ViewModel() {



    // Manage API Response Exception
    fun manageApiError(errorCode: String, errorMessage: String) {
        Log.i("error", errorMessage)
     }

}
