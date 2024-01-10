package com.sft.sftassignment.base


import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
open class BaseActivity @Inject constructor() : AppCompatActivity() {

}