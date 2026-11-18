
package com.echo.quotes.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.echo.quotes.data.database.EchoDatabase
import com.echo.quotes.data.repositories.QuoteRepository

class QuoteViewModelFactory(
    context: Context
) : ViewModelProvider.Factory {

    private val database =
        EchoDatabase.getDatabase(context)

    private val repository =
        QuoteRepository(database.quoteDao())

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {
        if (modelClass.isAssignableFrom(QuoteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return QuoteViewModel(repository) as T
        }

        throw IllegalArgumentException(
            "Unknown ViewModel class: ${modelClass.name}"
        )
    }
}
