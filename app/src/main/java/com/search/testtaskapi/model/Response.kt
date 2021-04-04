package com.search.testtaskapi.model


import com.google.gson.annotations.SerializedName

data class Response(
    val docs: List<Doc>
)