package com.youssef.home.data.source


import com.youssef.home.data.model.HomeResponse
import com.youssef.home.data.model.PaginationResponse
import com.youssef.home.data.source.remote.GetHomeRemoteImpl
import com.youssef.home.data.source.remote.HomeApiConfig
import com.youssef.network.data.source.NetworkDataSource
import com.youssef.network.domain.entity.Outcome
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class GetHomeRemoteDSTest {

    private val networkDataSource: NetworkDataSource<HomeApiConfig> = mockk(relaxed = true)
    private lateinit var getHomeRemoteImpl: GetHomeRemoteImpl

    @Before
    fun setUp() {
        getHomeRemoteImpl = GetHomeRemoteImpl(networkDataSource)
    }

    @Test
    fun `getHomeList should return success outcome when API call is successful`() = runBlocking {
        val page = 1
        val expectedOutcome = Outcome.success(HomeResponse(emptyList(), PaginationResponse("", 1)))

        coEvery {
            networkDataSource.performRequest(request = {
                getHomeList(page)
            }, onSuccess = {
                Outcome.success(HomeResponse(emptyList(), PaginationResponse("", 1)))
            })
        } answers {
            expectedOutcome
        }

        val result = getHomeRemoteImpl.getHomeList(page)
        assert(result is Outcome)
    }

}