package com.search.testtaskapi.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.search.testtaskapi.R
import com.search.testtaskapi.adapter.CategoriesAdapter
import kotlinx.android.synthetic.main.activity_categories.*

class CategoriesActivity : AppCompatActivity() {


    var list = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        list.add("New York")
        list.add("Philadelphia")
        list.add("San Diego")
        list.add("Austin")
        list.add("Jacksonville")
        list.add("Charlotte")
        list.add("San Francisco")
        list.add("Seattle")
        list.add("Las Vegas")

        recyclerViewCategory.layoutManager = LinearLayoutManager(this)
        val adapter = CategoriesAdapter(list, this)
        recyclerViewCategory.adapter = adapter
    }
}