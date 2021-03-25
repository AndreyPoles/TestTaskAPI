package com.search.testtaskapi.model


import com.google.gson.annotations.SerializedName

data class Doc(
    val `abstract`: String,
    val byline: Byline,
    @SerializedName("document_type")
    val documentType: String,
    val headline: Headline,
    @SerializedName("_id")
    val id: String,
    val keywords: List<Keyword>,
    @SerializedName("lead_paragraph")
    val leadParagraph: String,
    val multimedia: List<Multimedia>,
    @SerializedName("news_desk")
    val newsDesk: String,
    @SerializedName("print_page")
    val printPage: String,
    @SerializedName("print_section")
    val printSection: String,
    @SerializedName("pub_date")
    val pubDate: String,
    @SerializedName("section_name")
    val sectionName: String,
    val snippet: String,
    val source: String,
    @SerializedName("subsection_name")
    val subsectionName: String,
    @SerializedName("type_of_material")
    val typeOfMaterial: String,
    val uri: String,
    @SerializedName("web_url")
    val webUrl: String,
    @SerializedName("word_count")
    val wordCount: Int
)