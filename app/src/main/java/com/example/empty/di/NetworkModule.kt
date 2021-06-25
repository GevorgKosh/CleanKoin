package com.example.empty.di

import androidx.constraintlayout.solver.LinearSystem.DEBUG
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val connectTimeout: Long = 40
private const val readTimeout: Long = 40
private const val BASE_URL = "https://api.github.com/"

val networkModule = module {
    fun provideHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
            .connectTimeout(connectTimeout, TimeUnit.SECONDS)
            .readTimeout(readTimeout, TimeUnit.SECONDS)
        if (DEBUG) {
            val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            okHttpClientBuilder.addInterceptor(httpLoggingInterceptor)
        }
        okHttpClientBuilder.build()
        return okHttpClientBuilder.build()
    }

    fun provideRetrofit(client: OkHttpClient, baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .client(client)
            .build()
    }

    single { provideHttpClient() }
    single { provideRetrofit(get(), BASE_URL) }
}