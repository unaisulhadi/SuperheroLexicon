package com.hadi.superherolexicon.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.lifecycle.ViewModelProvider
import com.hadi.superherolexicon.ui.theme.SuperheroLexiconTheme
import com.hadi.superherolexicon.view.HeroListView
import com.hadi.superherolexicon.viewmodel.HeroViewModel
import com.hadi.superherolexicon.viewmodel.ViewModelFactory
import com.hadi.superherolexicon.viewstate.HeroListViewState

class HeroesActivity : ComponentActivity() {


    private lateinit var viewModel: HeroViewModel

    @ExperimentalComposeUiApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupViewModel()

        setContent {
            SuperheroLexiconTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    when (val result = viewModel.heroes.value) {
                        HeroListViewState.Loading -> Text(text = "Loading")
                        is HeroListViewState.Error -> Text(text = "Error found: ${result.exception}")
                        is HeroListViewState.Success -> {
                            HeroListView(
                                heroList = result.data,
                                viewModel = viewModel
                            ) { hero ->
                                val intent = Intent(this, HeroDetailsActivity::class.java)
                                intent.putExtra("HERO_ID", hero.id)
                                startActivity(intent)
                            }
                        }
                        HeroListViewState.Empty -> Text("No results found!")
                    }

                }
            }
        }
    }

    private fun setupViewModel() {
        val factory = ViewModelFactory(application)
        viewModel = ViewModelProvider(this, factory).get(HeroViewModel::class.java)
    }
}
