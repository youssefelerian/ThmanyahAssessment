package com.youssef.home.domain.interactor


import com.youssef.home.domain.entity.HomeEntity
import com.youssef.home.domain.entity.PaginationEntity
import com.youssef.home.domain.repository.HomeRepository
import com.youssef.network.domain.entity.ErrorEntity
import com.youssef.network.domain.entity.Outcome
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test


@OptIn(ExperimentalCoroutinesApi::class)
class GetHomeUseCaseTest {

    private lateinit var getHomeUseCase: GetHomeUseCase
    private val homeRepository: HomeRepository = mockk()

    @Before
    fun setUp() {
        getHomeUseCase = GetHomeUseCase(homeRepository)
    }

    @Test
    fun run_returnsHomeEntity_whenRepositoryReturnsSuccess() = runTest {
        val input = 1
        val homeEntity = HomeEntity(
            pagination = PaginationEntity(
                nextPage = "",
                totalPages = 1
            ),
             sections =  emptyList()
        )
        coEvery { homeRepository.getHomeList(input) } returns Outcome.Success(homeEntity)

        val result = getHomeUseCase.run(input)

        Assert.assertTrue(result is Outcome.Success)
        Assert.assertEquals(homeEntity, (result as Outcome.Success).data)
        coVerify { homeRepository.getHomeList(input) }
    }

    @Test
    fun run_returnsError_whenRepositoryReturnsError() = runTest {
        val input = 1
        val error = Throwable("Error message")
        coEvery { homeRepository.getHomeList(input) } returns Outcome.Error(ErrorEntity( error, 500))

        val result = getHomeUseCase.run(input)

        Assert.assertTrue(result is Outcome.Error)
        Assert.assertEquals(error, (result as Outcome.Error).error.throwable)
        coVerify { homeRepository.getHomeList(input) }
    }

    @Test
    fun run_returnsLoading_whenRepositoryReturnsEmpty() = runTest {
        val input = 1
        coEvery { homeRepository.getHomeList(input) } returns Outcome.Empty()

        val result = getHomeUseCase.run(input)

        Assert.assertTrue(result is Outcome.Empty)
        coVerify { homeRepository.getHomeList(input) }
    }
}