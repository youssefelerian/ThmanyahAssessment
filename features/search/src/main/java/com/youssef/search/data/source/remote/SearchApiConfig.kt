package com.youssef.search.data.source.remote


import com.youssef.search.data.model.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by Youssef Ebrahim Elerian.
 * youssef.elerian@gmail.com
 */
interface SearchApiConfig {

    @GET("https://mock.apidog.com/m1/735111-711675-default/search")
    suspend fun getSearchList(@Query("search") search: String): Response<SearchResponse>
}