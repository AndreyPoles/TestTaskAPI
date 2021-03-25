package com.search.testtaskapi.model


import com.google.gson.annotations.SerializedName

data class Keyword(
    val major: String,
    val name: String,
    val rank: Int,
    val value: String
)