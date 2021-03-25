package com.search.testtaskapi.activity

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.search.testtaskapi.R
import com.search.testtaskapi.adapter.ImageAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.search.testtaskapi.model.ImageData
import com.search.testtaskapi.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val listIm = ArrayList<String>()
    private lateinit var viewModel: MainViewModel
    private val adapter by lazy { ImageAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun getCurrentData() {

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getPhotos(editTextSearch.text.toString())
        viewModel.myResponse.observe(this, Observer { response ->

            Log.d("Response", response.results[0].urls.thumb.toString())

            for (i in 0 until response.results.size - 1) {
                listIm.add(response.results[i].urls.thumb.toString())

                lifecycleScope.launch {
                    val getbitmap = getBitmap(i)

                    Log.d("tag", getbitmap.toString())

                    lifecycleScope.launch {
                        val imageData = ImageData(editTextSearch.text.toString(), getBitmap(i))
                        viewModel.insertImageData(imageData)

                    }
                }
            }
            val linearLayoutManager = GridLayoutManager(this, 2)
            linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
            list.layoutManager = linearLayoutManager

            list.layoutManager = linearLayoutManager

            viewModel.readImageData.observe(this, {
                adapter.setData(it, this@MainActivity)
            })

            list.adapter = adapter

        })
    }

    fun onClickSearch(view: View) {
        getCurrentData()
    }

    private suspend fun getBitmap(count: Int): Bitmap {
        val loading = ImageLoader(this)
        val request = ImageRequest.Builder(this)
            .data(listIm[count])
            .build()

        val result = (loading.execute(request) as SuccessResult).drawable
        return (result as BitmapDrawable).bitmap
    }
}


