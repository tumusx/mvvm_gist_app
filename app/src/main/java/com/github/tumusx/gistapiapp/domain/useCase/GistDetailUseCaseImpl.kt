package com.github.tumusx.gistapiapp.domain.useCase

import com.github.tumusx.gistapiapp.data.model.detailGist.GistDetailDTO
import com.github.tumusx.gistapiapp.domain.model.detailGist.GistDetailVO
import com.github.tumusx.gistapiapp.domain.repository.GistRepository
import com.github.tumusx.gistapiapp.utils.ResultAPI
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class GistDetailUseCaseImpl @Inject constructor(private val gistRepository: GistRepository) : GistDetailUseCase {
    override fun getDetailGist(idGist: String): Flow<ResultAPI<GistDetailVO>> = flow{
        try {
            val resultDataDetail = gistRepository.getDetailGist(idGist)
            val setResultVO: GistDetailVO = GistDetailVO(resultDataDetail.updatedAt, resultDataDetail.description,
                resultDataDetail.url, resultDataDetail.createdAt)
            emit(ResultAPI.SuccessRequest<GistDetailVO>(setResultVO))
        }catch (exception: Exception){
            emit(ResultAPI.FailureRequest<GistDetailVO>(messageError = exception.message.toString()))
        }
    }
}