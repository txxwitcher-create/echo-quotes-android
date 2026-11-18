
package com.echo.quotes.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.echo.quotes.data.database.QuoteEntity
import com.echo.quotes.data.repositories.QuoteRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class QuoteViewModel(
    private val repository: QuoteRepository
) : ViewModel() {

    val quotes: StateFlow<List<QuoteEntity>> =
        repository.getAllQuotes().stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    val favorites: StateFlow<List<QuoteEntity>> =
        repository.getFavorites().stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    private val _searchQuery = MutableStateFlow("")

    val searchQuery: StateFlow<String> =
        _searchQuery.asStateFlow()

    @OptIn(ExperimentalCoroutinesApi::class)
    val searchResults: StateFlow<List<QuoteEntity>> =
        _searchQuery
            .flatMapLatest { query ->
                if (query.isBlank()) {
                    repository.getAllQuotes()
                } else {
                    repository.searchQuotes(query)
                }
            }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                emptyList()
            )

    private val _quoteCount = MutableStateFlow(0)

    val quoteCount: StateFlow<Int> =
        _quoteCount.asStateFlow()

    init {
        refreshQuoteCount()
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun toggleFavorite(quoteId: Int) {
        viewModelScope.launch {
            repository.toggleFavorite(quoteId)
        }
    }

    fun refreshQuoteCount() {
        viewModelScope.launch {
            _quoteCount.value = repository.getQuoteCount()
        }
    }
}
