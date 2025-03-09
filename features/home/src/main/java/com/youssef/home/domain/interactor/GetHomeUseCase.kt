package com.youssef.home.domain.interactor


import com.youssef.base.domain.interactor.AsyncUseCase
import com.youssef.home.domain.entity.HomeEntity
import com.youssef.home.domain.repository.HomeRepository
import com.youssef.network.domain.entity.Outcome
import javax.inject.Inject

class GetHomeUseCase @Inject constructor(private val homeRepository: HomeRepository) :
    AsyncUseCase<Int, HomeEntity>() {

    public override suspend fun run(input: Int): Outcome<HomeEntity> {
        return homeRepository.getHomeList(input)
    }
}