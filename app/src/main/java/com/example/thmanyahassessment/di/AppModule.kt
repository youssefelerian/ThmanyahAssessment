package com.example.thmanyahassessment.di

import android.app.Application
import android.content.Context
import com.example.thmanyahassessment.BuildConfig
import com.youssef.network.NetworkHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


/**
 * Created by Youssef Ebrahim Elerian
 * youssef.elerian@gmail.com
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    fun provideNetworkHandler(): NetworkHandler =
        NetworkHandler.request.setup(BuildConfig.HOME_API, BuildConfig.DEBUG)

}

