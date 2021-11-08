package com.sample.gitreposearchapp.db

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.sample.gitreposearchapp.model.ContributorResponse
import com.sample.gitreposearchapp.model.Items
import com.sample.gitreposearchapp.model.SearchResultResponse
import com.sample.gitreposearchapp.network.BaseDataSource

class LocalDataSource(val repoDAO: RepoDAO,val contributorDAO: ContributorDAO):BaseDataSource {
    override suspend fun getSearchResults(
        searchString: String,
        perPage: Int,
        page: Int
    ): LiveData<PagingData<Items>> {
        TODO("Not yet implemented")
    }

    override suspend fun getContributorDetails(path: String): LiveData<ContributorResponse> {
        TODO("Not yet implemented")
    }
}