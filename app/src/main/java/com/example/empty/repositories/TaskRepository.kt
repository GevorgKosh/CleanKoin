package com.example.empty.repositories

import com.example.empty.data.ApiResult
import com.example.empty.data.GithubModelItem

interface TaskRepository {
    suspend fun getGithubList(): ApiResult<List<GithubModelItem>>
}