package com.nerdpros.mvvm_counties_app.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nerdpros.mvvm_counties_app.Country
import com.nerdpros.mvvm_counties_app.R

/**
 * @Author: Angatia Benson
 * @Date: 22/08/2022
 * Copyright (c) 2022 Bantechnis
 */
class CountryAdapter(var countries: ArrayList<Country>) :
    RecyclerView.Adapter<CountryAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(country: Country) {

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

    override fun getItemCount()= countries.size

    fun updateCountries(newCountries:ArrayList<Country>){
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }

}