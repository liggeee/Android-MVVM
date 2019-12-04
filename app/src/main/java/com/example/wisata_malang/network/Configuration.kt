package com.example.wisata_malang.network

import com.example.wisata_malang.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Configuration {

    fun getInterceptor():OkHttpClient{
        val http = HttpLoggingInterceptor()
        http.level = HttpLoggingInterceptor.Level.BODY

        var okhttp = OkHttpClient.Builder().addInterceptor(http)
            .connectTimeout(30,TimeUnit.SECONDS)
            .writeTimeout(30,TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()
        return okhttp
    }

    fun getNetwork(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun api(): Api{
        return getNetwork().create(Api::class.java)
    }
}