package com.search.testtaskapi.model


import com.google.gson.annotations.SerializedName

data class Headline(
    @SerializedName("content_kicker")
    val contentKicker: Any,
    val kicker: String,
    val main: String,
    val name: Any,
    @SerializedName("print_headline")
    val printHeadline: String,
    val seo: Any,
    val sub: Any
)