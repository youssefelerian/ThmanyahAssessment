package com.youssef.search.data.repository

import com.youssef.network.domain.entity.Outcome
import com.youssef.network.domain.entity.map
import com.youssef.search.data.model.mapper.toEntity
import com.youssef.search.data.source.remote.SearchRemoteDS
import com.youssef.search.domain.entity.SearchEntity
import com.youssef.search.domain.repository.SearchRepository
import javax.inject.Inject


class SearchRepositoryImpl @Inject constructor(private val searchRemoteDS: SearchRemoteDS) :
    SearchRepository {

    override suspend fun getSearchList(search: String): Outcome<SearchEntity> {
        return searchRemoteDS.getSearchList(search).map { it.toEntity() }
    }
}