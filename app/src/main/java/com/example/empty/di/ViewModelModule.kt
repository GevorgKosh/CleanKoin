package com.example.empty.di

import com.example.empty.viewModel.TaskViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { TaskViewModel(get()) }
}