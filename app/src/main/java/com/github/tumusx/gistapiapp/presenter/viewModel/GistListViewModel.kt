package com.github.tumusx.gistapiapp.presenter.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.tumusx.gistapiapp.data.db.GistVODB
import com.github.tumusx.gistapiapp.data.model.listGist.GistsListDTOItem
import com.github.tumusx.gistapiapp.domain.useCase.GistListUseCaseImpl
import com.github.tumusx.gistapiapp.utils.ResultAPI
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class GistListViewModel @Inject constructor(
    private val listUseCase: GistListUseCaseImpl, application: Application) : AndroidViewModel(application) {
    val getStats = MutableLiveData<List<GistsListDTOItem>>()
    val messageErrorRequest = MutableLiveData<String>()
    private var databaseFirebase: DatabaseReference

    init {
        configGistList()
        databaseFirebase = Firebase.database.reference.child("gists")
    }

    private fun configGistList() {
        listUseCase.getListGist().onEach { resultAPI ->
            when (resultAPI) {

                is ResultAPI.SuccessRequest -> {
                    getStats.postValue(resultAPI.dataResult)
                    Log.d("ok", resultAPI.dataResult.toString())
                }

                is ResultAPI.FailureRequest -> {
                    messageErrorRequest.postValue(resultAPI.messageError.toString())
                    Log.d("ERROR", resultAPI.messageError.toString())
                }
            }
        }.launchIn(viewModelScope)
    }


    fun favoriteGistItem(gistItem: GistsListDTOItem){
        try {
            val gistItems = GistVODB(gistItem.owner.login, gistItem.id, gistItem.createdAt)
            databaseFirebase.child(gistItem.id).setValue(gistItems)
        }catch (exception: Exception){
            exception.printStackTrace()
            messageErrorRequest.postValue(exception.message.toString())
        }
    }
}