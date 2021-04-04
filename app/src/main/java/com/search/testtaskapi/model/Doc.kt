package com.search.testtaskapi.model

import com.google.gson.annotations.SerializedName

data class Doc(
    val `abstract`: String,
    @SerializedName("lead_paragraph")
    val leadParagraph: String,
    val multimedia: List<Multimedia>
)