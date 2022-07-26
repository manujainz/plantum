package com.manujain.plantum.di

import com.manujain.plantum.network.RetrofitServiceBuilder
import com.manujain.plantum.network.api.DoggoAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return RetrofitServiceBuilder().retrofit
    }

    @Singleton
    @Provides
    fun providesDoggoService(retrofit: Retrofit): DoggoAPI {
        return retrofit.create(DoggoAPI::class.java)
    }

}