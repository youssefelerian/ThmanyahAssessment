package com.youssef.search.domain.repository


import com.youssef.network.domain.entity.Outcome
import com.youssef.search.domain.entity.SearchEntity

interface SearchRepository {

    suspend fun getSearchList(search:String): Outcome<SearchEntity>

}