package com.search.testtaskapi.model


import com.google.gson.annotations.SerializedName

data class Person(
    val firstname: String,
    val lastname: String,
    val middlename: Any,
    val organization: String,
    val qualifier: Any,
    val rank: Int,
    val role: String,
    val title: Any
)