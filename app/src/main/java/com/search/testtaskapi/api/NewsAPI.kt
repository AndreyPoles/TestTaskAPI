package com.search.testtaskapi.api

import com.search.testtaskapi.model.News
import retrofit2.http.GET
import retrofit2.http.Query

private val APIKey: String = "GeFdl5AHdcJG3QJLZfgqq9blH3edqef4"

interface ImagesAPI {

//    https://api.nytimes.com/svc/search/v2/articlesearch.json?q=election&api-key=GeFdl5AHdcJG3QJLZfgqq9blH3edqef4

    @GET("svc/search/v2/articlesearch.json")
    suspend fun getPhotos(
        @Query("q") query: String,
        @Query("api-key") key: String = APIKey
    ): News
}