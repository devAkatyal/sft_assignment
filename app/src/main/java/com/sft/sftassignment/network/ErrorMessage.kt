package com.sft.sftassignment.network


import com.google.gson.annotations.SerializedName

data class ErrorMessage(
    @SerializedName("message", alternate = ["error"])
    val message: String,

    @SerializedName("status")
    val success: Boolean
){


}