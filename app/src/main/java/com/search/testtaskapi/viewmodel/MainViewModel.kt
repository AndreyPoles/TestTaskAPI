package com.search.testtaskapi.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.search.testtaskapi.database.RoomDbApp
import com.search.testtaskapi.model.DataNews
import com.search.testtaskapi.model.News
import com.search.testtaskapi.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel(application: Application) : AndroidViewModel(application) {

    val myResponse: MutableLiveData<News> = MutableLiveData()

    private val dao = RoomDbApp.getDatabase(application).dao()
    private val repository = Repository(dao)

    fun readImageData(tag: String): LiveData<List<DataNews>> {
        return repository.readImageData(tag)
    }

    fun getPhotos(tag: String) {
        viewModelScope.launch {
            val response: News = repository.getPhotos(tag)
            myResponse.value = response
        }
    }

    fun insertImageData(dataNews: DataNews) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertImageData(dataNews)
        }
    }

    fun searchDatabase(tag: String): Boolean {
        return repository.searchDatabase(tag)
    }
}