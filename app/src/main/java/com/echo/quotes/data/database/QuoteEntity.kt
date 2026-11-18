package com.echo.quotes.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quotes")
data class QuoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val text: String,
    val author: String = "Unknown",
    val category: String,
    val isFavorite: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)
