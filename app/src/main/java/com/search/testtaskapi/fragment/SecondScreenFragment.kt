package com.search.testtaskapi.fragment

import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.search.testtaskapi.R
import kotlinx.android.synthetic.main.fragment_second_screen.*
import kotlinx.android.synthetic.main.list_image.view.*

class SecondScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_second_screen, container, false)

        var url = arguments!!.getParcelable<Bitmap>("url")

        Log.d("Main", url.toString())

        return view
    }
}