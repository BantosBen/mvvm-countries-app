package com.nerdpros.mvvm_counties_app.di

import com.nerdpros.mvvm_counties_app.model.CountriesAPI
import com.nerdpros.mvvm_counties_app.model.CountriesService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @Author: Angatia Benson
 * @Date: 23/08/2022
 * Copyright (c) 2022 Bantechnis
 */

@Module
class ApiModule {
    private val baseUrl = "https://raw.githubusercontent.com"

    @Provides
    fun provideCountriesApi(): CountriesAPI {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(CountriesAPI::class.java)
    }

    @Provides
    fun provideCountriesService(): CountriesService {
        return CountriesService()
    }
}