package com.github.tumusx.gistapiapp.data.repository

import com.github.tumusx.gistapiapp.data.api.GistsService
import com.github.tumusx.gistapiapp.data.model.detailGist.GistDetailDTO
import com.github.tumusx.gistapiapp.data.model.listGist.GistsListDTOItem
import com.github.tumusx.gistapiapp.domain.repository.GistRepository
import com.github.tumusx.gistapiapp.utils.ResultAPI
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GistRepositoryImp @Inject constructor(gistsService: GistsService) : GistRepository {
    override suspend fun getListGists(): List<GistsListDTOItem> {
       return getListGists()
    }

    override suspend fun getDetailGist(idGist: String): GistDetailDTO {
        return getDetailGist(idGist)
    }
}