package com.search.testtaskapi.database

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.search.testtaskapi.model.DataNews


@Dao
interface Dao {

    @Query("SELECT * FROM news_tables Where  name= :tag")
    fun readImageData(tag: String): LiveData<List<DataNews>>

    @Query("SELECT EXISTS(SELECT 1 FROM news_tables Where  tittle= :tag)")
    fun searchDatabase(tag: String): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImageData(dataNews: DataNews)

}