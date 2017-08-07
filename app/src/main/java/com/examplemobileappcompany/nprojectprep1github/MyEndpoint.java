package com.examplemobileappcompany.nprojectprep1github;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by admin on 8/4/2017.
 */

public interface MyEndpoint {

    @GET("search/repositories")
    public Call<GitHubResponse> getRepos(@Query("q") String query, @Query("per_page") Integer limit);
}
