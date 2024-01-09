package com.sft.sftassignment.network

import com.sft.sftassignment.model.ListResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AppRepository @Inject constructor(private val apiServiceImple: ApiServiceImple) {

    fun fetchList(page: Int,
                  limit: Int): Flow<ListResponse> = flow {
        try {
            emit(apiServiceImple.fetchList(page = page,
                limit = limit))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }.flowOn(Dispatchers.IO)

}