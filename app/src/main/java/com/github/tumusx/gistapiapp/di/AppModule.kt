package com.github.tumusx.gistapiapp.di

import com.github.tumusx.gistapiapp.data.remote.GistsService
import com.github.tumusx.gistapiapp.data.repository.GistRepositoryImp
import com.github.tumusx.gistapiapp.domain.repository.GistRepository
import com.github.tumusx.gistapiapp.utils.ConstUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun configRetrofitAPI() : GistsService{
        return Retrofit.Builder().baseUrl(ConstUtils.BASE_URL_SERVICE).
        addConverterFactory(GsonConverterFactory.create()).build().create(GistsService::class.java)
    }


    @Provides
    @Singleton
    fun configRepositoryGists(gistsService: GistsService) : GistRepository{
        return GistRepositoryImp(gistsService)
    }

}