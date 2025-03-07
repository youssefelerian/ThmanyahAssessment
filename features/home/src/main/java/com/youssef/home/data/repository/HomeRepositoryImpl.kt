package com.youssef.home.data.repository

import com.youssef.home.data.model.mapper.toEntity
import com.youssef.home.data.source.remote.GetHomeRemoteDS
import com.youssef.home.domain.entity.HomeEntity
import com.youssef.home.domain.repository.HomeRepository
import com.youssef.network.domain.entity.Outcome
import com.youssef.network.domain.entity.map
import javax.inject.Inject


class HomeRepositoryImpl @Inject constructor(private val homeRemoteDS: GetHomeRemoteDS) :
    HomeRepository {

    override suspend fun getHomeList(pageNumber: Int): Outcome<HomeEntity> {
        return homeRemoteDS.getHomeList(pageNumber).map { it.toEntity() }
    }
}