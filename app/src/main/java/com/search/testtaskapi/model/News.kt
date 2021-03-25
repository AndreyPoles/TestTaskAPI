package com.search.testtaskapi.model


import com.google.gson.annotations.SerializedName

data class News(
    val copyright: String,
    val response: Response,
    val status: String
)