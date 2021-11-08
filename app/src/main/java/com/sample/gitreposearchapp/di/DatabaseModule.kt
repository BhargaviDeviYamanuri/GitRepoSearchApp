package com.sample.gitreposearchapp.di

import android.content.Context
import androidx.room.Room
import com.sample.gitreposearchapp.db.ContributorDAO
import com.sample.gitreposearchapp.db.LocalDataSource
import com.sample.gitreposearchapp.db.RepoDAO
import com.sample.gitreposearchapp.db.RepoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context):RepoDatabase{
        return Room.databaseBuilder(context,RepoDatabase::class.java,"repo.db").build()
    }

    @Provides
    fun provideRepoDao(repoDatabase: RepoDatabase):RepoDAO{
        return repoDatabase.repoDao()
    }

    @Provides
    fun provideContributeDao(repoDatabase: RepoDatabase):ContributorDAO{
        return repoDatabase.contributorDao()
    }

    @Provides
    fun provideLocalDataSource(repoDAO: RepoDAO,contributorDAO: ContributorDAO):LocalDataSource{
        return LocalDataSource(repoDAO,contributorDAO)
    }
}