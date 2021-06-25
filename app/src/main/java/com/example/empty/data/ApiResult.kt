package com.example.empty.data

import retrofit2.Response

sealed class ApiResult<out T> {
    data class Success<out T>(val successData: T) : ApiResult<T>()
    data class Error(val message: String? = null) : ApiResult<Nothing>()
}

fun <T : Any> handleApiError(resp: Response<T>) = ApiResult.Error("Something went wrong")

fun <T : Any> handleSuccess(response: Response<T>): ApiResult<T> {
    response.body()?.let {
        return ApiResult.Success(it)
    } ?: return handleApiError(response)
}