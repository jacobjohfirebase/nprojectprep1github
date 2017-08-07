package com.examplemobileappcompany.nprojectprep1github;

import android.content.Context;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 8/4/2017.
 */

public class RetrofitCallback implements Callback<GitHubResponse> {

    //private MyAdapter myAdapter;

    Context context;

    public RetrofitCallback(Context context){
        this.context = context;
    }


    @Override
    public void onResponse(Call<GitHubResponse> call, Response<GitHubResponse> response) {
        GitHubResponse gitHubResponse = response.body();
        List<String> svnUrls = gitHubResponse.getItemSvnUrls();
        ((MainActivity) context).setAdapterUrls(svnUrls);
    }

    @Override
    public void onFailure(Call<GitHubResponse> call, Throwable t) {
        Log.e("mylog", t.toString());
    }
}
