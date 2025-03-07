package com.youssef.home.data.source.remote


import com.google.gson.GsonBuilder
import com.youssef.home.data.model.HomeResponse
import com.youssef.home.data.model.content.ContentResponse
import com.youssef.network.data.source.NetworkDataSource
import com.youssef.network.domain.entity.Outcome
import javax.inject.Inject


/**
 * Created by Youssef Ebrahim Elerian.
 * youssef.elerian@gmail.com
 */
class GetHomeRemoteImpl @Inject constructor(private val networkDataSource: NetworkDataSource<HomeApiConfig>) :
    GetHomeRemoteDS {
    private val gson = GsonBuilder()
        .registerTypeAdapter(ContentResponse::class.java, ContentTypeAdapter())
        .create()

    override suspend fun getHomeList(pageNumber: Int): Outcome<HomeResponse> {
        return networkDataSource.performRequest(request = {
            getHomeList(pageNumber)
        }, onSuccess = { home ->
            Outcome.success(gson.fromJson(home, HomeResponse::class.java))
        })
    }
}