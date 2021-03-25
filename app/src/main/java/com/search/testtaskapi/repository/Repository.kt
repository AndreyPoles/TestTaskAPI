package com.search.testtaskapi.repository

import androidx.lifecycle.LiveData
import com.search.testtaskapi.api.RetrofitInstanse
import com.search.testtaskapi.model.ImageData
import com.search.testtaskapi.model.Images

class Repository(private val dao: com.search.testtaskapi.database.Dao) {

    val readImageData: LiveData<List<ImageData>> = dao.readImageData()

    suspend fun getPhotos(tag: String): Images {
        return RetrofitInstanse.api.getPhotos(tag, 4, 30)
    }

    suspend fun insertImageData(imageData: ImageData) {
        dao.insertImageData(imageData)
    }
}