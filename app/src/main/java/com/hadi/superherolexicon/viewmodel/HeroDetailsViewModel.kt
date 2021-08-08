package com.hadi.superherolexicon.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.hadi.superherolexicon.data.model.Hero
import com.hadi.superherolexicon.utils.Utils
import com.hadi.superherolexicon.viewstate.HeroDetailsViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.serialization.decodeFromString

class HeroDetailsViewModel(application: Application) : AndroidViewModel(application) {

    private val _viewState = MutableStateFlow<HeroDetailsViewState>(HeroDetailsViewState.Loading)
    val heroDetail = _viewState.asStateFlow()

    fun getHeroDetails(heroId: Int) {

        try {

            // read JSON File
            val myJson = getApplication<Application>().applicationContext.assets.open("heroes.json")
                .bufferedReader().use {
                it.readText()
            }

            // format JSON
            val heroList = Utils.format.decodeFromString<List<Hero>>(myJson)
            val hero = heroList.first { it.id == heroId }
            _viewState.value = HeroDetailsViewState.Success(hero)

        } catch (e: Exception) {
            _viewState.value = HeroDetailsViewState.Error(e)
        }

    }

}