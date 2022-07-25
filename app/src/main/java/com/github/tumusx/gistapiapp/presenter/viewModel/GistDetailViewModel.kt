package com.github.tumusx.gistapiapp.presenter.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.tumusx.gistapiapp.data.model.detailGist.DetailGistDTO
import com.github.tumusx.gistapiapp.domain.useCase.GistDetailUseCaseImpl
import com.github.tumusx.gistapiapp.utils.ResultAPI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class GistDetailViewModel @Inject constructor(private val gistsDetailUseCase: GistDetailUseCaseImpl) : ViewModel() {
    val detailGist = MutableLiveData<DetailGistDTO>()
    val messageError = MutableLiveData<String>()
    val isResultLoading = MutableLiveData<Boolean>()

    fun getDetailGists(id: String) {
        isResultLoading.postValue(true)
        gistsDetailUseCase.getDetailGist(id).onEach { resultGetDetails ->
            when (resultGetDetails) {

                is ResultAPI.SuccessRequest -> {
                    isResultLoading.postValue(false)
                    detailGist.postValue(resultGetDetails.dataResult)
                }

                is ResultAPI.FailureRequest -> {
                    isResultLoading.postValue(false)
                    messageError.postValue(resultGetDetails.messageError)
                }
            }
        }.launchIn(viewModelScope)
    }
}