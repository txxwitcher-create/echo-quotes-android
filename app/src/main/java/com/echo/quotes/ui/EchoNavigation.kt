package com.echo.quotes.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.echo.quotes.data.database.DatabaseInitializer
import com.echo.quotes.data.database.EchoDatabase
import com.echo.quotes.ui.screens.CategoriesScreen
import com.echo.quotes.ui.screens.ExploreScreen
import com.echo.quotes.ui.screens.FavoritesScreen
import com.echo.quotes.ui.screens.HomeScreen
import com.echo.quotes.ui.screens.SettingsScreen
import com.echo.quotes.ui.viewmodel.QuoteViewModel
import com.echo.quotes.ui.viewmodel.QuoteViewModelFactory

@Composable
fun EchoNavigation() {
    val context = LocalContext.current

    val quoteViewModel: QuoteViewModel = viewModel(
        factory = QuoteViewModelFactory(context)
    )

    LaunchedEffect(Unit) {
        val database = EchoDatabase.getDatabase(context)
        DatabaseInitializer(database.quoteDao())
            .initializeFromAssets(context)
        quoteViewModel.refreshQuoteCount()
    }

    val favorites by quoteViewModel.favorites.collectAsState()
    val searchQuery by quoteViewModel.searchQuery.collectAsState()
    val searchResults by quoteViewModel.searchResults.collectAsState()

    var selectedTab by remember { mutableStateOf("Home") }
    var darkTheme by remember { mutableStateOf(false) }
    var remindersEnabled by remember { mutableStateOf(false) }

    val tabs = listOf(
        "Home",
        "Explore",
        "Favorites",
        "Categories",
        "Settings"
    )

    MaterialTheme {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    tabs.forEach { tab ->
                        NavigationBarItem(
                            selected = selectedTab == tab,
                            onClick = { selectedTab = tab },
                            icon = {
                                Text(
                                    when (tab) {
                                        "Home" -> "⌂"
                                        "Explore" -> "⌕"
                                        "Favorites" -> "♡"
                                        "Categories" -> "▦"
                                        else -> "⚙"
                                    }
                                )
                            },
                            label = { Text(tab) }
                        )
                    }
                }
            }
        ) {
            when (selectedTab) {
                "Home" -> HomeScreen(
                    onExploreClick = { selectedTab = "Explore" },
                    onFavoritesClick = { selectedTab = "Favorites" }
                )

                "Explore" -> ExploreScreen(
                    quotes = searchResults,
                    searchQuery = searchQuery,
                    onSearchQueryChange = {
                        quoteViewModel.updateSearchQuery(it)
                    },
                    onFavoriteClick = {
                        quoteViewModel.toggleFavorite(it)
                    }
                )

                "Favorites" -> FavoritesScreen(
                    favorites = favorites,
                    onFavoriteClick = {
                        quoteViewModel.toggleFavorite(it)
                    }
                )

                "Categories" -> CategoriesScreen()

                "Settings" -> SettingsScreen(
                    darkTheme = darkTheme,
                    onThemeChange = { darkTheme = it },
                    remindersEnabled = remindersEnabled,
                    onRemindersChange = { remindersEnabled = it }
                )
            }
        }
    }
}
