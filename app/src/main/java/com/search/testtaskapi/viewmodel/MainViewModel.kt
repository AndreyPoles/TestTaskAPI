package com.search.testtaskapi.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.search.testtaskapi.database.RoomDbApp
import com.search.testtaskapi.model.ImageData
import com.search.testtaskapi.model.News
import com.search.testtaskapi.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel(application: Application) : AndroidViewModel(application) {

    val myResponse: MutableLiveData<News> = MutableLiveData()

    private val dao = RoomDbApp.getDatabase(application).dao()
    private val repository = Repository(dao)

    val readImageData: LiveData<List<ImageData>> = repository.readImageData

    fun getPhotos(tag: String) {
        viewModelScope.launch {
            val response: News = repository.getPhotos(tag)
            myResponse.value = response
        }
    }

    fun insertImageData(imageData: ImageData) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertImageData(imageData)
        }
    }
}