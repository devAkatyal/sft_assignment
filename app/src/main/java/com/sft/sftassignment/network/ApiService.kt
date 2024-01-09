package com.sft.sftassignment.network

import com.sft.sftassignment.model.ListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("list")
    suspend fun fetchList(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): ListResponse
}

