package com.example.empty.network

import com.example.empty.data.GithubModelItem
import retrofit2.Response
import retrofit2.http.GET

interface TaskService {
    @GET("repositories")
    suspend fun getData(): Response<List<GithubModelItem>>
}