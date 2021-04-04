package com.search.testtaskapi.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.search.testtaskapi.converts.Converts
import com.search.testtaskapi.model.DataNews

@Database(entities = [DataNews::class], version = 1, exportSchema = false)
@TypeConverters(Converts::class)
abstract class RoomDbApp : RoomDatabase() {

    abstract fun dao(): Dao

    companion object {
        @Volatile
        private var INSTANCE: RoomDbApp? = null

        fun getDatabase(context: Context): RoomDbApp =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                RoomDbApp::class.java, "newsDataBases"
            ).build()
    }
}