package com.search.testtaskapi.repository

import androidx.lifecycle.LiveData
import com.search.testtaskapi.api.RetrofitInstanse
import com.search.testtaskapi.model.DataNews
import com.search.testtaskapi.model.News

class Repository(private val dao: com.search.testtaskapi.database.Dao) {

    fun readImageData(tag: String): LiveData<List<DataNews>> {
        return dao.readImageData(tag)
    }


    suspend fun getPhotos(tag: String): News {
        return RetrofitInstanse.api.getPhotos(tag)
    }

    suspend fun insertImageData(dataNews: DataNews) {
        dao.insertImageData(dataNews)
    }

    fun searchDatabase(tag: String): Boolean {
        return dao.searchDatabase(tag)
    }
}