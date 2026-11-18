
package com.echo.quotes.data.database

class DatabaseInitializer(
    private val quoteDao: QuoteDao
) {
    suspend fun initialize(initialQuotes: List<QuoteEntity>) {
        if (quoteDao.getQuoteCount() == 0 && initialQuotes.isNotEmpty()) {
            quoteDao.insertQuotes(initialQuotes)
        }
    }
}
