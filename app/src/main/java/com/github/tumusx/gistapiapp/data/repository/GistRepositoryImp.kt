package com.github.tumusx.gistapiapp.data.repository

import com.github.tumusx.gistapiapp.data.api.GistsService
import com.github.tumusx.gistapiapp.data.model.detailGist.GistDetailDTO
import com.github.tumusx.gistapiapp.data.model.listGist.GistsListDTOItem
import com.github.tumusx.gistapiapp.domain.repository.GistRepository
import javax.inject.Inject

class GistRepositoryImp @Inject constructor(private val gistsService: GistsService) : GistRepository {
    override suspend fun getListGists(): List<GistsListDTOItem> {
       return gistsService.getListGist()
    }

    override suspend fun getDetailGist(idGist: String): GistDetailDTO {
        return gistsService.getDetailGist(idGist)
    }
}