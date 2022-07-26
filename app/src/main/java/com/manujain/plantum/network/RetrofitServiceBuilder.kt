package com.manujain.plantum.network

import com.manujain.plantum.network.api.DoggoAPI
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitServiceBuilder {

    private val builder = Retrofit.Builder()
        .baseUrl(DoggoAPI.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder().build())

    val retrofit: Retrofit = builder.build()
}