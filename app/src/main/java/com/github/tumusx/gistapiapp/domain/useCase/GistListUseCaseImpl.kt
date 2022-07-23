package com.github.tumusx.gistapiapp.domain.useCase

import com.github.tumusx.gistapiapp.data.model.listGist.GistsListDTOItem
import com.github.tumusx.gistapiapp.domain.repository.GistRepository
import com.github.tumusx.gistapiapp.utils.ResultAPI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GistListUseCaseImpl @Inject constructor(private val gistRepository: GistRepository) : GistListUseCase{
    override fun getListGist(): Flow<ResultAPI<List<GistsListDTOItem>>> = flow {
        try {
            val listGistVO = gistRepository.getListGists().map { it }
            emit(ResultAPI.SuccessRequest<List<GistsListDTOItem>>(listGistVO))
        }catch (exception: Exception){
            emit(ResultAPI.FailureRequest<List<GistsListDTOItem>>(messageError = exception.message))
        }
    }
}