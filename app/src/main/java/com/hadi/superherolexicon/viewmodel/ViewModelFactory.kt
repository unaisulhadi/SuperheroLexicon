package com.hadi.superherolexicon.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(HeroViewModel::class.java) -> {
                HeroViewModel(application) as T
            }
            modelClass.isAssignableFrom(HeroDetailsViewModel::class.java) -> {
                HeroDetailsViewModel(application) as T
            }
            else -> throw IllegalArgumentException("Unknown class name")
        }
}