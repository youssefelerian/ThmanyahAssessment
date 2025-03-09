package com.youssef.search.domain.interactor


import com.youssef.base.domain.interactor.AsyncUseCase
import com.youssef.network.domain.entity.Outcome
import com.youssef.search.domain.entity.SearchEntity
import com.youssef.search.domain.repository.SearchRepository
import javax.inject.Inject

class SearchUseCase @Inject constructor(private val searchRepository: SearchRepository) :
    AsyncUseCase<String, SearchEntity>() {

   public override suspend fun run(input: String): Outcome<SearchEntity> {
        return searchRepository.getSearchList(input)
    }
}