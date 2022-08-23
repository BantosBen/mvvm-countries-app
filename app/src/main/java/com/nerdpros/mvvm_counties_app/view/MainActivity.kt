package com.nerdpros.mvvm_counties_app.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.nerdpros.mvvm_counties_app.R
import com.nerdpros.mvvm_counties_app.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ListViewModel
    private lateinit var interstitialAd: InterstitialAd
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

        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = false
            viewModel.refresh()
        }

        MobileAds.initialize(this)
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

        setUpObserver()
    }

    private fun setUpObserver() {
        viewModel.countries.observe(this) { countries ->
            countries?.let { _countries ->
                countriesList.visibility = View.VISIBLE
                countryAdapter.updateCountries(_countries)
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