package com.example.empty.di

import android.content.Context
import com.example.empty.network.TaskService
import com.example.empty.repositories.TaskRepository
import com.example.empty.repositories.TaskRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    fun provideTaskRepository(api: TaskService) = TaskRepositoryImpl(api)

    single { provideTaskRepository(get()) }

    single<TaskRepository> { TaskRepositoryImpl(get()) }
}