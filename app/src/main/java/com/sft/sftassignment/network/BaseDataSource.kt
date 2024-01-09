package com.sft.sftassignment.network

import com.google.gson.Gson
import com.sft.sftassignment.utils.Resource
import retrofit2.Response
import retrofit2.Response.success

abstract class BaseDataSource() {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Resource.success(body)
            }
            return getErrorData(response)
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Resource<T> {
        return Resource.error(" $message")
    }

    private fun <T> getErrorData(response: Response<T>): Resource<T> {
        val message: ErrorMessage =
            Gson().fromJson(response.errorBody()!!.charStream(), ErrorMessage::class.java)
        return error(message.message)
    }

}