package com.hadi.superherolexicon.viewstate

import com.hadi.superherolexicon.data.model.Hero

sealed class HeroListViewState {

    object Empty : HeroListViewState()
    object Loading : HeroListViewState()
    data class Success(val data: List<Hero>) : HeroListViewState()
    data class Error(val exception: Throwable) : HeroListViewState()
}