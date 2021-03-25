package com.search.testtaskapi.api

import com.search.testtaskapi.model.Images
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ImagesAPI {

    companion object {
        const val CLIENT_ID = "L5bobyLq4mVkD0lp59py_L5lfPDKWd1YITivF9yHxIs"
    }

    @Headers("Accept-Version: v1", "Authorization: Client-ID $CLIENT_ID")
    @GET("search/photos")
    suspend fun getPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Images
}