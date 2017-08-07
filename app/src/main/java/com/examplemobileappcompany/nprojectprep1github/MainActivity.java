package com.examplemobileappcompany.nprojectprep1github;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rV;

    private MyAdapter myAdapter;

    private Retrofit retrofit;

    private RetrofitCallback retrofitCallback;

    private MyEndpoint myEndpoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rV = (RecyclerView) findViewById(R.id.recycle);
        myAdapter = new MyAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rV.setLayoutManager(linearLayoutManager);

        rV.setAdapter(myAdapter);
        rV.setHasFixedSize(false);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitCallback = new RetrofitCallback(this);
        myEndpoint = retrofit.create(MyEndpoint.class);

        Timer timer = new Timer();
        timer.schedule(new Repeater(), 0, 20000);




    }





    void setAdapterUrls(List<String> urls){
        myAdapter.setSvnUrls(urls);
    }


    public class Repeater extends TimerTask {

        @Override
        public void run() {
            String query  = "dog";
            Call<GitHubResponse> call = myEndpoint.getRepos(query,20);
            call.enqueue(retrofitCallback);
        }


    }
}
