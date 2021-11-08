package com.sample.gitreposearchapp.di

import android.content.Context
import com.sample.gitreposearchapp.db.LocalDataSource
import com.sample.gitreposearchapp.network.APIService
import com.sample.gitreposearchapp.network.RemoteDataSource
import com.sample.gitreposearchapp.network.SearchRepoRepository
import com.sample.gitreposearchapp.util.AppConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {
    @Provides
    fun provideRetrofit():Retrofit =  Retrofit.Builder()
        .baseUrl(AppConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideRepoApi(retrofit: Retrofit):APIService{
        return retrofit.create(APIService::class.java)
    }

    @Provides
    fun provideRemoteDataSource(apiService: APIService):RemoteDataSource{
        return RemoteDataSource(apiService)
    }

    @Provides
    fun provideRepoRepository(remoteDataSource: RemoteDataSource,localDataSource: LocalDataSource,@ApplicationContext context: Context):SearchRepoRepository{
        return SearchRepoRepository(remoteDataSource,localDataSource,context)
    }
}