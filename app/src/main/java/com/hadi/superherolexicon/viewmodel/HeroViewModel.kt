package com.hadi.superherolexicon.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.hadi.superherolexicon.data.model.Hero
import com.hadi.superherolexicon.utils.Utils
import com.hadi.superherolexicon.viewstate.HeroListViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import java.lang.Exception

class HeroViewModel(application: Application) : AndroidViewModel(application) {

    private val _viewState = MutableStateFlow<HeroListViewState>(HeroListViewState.Loading)
    val heroes = _viewState.asStateFlow()

    init {
        getAllHeroes()
    }

    private fun getAllHeroes() = viewModelScope.launch {
        try {
            val heroJson =
                getApplication<Application>().applicationContext.assets.open("heroes.json")
                    .bufferedReader().use {
                    it.readText()
                }

            val heroList = Utils.format.decodeFromString<List<Hero>>(heroJson)
            _viewState.value = HeroListViewState.Success(heroList)
        } catch (e: Exception) {
            _viewState.value = HeroListViewState.Error(e)
        }
    }


}

