package com.echo.quotes.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [QuoteEntity::class],
    version = 1,
    exportSchema = false
)
abstract class EchoDatabase : RoomDatabase() {

    abstract fun quoteDao(): QuoteDao

    companion object {
        @Volatile
        private var INSTANCE: EchoDatabase? = null

        fun getDatabase(context: Context): EchoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    EchoDatabase::class.java,
                    "echo_quotes_database"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}
