package com.youssef.home.di

import com.youssef.home.data.repository.HomeRepositoryImpl
import com.youssef.home.data.source.remote.GetHomeRemoteDS
import com.youssef.home.data.source.remote.GetHomeRemoteImpl
import com.youssef.home.data.source.remote.HomeApiConfig
import com.youssef.home.domain.repository.HomeRepository
import com.youssef.network.NetworkHandler
import com.youssef.network.NetworkMonitor
import com.youssef.network.data.source.NetworkDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {
    @Provides
    @Singleton
    fun provideHomeRepository(remote: GetHomeRemoteDS): HomeRepository {
        return HomeRepositoryImpl(remote)
    }

    @Provides
    @Singleton
    fun provideHomeRemote(networkDataSource: NetworkDataSource<HomeApiConfig>): GetHomeRemoteDS {
        return GetHomeRemoteImpl(networkDataSource)
    }

    @Provides
    @Singleton
    fun provideHomeConfig(
        network: NetworkHandler,
        networkMonitor: NetworkMonitor
    ): NetworkDataSource<HomeApiConfig> {
        val universityListApiConfig = network.create(HomeApiConfig::class.java)
        return NetworkDataSource(universityListApiConfig, networkMonitor)
    }
}