package com.echo.quotes.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface QuoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertQuotes(quotes: List<QuoteEntity>)

    @Query("SELECT * FROM quotes ORDER BY id DESC")
    fun getAllQuotes(): Flow<List<QuoteEntity>>

    @Query("SELECT * FROM quotes WHERE id = :id LIMIT 1")
    suspend fun getQuoteById(id: Int): QuoteEntity?

    @Query("SELECT * FROM quotes WHERE isFavorite = 1 ORDER BY id DESC")
    fun getFavorites(): Flow<List<QuoteEntity>>

    @Query("UPDATE quotes SET isFavorite = :favorite WHERE id = :id")
    suspend fun updateFavorite(id: Int, favorite: Boolean)

    @Query("SELECT COUNT(*) FROM quotes")
    suspend fun getQuoteCount(): Int

    @Query("""
        SELECT * FROM quotes
        WHERE text LIKE '%' || :query || '%'
        OR author LIKE '%' || :query || '%'
        OR category LIKE '%' || :query || '%'
        ORDER BY id DESC
    """)
    fun searchQuotes(query: String): Flow<List<QuoteEntity>>
}
