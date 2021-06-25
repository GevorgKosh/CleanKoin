package com.example.empty.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.empty.data.ApiResult
import com.example.empty.data.GithubModelItem
import com.example.empty.repositories.TaskRepository
import kotlinx.coroutines.launch
import rx.Observable

class TaskViewModel(private val taskRepository: TaskRepository) : ViewModel() {
    val showLoading = MutableLiveData<Boolean>()
    val countriesList = MutableLiveData<List<GithubModelItem>>()
    val showError = MutableLiveData<String>()

    fun getAllCountries() {
        showLoading.value = true
        viewModelScope.launch {
            val result = taskRepository.getGithubList()
            showLoading.value = false
            when (result) {
                is ApiResult.Success -> {
                    countriesList.value = result.successData
                    showError.value = null
                }
                is ApiResult.Error -> showError.value = result.message
            }
        }
    }
}