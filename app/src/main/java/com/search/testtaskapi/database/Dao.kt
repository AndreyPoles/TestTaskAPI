package com.search.testtaskapi.database

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.search.testtaskapi.model.ImageData


@Dao
interface Dao {
    @Query("SELECT * FROM my_tab ORDER BY id ASC")
    fun readImageData(): LiveData<List<ImageData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImageData(imageData: ImageData)

    @Delete
    fun deleteImageData(imageData: ImageData)
}