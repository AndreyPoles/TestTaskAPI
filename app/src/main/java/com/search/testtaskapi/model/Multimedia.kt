package com.search.testtaskapi.model


import com.google.gson.annotations.SerializedName

data class Multimedia(
    val caption: Any,
    val credit: Any,
    @SerializedName("crop_name")
    val cropName: String,
    val height: Int,
    val legacy: Legacy,
    val rank: Int,
    val subType: String,
    val subtype: String,
    val type: String,
    val url: String,
    val width: Int
)