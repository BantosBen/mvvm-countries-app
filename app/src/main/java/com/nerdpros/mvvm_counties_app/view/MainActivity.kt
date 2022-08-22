package com.nerdpros.mvvm_counties_app.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.nerdpros.mvvm_counties_app.Country
import com.nerdpros.mvvm_counties_app.R
import com.nerdpros.mvvm_counties_app.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ListViewModel
    private var countryAdapter = CountryAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this)[ListViewModel::class.java]
        viewModel.refresh()

        countriesList.apply {
            layoutManager = LinearLayoutManager(baseContext)
            adapter = countryAdapter
        }

        setUpObserver()
    }

    private fun setUpObserver() {
        viewModel.countries.observe(this) { countries ->
            countries?.let { _countries ->
                countryAdapter.updateCountries(_countries as ArrayList<Country>)
            }
        }
        viewModel.countryLoadError.observe(this) { isError ->
            isError?.let {
                list_error.visibility = if (it) View.VISIBLE else View.GONE
            }
        }
        viewModel.loading.observe(this) { isLoading ->
            isLoading?.let {
                loading_view.visibility = if (it) View.VISIBLE else View.GONE
                if (it) {
                    list_error.visibility = View.GONE
                    countriesList.visibility = View.GONE
                }
            }
        }
    }
}