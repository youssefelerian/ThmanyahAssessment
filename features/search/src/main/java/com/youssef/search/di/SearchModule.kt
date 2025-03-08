package com.youssef.search.di

import com.youssef.network.NetworkHandler
import com.youssef.network.NetworkMonitor
import com.youssef.network.data.source.NetworkDataSource
import com.youssef.search.data.repository.SearchRepositoryImpl
import com.youssef.search.data.source.remote.SearchApiConfig
import com.youssef.search.data.source.remote.SearchRemoteDS
import com.youssef.search.data.source.remote.SearchRemoteImpl
import com.youssef.search.domain.repository.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SearchModule {
    @Provides
    @Singleton
    fun provideSearchRepository(remote: SearchRemoteDS): SearchRepository {
        return SearchRepositoryImpl(remote)
    }

    @Provides
    @Singleton
    fun provideSearchRemote(networkDataSource: NetworkDataSource<SearchApiConfig>): SearchRemoteDS {
        return SearchRemoteImpl(networkDataSource)
    }

    @Provides
    @Singleton
    fun provideSearchConfig(
        network: NetworkHandler,
        networkMonitor: NetworkMonitor
    ): NetworkDataSource<SearchApiConfig> {
        val universityListApiConfig = network.create(SearchApiConfig::class.java)
        return NetworkDataSource(universityListApiConfig, networkMonitor)
    }
}