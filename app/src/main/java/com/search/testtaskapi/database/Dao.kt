package com.search.testtaskapi.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.search.testtaskapi.model.ImageData

@Dao
interface Dao {
    @Query("SELECT * FROM my_table ORDER BY id ASC")
    fun readImageData(): LiveData<List<ImageData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImageData(imageData: ImageData)
}