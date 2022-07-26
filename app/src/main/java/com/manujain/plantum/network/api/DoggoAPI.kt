package com.manujain.plantum.network.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DoggoAPI {

    companion object { val BASE_URL = "http://shibe.online" }

    @GET("api/shibes")
    fun getDoggos(
        @Query("count") count: Int,
        @Query("url") url: Boolean
    ) : Call<ArrayList<String>>
}
