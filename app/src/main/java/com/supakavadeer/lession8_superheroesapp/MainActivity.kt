package com.supakavadeer.lession8_superheroesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.supakavadeer.lession8_superheroesapp.model.Hero
import com.supakavadeer.lession8_superheroesapp.model.HeroesRepository.heroes
import com.supakavadeer.lession8_superheroesapp.ui.HeroLayout
import com.supakavadeer.lession8_superheroesapp.ui.theme.Lession8_SuperheroesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lession8_SuperheroesAppTheme {
                HeroApp()
            }
        }
    }
}

@Composable
fun HeroApp(modifier: Modifier = Modifier) {
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = { HeroTopAppBar() }) { paddingValues ->
        LazyColumn(modifier.padding(paddingValues)) {
            items(heroes) {
                HeroItem(
                    hero = it,
                    modifier = Modifier
                )
            }
        }
    }
}


@Composable
fun HeroItem(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    HeroLayout(
        heroIcon = hero.imageRes,
        heroName = hero.nameRes,
        heroDescription = hero.descriptionRes,
        modifier = modifier
    )

}

@OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
@Composable
fun HeroTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(title = {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge
            )
        }
    })
}
