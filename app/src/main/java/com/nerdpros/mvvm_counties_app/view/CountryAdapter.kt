package com.nerdpros.mvvm_counties_app.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nerdpros.mvvm_counties_app.Country
import com.nerdpros.mvvm_counties_app.R
import com.nerdpros.mvvm_counties_app.util.getProgressDrawable
import com.nerdpros.mvvm_counties_app.util.loadImage

/**
 * @Author: Angatia Benson
 * @Date: 22/08/2022
 * Copyright (c) 2022 Bantechnis
 */
class CountryAdapter(var countries: ArrayList<Country>) :
    RecyclerView.Adapter<CountryAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var countryFlag: ImageView
        private var countryName: TextView
        private var countryCapital: TextView
        private var progressDrawable = getProgressDrawable(itemView.context)

        init {
            countryFlag = itemView.findViewById(R.id.country_flag)
            countryName = itemView.findViewById(R.id.country_name)
            countryCapital = itemView.findViewById(R.id.country_capital)
        }

        fun bind(country: Country) {
            countryName.text = country.countryName
            countryCapital.text = country.capital
            countryFlag.loadImage(country.flagPNG, progressDrawable)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.country_item,
            null,
            false
        )
    )


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    override fun getItemCount() = countries.size

    fun updateCountries(newCountries: List<Country>) {
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }

}