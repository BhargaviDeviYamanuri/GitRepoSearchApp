package com.sample.gitreposearchapp.network

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.sample.gitreposearchapp.model.Contributor
import com.sample.gitreposearchapp.model.ContributorResponse
import com.sample.gitreposearchapp.model.Items
import com.sample.gitreposearchapp.model.SearchResultResponse

interface BaseDataSource {
    suspend fun getSearchResults(searchString: String,perPage:Int,page:Int):LiveData<PagingData<Items>>
    suspend fun getContributorDetails(path:String):LiveData<ContributorResponse>
}