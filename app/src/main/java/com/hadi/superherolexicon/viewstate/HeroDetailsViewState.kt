package com.hadi.superherolexicon.viewstate

import com.hadi.superherolexicon.data.model.Hero

sealed class HeroDetailsViewState {

    object Empty : HeroDetailsViewState()
    object Loading : HeroDetailsViewState()
    data class Success(val data: Hero) : HeroDetailsViewState()
    data class Error(val exception: Throwable) : HeroDetailsViewState()
}