package com.hadi.superherolexicon.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import com.hadi.superherolexicon.ui.theme.SuperheroLexiconTheme
import com.hadi.superherolexicon.view.HeroDetailView
import com.hadi.superherolexicon.viewmodel.HeroDetailsViewModel
import com.hadi.superherolexicon.viewmodel.ViewModelFactory
import com.hadi.superherolexicon.viewstate.HeroDetailsViewState

class HeroDetailsActivity : ComponentActivity() {

    private lateinit var viewModel: HeroDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupViewModel()
        getHeroDetails()

        setContent {
            SuperheroLexiconTheme {
                Surface(color = MaterialTheme.colors.background) {

                    when (val result = viewModel.heroDetail.value) {
                        HeroDetailsViewState.Loading -> Text(text = "Loading")
                        is HeroDetailsViewState.Error -> Text(text = "Error found: ${result.exception}")
                        is HeroDetailsViewState.Success -> {
                            HeroDetailView(hero = result.data)
                        }
                        HeroDetailsViewState.Empty -> Text("Unable to get Hero details!!")
                    }
                }
            }
        }
    }

    private fun getHeroDetails() {
        val heroId = intent?.getIntExtra("HERO_ID", 1) ?: 1
        viewModel.getHeroDetails(heroId)
    }

    private fun setupViewModel() {
        val factory = ViewModelFactory(application)
        viewModel = ViewModelProvider(this, factory).get(HeroDetailsViewModel::class.java)
    }

}


@Composable
fun MyView() {

    LazyColumn() {

        item {
            Text(text = "TEST")
        }

        item {
            Text(text = "TEST")
        }

    }

}
