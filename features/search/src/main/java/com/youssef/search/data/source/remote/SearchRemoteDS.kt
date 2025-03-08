package com.youssef.search.data.source.remote


import com.youssef.network.domain.entity.Outcome
import com.youssef.search.data.model.SearchResponse


/**
 * Created by Youssef Ebrahim Elerian .
 * youssef.elerian@gmail.com
 */
interface SearchRemoteDS {

    suspend fun getSearchList(search: String): Outcome<SearchResponse>

}