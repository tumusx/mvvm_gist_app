package com.github.tumusx.gistapiapp.presenter.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.github.tumusx.gistapiapp.data.local.db.LocalRepository
import com.github.tumusx.gistapiapp.data.local.entity.GistInfoEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GistActionViewModel @Inject constructor(private val repository: LocalRepository, application: Application): AndroidViewModel(application) {

    fun insertGists(gistInfoEntity: GistInfoEntity){
        viewModelScope.launch {
            repository.local.insertGistDAO(gistInfoEntity)
        }
    }
}