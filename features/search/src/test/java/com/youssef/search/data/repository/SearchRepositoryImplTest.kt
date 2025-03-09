package com.youssef.search.data.repository

import com.youssef.network.domain.entity.ErrorEntity
import com.youssef.network.domain.entity.Outcome
import com.youssef.search.data.model.SearchResponse
import com.youssef.search.data.source.remote.SearchRemoteDS
import com.youssef.search.domain.repository.SearchRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class SearchRepositoryImplTest {

    private val searchRemoteDS: SearchRemoteDS = mockk()
    private val searchRepository: SearchRepository = SearchRepositoryImpl(searchRemoteDS)

    @Test
    fun getSearchList_returnsSearchEntity_whenRemoteDSReturnsSuccess() = runBlocking {
        val searchText = ""
        val remoteOutcome = Outcome.Success(SearchResponse(emptyList()))

        coEvery { searchRemoteDS.getSearchList(searchText) } returns remoteOutcome

        val result = searchRepository.getSearchList(searchText)

        assert(result is Outcome.Success)
    }

    @Test
    fun getSearchList_returnsError_whenRemoteDSReturnsError() = runBlocking {
        val searchText = ""
        val remoteOutcome =
            Outcome.Error<SearchResponse>(ErrorEntity(Throwable("Error message"), 500))

        coEvery { searchRemoteDS.getSearchList(searchText) } returns remoteOutcome

        val result = searchRepository.getSearchList(searchText)

        assert(result is Outcome.Error)
    }

    @Test
    fun getSearchList_returnsEmpty_whenRemoteDSReturnsEmptyList() = runBlocking {
        val searchText = ""
        val remoteOutcome = Outcome.Empty<SearchResponse>()

        coEvery { searchRemoteDS.getSearchList(searchText) } returns remoteOutcome

        val result = searchRepository.getSearchList(searchText)
        assert(result is Outcome.Empty)
    }
}

