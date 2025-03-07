package com.youssef.home.data.source.remote


import com.youssef.home.data.model.HomeResponse
import com.youssef.network.domain.entity.Outcome


/**
 * Created by Youssef Ebrahim Elerian .
 * youssef.elerian@gmail.com
 */
interface GetHomeRemoteDS {

    suspend fun getHomeList(pageNumber: Int): Outcome<HomeResponse>

}