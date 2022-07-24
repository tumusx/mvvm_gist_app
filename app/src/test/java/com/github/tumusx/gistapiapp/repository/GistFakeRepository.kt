package com.github.tumusx.gistapiapp.repository

import com.github.tumusx.gistapiapp.data.model.detailGist.DetailGistDTO
import com.github.tumusx.gistapiapp.data.model.listGist.GistsListDTOItem
import com.github.tumusx.gistapiapp.domain.repository.GistRepository

class GistFakeRepository : GistRepository{
    private val gists = mutableListOf<GistsListDTOItem>()
    private val detailGist = mutableListOf<DetailGistDTO>()

    override suspend fun getListGists(): List<GistsListDTOItem> {
        return gists
    }

    override suspend fun getDetailGist(idGist: String): DetailGistDTO {
        return detailGist.find { it.id == idGist }!!
    }
}