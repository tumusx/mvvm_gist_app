package com.github.tumusx.gistapiapp.domain.repository

import com.github.tumusx.gistapiapp.data.model.detailGist.DetailGistDTO
import com.github.tumusx.gistapiapp.data.model.listGist.GistsListDTOItem

interface GistRepository {
    suspend fun getListGists(): List<GistsListDTOItem>
    suspend fun getDetailGist(idGist: String): DetailGistDTO
}