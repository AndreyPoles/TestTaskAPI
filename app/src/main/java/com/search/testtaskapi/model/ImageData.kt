package com.search.testtaskapi.model

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_table")
class ImageData (
    val Name: String,
    val url: Bitmap
    ) {
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0
}