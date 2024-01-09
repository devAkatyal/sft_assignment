package com.sft.sftassignment.network

import com.sft.sftassignment.model.ListResponse
import javax.inject.Inject

class ApiServiceImple @Inject constructor(val apiService: ApiService) : BaseDataSource() {

    suspend fun fetchList(
        page: Int,
        limit: Int
    ): ListResponse {
        return apiService.fetchList(
            page = page,
            limit = limit
        )
    }
}