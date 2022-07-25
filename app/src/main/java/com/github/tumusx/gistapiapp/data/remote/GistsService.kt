package com.github.tumusx.gistapiapp.data.remote

import com.github.tumusx.gistapiapp.data.model.detailGist.DetailGistDTO
import com.github.tumusx.gistapiapp.data.model.listGist.GistsListDTOItem
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GistsService {

    @GET("/gists/public")
    suspend fun getListGist(@Query("page") page: Int = 0): List<GistsListDTOItem>

    @GET("/gists/{gist_id}")
    suspend fun getDetailGist(@Path ("gist_id") idGist: String) : DetailGistDTO
}