package com.nerdpros.mvvm_counties_app.model

import com.nerdpros.mvvm_counties_app.Country
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @Author: Angatia Benson
 * @Date: 23/08/2022
 * Copyright (c) 2022 Bantechnis
 */
class CountriesService {
    private val baseUrl = "https://raw.githubusercontent.com"
    private var api: CountriesAPI

    init {
        api = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(CountriesAPI::class.java)
    }

    fun getCountries(): Single<List<Country>> = api.getCountries()
}