package com.youssef.search.data.source

import com.youssef.network.data.source.NetworkDataSource
import com.youssef.network.domain.entity.Outcome
import com.youssef.search.data.model.SearchResponse
import com.youssef.search.data.source.remote.SearchApiConfig
import com.youssef.search.data.source.remote.SearchRemoteImpl
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class SearchRemoteImplTest {
    private val networkDataSource: NetworkDataSource<SearchApiConfig> = mockk(relaxed = true)
    private lateinit var searchRemoteImpl: SearchRemoteImpl

    @Before
    fun setUp() {
        searchRemoteImpl = SearchRemoteImpl(networkDataSource)
    }

    @Test
    fun `getSearchList should return success outcome when API call is successful`() = runBlocking {
        val searchQuery = "test"
        val expectedOutcome = Outcome.success(SearchResponse(emptyList()))

        coEvery {
            networkDataSource.performRequest(request = {
                getSearchList(searchQuery)
            }, onSuccess = { list ->
                Outcome.success(list)
            })
        } answers {
            expectedOutcome
        }

        val result = searchRemoteImpl.getSearchList(searchQuery)
        assert(result is Outcome)
    }
}