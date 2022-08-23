package com.nerdpros.mvvm_counties_app.model

import com.nerdpros.mvvm_counties_app.Country
import com.nerdpros.mvvm_counties_app.di.DaggerApiComponent
import io.reactivex.Single
import javax.inject.Inject

/**
 * @Author: Angatia Benson
 * @Date: 23/08/2022
 * Copyright (c) 2022 Bantechnis
 */
class CountriesService {

    @Inject
    lateinit var api: CountriesAPI

    init {
        DaggerApiComponent.create().inject(this)
    }

    fun getCountries(): Single<List<Country>> = api.getCountries()
}