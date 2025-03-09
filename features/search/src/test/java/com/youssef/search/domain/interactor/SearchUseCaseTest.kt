package com.youssef.search.domain.interactor


import com.youssef.network.domain.entity.ErrorEntity
import com.youssef.network.domain.entity.Outcome
import com.youssef.search.domain.entity.SearchEntity
import com.youssef.search.domain.repository.SearchRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test


@OptIn(ExperimentalCoroutinesApi::class)
class SearchUseCaseTest {

    private lateinit var searchUseCase: SearchUseCase
    private val searchRepository: SearchRepository = mockk()

    @Before
    fun setUp() {
        searchUseCase = SearchUseCase(searchRepository)
    }

    @Test
    fun run_returnsSearchEntity_whenRepositoryReturnsSuccess() = runTest {
        val input = ""
        val searchEntity = SearchEntity(
            sections = emptyList()
        )
        coEvery { searchRepository.getSearchList(input) } returns Outcome.Success(searchEntity)

        val result = searchUseCase.run(input)

        Assert.assertTrue(result is Outcome.Success)
        Assert.assertEquals(searchEntity, (result as Outcome.Success).data)
        coVerify { searchRepository.getSearchList(input) }
    }

    @Test
    fun run_returnsError_whenRepositoryReturnsError() = runTest {
        val input = ""
        val error = Throwable("Error message")
        coEvery { searchRepository.getSearchList(input) } returns Outcome.Error(
            ErrorEntity(
                error,
                500
            )
        )

        val result = searchUseCase.run(input)

        Assert.assertTrue(result is Outcome.Error)
        Assert.assertEquals(error, (result as Outcome.Error).error.throwable)
        coVerify { searchRepository.getSearchList(input) }
    }

    @Test
    fun run_returnsLoading_whenRepositoryReturnsEmpty() = runTest {
        val input = ""
        coEvery { searchRepository.getSearchList(input) } returns Outcome.Empty()

        val result = searchUseCase.run(input)

        Assert.assertTrue(result is Outcome.Empty)
        coVerify { searchRepository.getSearchList(input) }
    }
}