package com.github.tumusx.gistapiapp.presenter.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.tumusx.gistapiapp.data.model.detailGist.GistDetailDTO
import com.github.tumusx.gistapiapp.domain.useCase.GistDetailUseCaseImpl
import com.github.tumusx.gistapiapp.utils.ResultAPI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class GistDetailViewModel @Inject constructor(private val gistsDetailUseCase: GistDetailUseCaseImpl) : ViewModel() {
    val detailGist = MutableLiveData<GistDetailDTO>()
    val messageError = MutableLiveData<String>()

    fun getDetailGists(id: String) {
        gistsDetailUseCase.getDetailGist(id).onEach { resultGetDetails ->
            when (resultGetDetails) {

                is ResultAPI.SuccessRequest -> {
                    detailGist.postValue(resultGetDetails.dataResult)
                }

                is ResultAPI.FailureRequest -> {
                    messageError.postValue(resultGetDetails.messageError)
                }
            }
        }.launchIn(viewModelScope)
    }
}