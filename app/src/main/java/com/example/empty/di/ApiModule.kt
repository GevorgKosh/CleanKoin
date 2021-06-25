package com.example.empty.di

import com.example.empty.network.TaskService
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    fun provideTaskApi(retrofit: Retrofit) = retrofit.create(TaskService::class.java)

    single { provideTaskApi(get()) }
}