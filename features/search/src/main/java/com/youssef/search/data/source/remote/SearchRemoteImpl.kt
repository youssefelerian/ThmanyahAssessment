package com.youssef.search.data.source.remote


import com.youssef.network.data.source.NetworkDataSource
import com.youssef.network.domain.entity.Outcome
import com.youssef.search.data.model.SearchResponse
import javax.inject.Inject


/**
 * Created by Youssef Ebrahim Elerian.
 * youssef.elerian@gmail.com
 */
class SearchRemoteImpl @Inject constructor(private val networkDataSource: NetworkDataSource<SearchApiConfig>) :
    SearchRemoteDS {

    override suspend fun getSearchList(search: String): Outcome<SearchResponse> {
        return networkDataSource.performRequest(request = {
            getSearchList(search)
        }, onSuccess = { list ->
            Outcome.success(list)
        })
    }
}