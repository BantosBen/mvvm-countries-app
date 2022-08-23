package com.nerdpros.mvvm_counties_app.di

import com.nerdpros.mvvm_counties_app.model.CountriesService
import com.nerdpros.mvvm_counties_app.viewmodel.ListViewModel
import dagger.Component

/**
 * @Author: Angatia Benson
 * @Date: 23/08/2022
 * Copyright (c) 2022 Bantechnis
 */
@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(service: CountriesService)
    fun inject(listViewModel: ListViewModel)
}