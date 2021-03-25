package com.search.testtaskapi.model


import com.google.gson.annotations.SerializedName

data class Byline(
    val organization: Any,
    val original: String,
    val person: List<Person>
)