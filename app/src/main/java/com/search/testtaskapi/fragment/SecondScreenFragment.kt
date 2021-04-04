package com.search.testtaskapi.fragment

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.search.testtaskapi.R


class SecondScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_second_screen, container, false)
        val textTittle = view!!.findViewById<TextView>(R.id.textTittle)
        val imageNew = view.findViewById<ImageView>(R.id.imageViewNews)
        val textDescription = view.findViewById<TextView>(R.id.textDescription)

        val description = arguments!!.getString("description")
        val tittle = arguments!!.getString("tittle")
        val url = arguments!!.getParcelable<Bitmap>("url")

        textDescription.text = description
        textTittle.text = tittle

        Glide.with(view)
            .load(url)
            .centerCrop()
            .transition(DrawableTransitionOptions.withCrossFade())
            .error(R.drawable.ic_launcher_foreground)
            .into(imageNew)


        return view
    }
}