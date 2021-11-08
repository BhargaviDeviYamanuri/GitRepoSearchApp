package com.sample.gitreposearchapp.network

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.sample.gitreposearchapp.db.LocalDataSource
import com.sample.gitreposearchapp.model.ContributorResponse
import com.sample.gitreposearchapp.model.Items
import com.sample.gitreposearchapp.util.isNetworkConnected
import javax.inject.Inject

class SearchRepoRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    val localDataSource: LocalDataSource,
    val context: Context
) : BaseDataSource {
    override suspend fun getSearchResults(
        searchString: String,
        perPage: Int,
        page: Int
    ): LiveData<PagingData<Items>> {
        if (isNetworkConnected(context = context)) {
            return remoteDataSource.getSearchResults(searchString, perPage, page)
        } else {
            //TODO need to change
            return remoteDataSource.getSearchResults(searchString, perPage, page)
        }
    }

    override suspend fun getContributorDetails(path: String): LiveData<ContributorResponse> {
        if (isNetworkConnected(context = context)) {
            return remoteDataSource.getContributorDetails(path)
        } else {
            //TODO need to change
            return remoteDataSource.getContributorDetails(path)
        }
    }
}