package com.sample.gitreposearchapp.network

import androidx.lifecycle.LiveData
import com.sample.gitreposearchapp.model.ContributorResponse
import com.sample.gitreposearchapp.model.SearchResultResponse
import com.sample.gitreposearchapp.util.AppConstants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {
    @GET(AppConstants.REPO_SEARCH_ENDPOINT)
    suspend fun getSearchResult(
        @Query(AppConstants.QUERY_PARAM) searchStr: String,
        @Query(AppConstants.PER_PAGE) perPage: Int,
        @Query(AppConstants.PAGE) page: Int
    ): SearchResultResponse

    @GET("repos/{service}")
    suspend fun getContributorDetails(@Path("service") path:String) : LiveData<ContributorResponse>
}