package com.github.tumusx.gistapiapp.data.repository

import com.github.tumusx.gistapiapp.data.model.detailGist.DetailGistDTO
import com.github.tumusx.gistapiapp.data.remote.GistsService
import com.github.tumusx.gistapiapp.data.model.listGist.GistsListDTOItem
import com.github.tumusx.gistapiapp.domain.repository.GistRepository
import javax.inject.Inject

class GistRepositoryImp @Inject constructor(private val gistsService: GistsService) : GistRepository {
    override suspend fun getListGists(): List<GistsListDTOItem> {
       return gistsService.getListGist()
    }

    override suspend fun getDetailGist(idGist: String): DetailGistDTO {
        return gistsService.getDetailGist(idGist)
    }
}