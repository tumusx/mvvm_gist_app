package com.github.tumusx.gistapiapp.di

import android.content.Context
import androidx.room.Room
import com.github.tumusx.gistapiapp.data.local.db.GistDataBase
import com.github.tumusx.gistapiapp.data.remote.GistsService
import com.github.tumusx.gistapiapp.data.repository.GistRepositoryImp
import com.github.tumusx.gistapiapp.domain.repository.GistRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
        return Retrofit.Builder().baseUrl("https://api.github.com").
        addConverterFactory(GsonConverterFactory.create()).build().create(GistsService::class.java)
    }

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, GistDataBase::class.java, "GistDataBase").build()

    @Singleton
    @Provides
    fun provideDAO(dataBase: GistDataBase) = dataBase.gistDAO()

    @Provides
    @Singleton
    fun configRepositoryGists(gistsService: GistsService) : GistRepository{
        return GistRepositoryImp(gistsService)
    }

}