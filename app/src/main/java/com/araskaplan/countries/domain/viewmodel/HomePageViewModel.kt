package com.araskaplan.countries.domain.viewmodel

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.araskaplan.countries.di.DefaultDispatcher
import com.araskaplan.countries.domain.model.CountryDTO.toCountryLocalModel
import com.araskaplan.countries.domain.model.CountryHomePageUiModel
import com.araskaplan.countries.domain.usecase.local.getCountriesUseCase
import com.araskaplan.countries.domain.usecase.local.insertCountryUseCase
import com.araskaplan.countries.domain.usecase.remote.fetchCountriesUseCase
import com.araskaplan.countries.domain.usecase.remote.fetchCountryUseCase
import com.araskaplan.countries.domain.util.Util.getSvgImageAsBitmap
import com.araskaplan.countries.domain.util.Util.toBase64
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.github.twocoffeesoneteam.glidetovectoryou.GlideApp
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor(
    private val fetchCountriesUseCase: fetchCountriesUseCase,
    private val getCountriesUseCase: getCountriesUseCase,
    private val fetchCountryUseCase: fetchCountryUseCase,
    private val insertCountryUseCase: insertCountryUseCase
) : ViewModel() {

    val countryList = MutableLiveData<List<CountryHomePageUiModel>>(arrayListOf())

    fun fetchCountries() {
        viewModelScope.launch {
            countryList.value = fetchCountriesUseCase.fetchCountries()
        }
    }

    fun insertCountry(countryCode: String) {
        viewModelScope.launch {
            val detailsModel = fetchCountryUseCase.fetchCountry(countryCode)
            insertCountryUseCase.insertCountry(detailsModel.toCountryLocalModel())
        }
    }

    fun getCountries(){
        viewModelScope.launch {
            countryList.value = getCountriesUseCase.getCountries()
        }
    }
}