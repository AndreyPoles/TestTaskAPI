package com.search.testtaskapi.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.search.testtaskapi.R
import com.search.testtaskapi.activity.MainActivity
import kotlinx.android.synthetic.main.list_categories.view.*


class CategoriesAdapter(private val list: ArrayList<String>, private val context: Context) :
    RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_categories, parent, false)
        return CategoriesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        var item = list[position]
        holder.itemView.text_categories.text = item
        holder.itemView.setOnClickListener {
            val intent = Intent(
                context,
                MainActivity::class.java
            )
            intent.putExtra("category", item)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class CategoriesViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView)
}