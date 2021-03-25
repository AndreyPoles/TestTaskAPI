package com.search.testtaskapi.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstanse {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.unsplash.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: ImagesAPI by lazy {
        retrofit.create(ImagesAPI::class.java)
    }

}