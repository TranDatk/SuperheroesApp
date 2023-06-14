package com.example.superheroesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroesapp.data.Hero
import com.example.superheroesapp.model.HeroesRepository.heroes
import com.example.superheroesapp.ui.theme.SuperheroesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    SuperHeroesApp()
                }
            }
        }
    }
}

@Composable
fun SuperHeroesApp() {
    LazyColumn(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
        items(heroes) {
            HeroItem(hero = it, modifier = Modifier.padding(8.dp, 16.dp))
        }
    }
}

@Composable
fun HeroItem(hero: Hero, modifier: Modifier = Modifier) {
    Card(modifier = Modifier.padding(16.dp)) {

    }
}

@Composable
fun HeroInformation(@StringRes heroName: Int, @StringRes heroDescription: Int, modifier: Modifier) {
    Column(modifier = modifier.padding(end = 16.dp)) {
        Text(
            text = stringResource(id = heroName),
            style = MaterialTheme.typography.headlineSmall,

        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SuperheroesAppTheme {
        SuperHeroesApp()
    }
}