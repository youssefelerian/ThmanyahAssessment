package com.youssef.home.data.source.remote


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by Youssef Ebrahim Elerian.
 * youssef.elerian@gmail.com
 */
interface HomeApiConfig {

    @GET("https://api-v2-b2sit6oh3a-uc.a.run.app/home_sections")
    suspend fun getHomeList(@Query("page") page: Int): Response<String>
}