package com.shady.tiger.data

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Apifactory {
    private const val BASE_URL = "http://private-14c693-rentapanda.apiary-mock.com/"

    private fun retrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitApi: API = retrofit().create(API::class.java)
}