package com.sample.gitreposearchapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sample.gitreposearchapp.model.Items
import com.sample.gitreposearchapp.model.LocalContributor
import com.sample.gitreposearchapp.util.ContributorConverter
import com.sample.gitreposearchapp.util.OwnerConverter

@Database(entities = [LocalContributor::class,Items::class],version = 1,exportSchema = false)
@TypeConverters(OwnerConverter::class,ContributorConverter::class)
abstract class RepoDatabase:RoomDatabase() {
    abstract fun repoDao():RepoDAO
    abstract fun contributorDao():ContributorDAO
}