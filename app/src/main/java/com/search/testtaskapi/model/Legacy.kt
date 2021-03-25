package com.search.testtaskapi.model


import com.google.gson.annotations.SerializedName

data class Legacy(
    val thumbnail: String,
    val thumbnailheight: Int,
    val thumbnailwidth: Int,
    val wide: String,
    val wideheight: Int,
    val widewidth: Int,
    val xlarge: String,
    val xlargeheight: Int,
    val xlargewidth: Int
)