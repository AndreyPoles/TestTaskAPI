package com.search.testtaskapi.activity

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.search.testtaskapi.R
import com.search.testtaskapi.adapter.NewsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.search.testtaskapi.model.DataNews
import com.search.testtaskapi.viewmodel.MainViewModel
import kotlinx.coroutines.Dispatchers

class MainActivity : AppCompatActivity() {

    private val listIm = ArrayList<String>()
    private lateinit var viewModel: MainViewModel
    private val adapter by lazy { NewsAdapter() }
    private lateinit var category: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        category = intent.getStringExtra("category").toString()

        getCurrentData()
    }

    fun getCurrentData() {

        val tag: String = category
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getPhotos(tag)
        viewModel.myResponse.observe(this, Observer { response ->
            if (response != null) {
                for (i in 0 until response.response.docs.size - 1) {
                    listIm.add("https://static01.nyt.com/${response.response.docs[i].multimedia[0].url}")

                    lifecycleScope.launch {
                        val getbitmap = getBitmap(i)
                        val tittle: String = response.response.docs[i].abstract
                        val leadParagraph: String = response.response.docs[i].leadParagraph

                        lifecycleScope.launch(Dispatchers.IO) {
                            if (!viewModel.searchDatabase(tittle)) {
                                val imageData = DataNews(tag, tittle, leadParagraph, getbitmap)
                                viewModel.insertImageData(imageData)
                            }
                        }
                    }
                }

                val linearLayoutManager = GridLayoutManager(this, 2)
                linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

                list.layoutManager = linearLayoutManager

                viewModel.readImageData(tag).observe(this, {
                    adapter.setData(it, this@MainActivity)
                })

                list.adapter = adapter
            }
        })
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


