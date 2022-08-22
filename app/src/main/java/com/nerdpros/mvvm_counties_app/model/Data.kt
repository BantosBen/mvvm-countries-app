package com.nerdpros.mvvm_counties_app

import com.google.gson.annotations.SerializedName

/**
 * @Author: Angatia Benson
 * @Date: 22/08/2022
 * Copyright (c) 2022 Bantechnis
 */

data class Country(
    @SerializedName("name")
    val countryName: String?,
    @SerializedName("capital")
    val capital: String?,
    @SerializedName("flagPNG")
    val flagPNG: String?
)