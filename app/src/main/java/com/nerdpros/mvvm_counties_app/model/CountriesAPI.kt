package com.nerdpros.mvvm_counties_app.model

import com.nerdpros.mvvm_counties_app.Country
import io.reactivex.Single
import retrofit2.http.GET

/**
 * @Author: Angatia Benson
 * @Date: 23/08/2022
 * Copyright (c) 2022 Bantechnis
 */
interface CountriesAPI {
    @GET("DevTides/countries/master/countriesV2.json")
    fun getCountries(): Single<List<Country>>
}