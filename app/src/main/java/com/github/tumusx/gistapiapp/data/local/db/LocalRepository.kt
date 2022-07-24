package com.github.tumusx.gistapiapp.data.local.db

import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class LocalRepository @Inject constructor(localDataSource: LocalDataSource){
    val local = localDataSource
}