package com.echo.quotes.data.database

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject

class DatabaseInitializer(
    private val quoteDao: QuoteDao
) {
    suspend fun initializeFromAssets(context: Context) {
        withContext(Dispatchers.IO) {
            if (quoteDao.getQuoteCount() > 0) return@withContext

            val quotes = context.assets.open("quotes.jsonl")
                .bufferedReader()
                .useLines { lines ->
                    lines.filter { it.isNotBlank() }
                        .map { line ->
                            val json = JSONObject(line)

                            QuoteEntity(
                                id = json.getInt("id"),
                                text = json.getString("text"),
                                author = json.getString("author"),
                                category = json.getString("category")
                            )
                        }
                        .toList()
                }

            if (quotes.isNotEmpty()) {
                quoteDao.insertQuotes(quotes)
            }
        }
    }
}
