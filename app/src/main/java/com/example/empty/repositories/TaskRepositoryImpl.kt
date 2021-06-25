package com.example.empty.repositories

import com.example.empty.data.ApiResult
import com.example.empty.data.GithubModelItem
import com.example.empty.data.handleApiError
import com.example.empty.data.handleSuccess
import com.example.empty.network.TaskService

class TaskRepositoryImpl(private val api: TaskService) :
    TaskRepository {

    override suspend fun getGithubList(): ApiResult<List<GithubModelItem>> {
        val response = api.getData()
        return if (response.isSuccessful) {
            handleSuccess(response)
        } else {
            handleApiError(response)
        }
    }
}