package com.github.tumusx.gistapiapp.di

import com.github.tumusx.gistapiapp.data.api.GistsService
import com.github.tumusx.gistapiapp.data.repository.GistRepositoryImp
import com.github.tumusx.gistapiapp.domain.repository.GistRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun configRetrofitAPI() : GistsService{
        return Retrofit.Builder().baseUrl("https://api.github.com").
        addConverterFactory(GsonConverterFactory.create()).build().create(GistsService::class.java)

    }

    @Provides
    @Singleton
    fun configRepositoryGists(gistsService: GistsService) : GistRepository{
        return GistRepositoryImp(gistsService)
    }

}