package com.echo.quotes.data.repositories

import com.echo.quotes.data.database.QuoteDao
import com.echo.quotes.data.database.QuoteEntity
import kotlinx.coroutines.flow.Flow

class QuoteRepository(
    private val quoteDao: QuoteDao
) {

    fun getAllQuotes(): Flow<List<QuoteEntity>> {
        return quoteDao.getAllQuotes()
    }

    fun getFavorites(): Flow<List<QuoteEntity>> {
        return quoteDao.getFavorites()
    }

    fun searchQuotes(query: String): Flow<List<QuoteEntity>> {
        return quoteDao.searchQuotes(query.trim())
    }

    suspend fun getQuoteById(id: Int): QuoteEntity? {
        return quoteDao.getQuoteById(id)
    }

    suspend fun getQuoteCount(): Int {
        return quoteDao.getQuoteCount()
    }

    suspend fun insertQuotes(quotes: List<QuoteEntity>) {
        quoteDao.insertQuotes(quotes)
    }

    suspend fun setFavorite(id: Int, isFavorite: Boolean) {
        quoteDao.updateFavorite(id, isFavorite)
    }

    suspend fun toggleFavorite(id: Int) {
        val quote = quoteDao.getQuoteById(id) ?: return
        quoteDao.updateFavorite(id, !quote.isFavorite)
    }
}
