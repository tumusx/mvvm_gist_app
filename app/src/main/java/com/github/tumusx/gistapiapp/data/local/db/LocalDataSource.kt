package com.github.tumusx.gistapiapp.data.local.db

import com.github.tumusx.gistapiapp.data.local.dao.GistInfoDAO
import com.github.tumusx.gistapiapp.data.local.entity.GistInfoEntity
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val gistDAO: GistInfoDAO) {
    suspend fun insertGistDAO(gistInfoEntity: GistInfoEntity){
        gistDAO.insertGistsFavorites(gistInfoEntity)
    }
}