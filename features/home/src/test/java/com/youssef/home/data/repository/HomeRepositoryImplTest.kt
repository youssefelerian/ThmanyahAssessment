package com.youssef.home.data.repository

import com.youssef.home.data.model.HomeResponse
import com.youssef.home.data.model.PaginationResponse
import com.youssef.home.data.source.remote.GetHomeRemoteDS
import com.youssef.home.domain.repository.HomeRepository
import com.youssef.network.domain.entity.ErrorEntity
import com.youssef.network.domain.entity.Outcome
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class HomeRepositoryImplTest {

    private val homeRemoteDS: GetHomeRemoteDS = mockk()
    private val homeRepository: HomeRepository = HomeRepositoryImpl(homeRemoteDS)

    @Test
    fun getHomeList_returnsHomeEntity_whenRemoteDSReturnsSuccess() = runBlocking {
        val pageNumber = 1
        val remoteOutcome = Outcome.Success(HomeResponse(pagination= PaginationResponse(totalPages = 1)))

        coEvery { homeRemoteDS.getHomeList(pageNumber) } returns remoteOutcome

        val result = homeRepository.getHomeList(pageNumber)

        assert(result is Outcome.Success)
    }

    @Test
    fun getHomeList_returnsError_whenRemoteDSReturnsError() = runBlocking {
        val pageNumber = 1
        val remoteOutcome = Outcome.Error<HomeResponse>(ErrorEntity(Throwable("Error message"), 500))

        coEvery { homeRemoteDS.getHomeList(pageNumber) } returns remoteOutcome

        val result = homeRepository.getHomeList(pageNumber)

        assert(result is Outcome.Error)
    }

    @Test
    fun getHomeList_returnsEmpty_whenRemoteDSReturnsEmptyList() = runBlocking {
        val pageNumber = 1
        val remoteOutcome = Outcome.Empty<HomeResponse>()

        coEvery { homeRemoteDS.getHomeList(pageNumber) } returns remoteOutcome

        val result = homeRepository.getHomeList(pageNumber)
        assert(result is Outcome.Empty)
    }
}

