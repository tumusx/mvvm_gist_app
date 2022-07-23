package com.github.tumusx.gistapiapp.domain.useCase

import com.github.tumusx.gistapiapp.data.model.detailGist.GistDetailDTO
import com.github.tumusx.gistapiapp.data.model.listGist.GistsListDTOItem
import com.github.tumusx.gistapiapp.domain.model.listGist.GistListVO
import com.github.tumusx.gistapiapp.utils.ResultAPI
import kotlinx.coroutines.flow.Flow

interface GistListUseCase {

    fun getListGist() : Flow<ResultAPI<List<GistsListDTOItem>>>
}