package com.example.covidinfo.di

import com.example.covidinfo.repository.NetworkRepository
import com.example.covidinfo.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit():Retrofit=Retrofit.Builder()
        .baseUrl(ApiService.URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit):ApiService=retrofit.create(ApiService::class.java)


    @Provides
    @Singleton
    fun provideRepository(apiService: ApiService):NetworkRepository=NetworkRepository(apiService)

}

