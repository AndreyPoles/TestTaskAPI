package com.search.testtaskapi.model

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "news_tables")
data class ImageData(
    @field:SerializedName("Name")
    var name: String = "",
    @field:SerializedName("Tittle")
    var tittle: String = "",
    @field:SerializedName("LeadParagraph")
    var leadParagraph: String = "",
    @field:SerializedName("Url")
    var url: Bitmap? = null
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}