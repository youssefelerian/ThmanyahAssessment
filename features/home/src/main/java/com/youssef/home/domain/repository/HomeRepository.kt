package com.youssef.home.domain.repository


import com.youssef.home.domain.entity.HomeEntity
import com.youssef.network.domain.entity.Outcome

interface HomeRepository {

    suspend fun getHomeList(pageNumber: Int): Outcome<HomeEntity>

}