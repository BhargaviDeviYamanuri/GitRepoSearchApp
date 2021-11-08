package com.sample.gitreposearchapp.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.sample.gitreposearchapp.model.ContributorResponse
import com.sample.gitreposearchapp.model.Items
import com.sample.gitreposearchapp.ui.RepoPagingSource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: APIService) : BaseDataSource {
    override suspend fun getSearchResults(
        searchString: String,
        perPage: Int,
        page: Int
    ): LiveData<PagingData<Items>> {
        val search = apiService.getSearchResult(searchString,perPage,page)
       // Log.e("data",search.value.toString())
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = { RepoPagingSource(apiService, searchString) }).liveData

    }
    override suspend fun getContributorDetails(path: String): LiveData<ContributorResponse> {
        val pathString = path.split(".com/repos/")
        return apiService.getContributorDetails(pathString[1])
    }
}