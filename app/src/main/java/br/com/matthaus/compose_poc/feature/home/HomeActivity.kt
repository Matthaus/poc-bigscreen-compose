package br.com.matthaus.compose_poc.feature.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.tv.foundation.lazy.list.TvLazyColumn
import androidx.tv.foundation.lazy.list.TvLazyRow
import androidx.tv.material3.Card
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Surface
import br.com.matthaus.compose_poc.feature.home.HomeViewModel.HomeState.Error
import br.com.matthaus.compose_poc.feature.home.HomeViewModel.HomeState.Loading
import br.com.matthaus.compose_poc.feature.home.HomeViewModel.HomeState.Success
import br.com.matthaus.compose_poc.model.Movie
import br.com.matthaus.compose_poc.ui.theme.Compose_pocTheme
import coil.compose.AsyncImage
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : ComponentActivity() {

    private val homeViewModel: HomeViewModel by viewModel()

    @OptIn(ExperimentalTvMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        homeViewModel.fetchPage()

        setContent {
            Compose_pocTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    shape = RectangleShape
                ) {
                    HomeContent()
                }
            }
        }
    }

    @OptIn(ExperimentalTvMaterial3Api::class)
    @Composable
    private fun HomeContent() {
        val state by homeViewModel.state.collectAsState()

        when (state) {
            is Loading -> {
                LoadingHomeContent()
            }

            is Error -> {
                // Error
            }

            is Success -> {
                SuccessHomeContent(state as Success)
            }
        }
    }

    @OptIn(ExperimentalTvMaterial3Api::class)
    @Composable
    private fun LoadingHomeContent() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier.width(64.dp),
                color = MaterialTheme.colorScheme.secondary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant,
            )
        }
    }


    @OptIn(ExperimentalTvMaterial3Api::class)
    @Composable
    private fun SuccessHomeContent(state: Success) {
        TvLazyColumn(
            modifier = Modifier.padding(24.dp)
        ) {
            items(state.page.content.size) { rowIndex ->
                val row = state.page.content[rowIndex]

                TvLazyRow {
                    items(row.size) { columnIndex ->
                        val column = row[columnIndex]
                        MovieCard(movie = column)
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalTvMaterial3Api::class)
    @Composable
    private fun MovieCard(movie: Movie) {
        Card(
            modifier = Modifier
                .padding(16.dp),
            onClick = {}
        ) {
            AsyncImage(
                modifier = Modifier.size(
                    width = 135.dp,
                    height = 200.dp
                ),
                model = movie.poster,
                contentDescription = null
            )
        }
    }

}