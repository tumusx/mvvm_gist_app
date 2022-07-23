package com.github.tumusx.gistapiapp.data.api

import com.github.tumusx.gistapiapp.data.model.detailGist.GistDetailDTO
import com.github.tumusx.gistapiapp.data.model.listGist.GistsListDTOItem
import retrofit2.http.GET
import retrofit2.http.Path

interface GistsService {

    @GET("/gists/public")
    suspend fun getListGist(): List<GistDetailDTO>

    @GET("/gists/{gist_id}")
    suspend fun getDetailGist(@Path ("gist_id") idGist: String) : GistDetailDTO
}