
package com.echo.quotes.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.echo.quotes.data.database.QuoteEntity

@Composable
fun FavoritesScreen(
    favorites: List<QuoteEntity> = emptyList(),
    onFavoriteClick: (Int) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "My Favorites",
            style = MaterialTheme.typography.headlineMedium
        )

        if (favorites.isEmpty()) {
            Text(
                text = "Your favorite quotes will appear here.",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 20.dp)
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 16.dp),
                contentPadding = PaddingValues(bottom = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(
                    items = favorites,
                    key = { it.id }
                ) { quote ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant
                        )
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = "“${quote.text}”",
                                style = MaterialTheme.typography.bodyLarge
                            )

                            Text(
                                text = "— ${quote.author}",
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(top = 10.dp)
                            )

                            Text(
                                text = quote.category,
                                style = MaterialTheme.typography.labelSmall,
                                modifier = Modifier.padding(top = 6.dp)
                            )

                            Text(
                                text = "♥ Remove from favorites",
                                color = MaterialTheme.colorScheme.primary,
                                modifier = Modifier
                                    .padding(top = 12.dp)
                                    .fillMaxWidth()
                            )
                        }
                    }
                }
            }
        }
    }
}
