package com.search.testtaskapi.adapter

import android.content.Context
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.search.testtaskapi.R
import com.search.testtaskapi.fragment.SecondScreenFragment
import com.search.testtaskapi.model.ImageData
import kotlinx.android.synthetic.main.list_image.view.*

class ImageAdapter() :
    RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    private lateinit var url: Bitmap
    private var imageDataList = emptyList<ImageData>()
    private lateinit var context: Context

    fun setData(imageDataList: List<ImageData>, context: Context) {
        this.imageDataList = imageDataList
        this.context = context
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_image, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ImageAdapter.ViewHolder, position: Int) {

        val url = imageDataList[position].url!!
        val description = imageDataList[position].tittle
        val tittle = imageDataList[position].tittle
        holder.itemView.textViewAbstract.text = tittle

        Glide.with(holder.itemView)
            .load(url)
            .centerCrop()
            .transition(DrawableTransitionOptions.withCrossFade())
            .error(R.drawable.ic_launcher_foreground)
            .into(holder.itemView.imageView)

        holder.itemView.setOnClickListener {
            val activity = holder.itemView!!.context as AppCompatActivity
            val fragment = SecondScreenFragment()
            val bundle = Bundle()
            bundle.putString("tittle", tittle)
            bundle.putString("description", description)
            bundle.putParcelable("url", url)
            fragment.arguments = bundle
            activity.supportFragmentManager.beginTransaction().replace(R.id.rec, fragment)
                .addToBackStack(null).commit()
        }
    }

    override fun getItemCount(): Int {
        return imageDataList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}