package com.search.testtaskapi.model


import com.google.gson.annotations.SerializedName

data class Meta(
    val hits: Int,
    val offset: Int,
    val time: Int
)