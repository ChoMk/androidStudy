package com.mksoft.a0131studyandroid.Repository;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.mksoft.a0131studyandroid.Data.User;

import javax.inject.Inject;
import javax.inject.Scope;
import javax.inject.Singleton;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class WebService {
    private GitHubService gitHubService;

    public WebService(){
        Log.d("test", "make it!!!");
        this.gitHubService = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(GitHubService.class);
    }
    /*public void postDatas(User user, final Context context)
    {
        Call<User> call = gitHubService.postRepos("meansoup", user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(context.getApplicationContext(), "change url appropriately", Toast.LENGTH_SHORT).show();
                if (response.isSuccessful()) {
                    String str = "response code: " + response.code() + "\n ID: " + response.body().login + "\n URL: " +  response.body().html_url;
                    Toast.makeText(context.getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t){
                Log.e("Not Response", t.getLocalizedMessage());
            }
        });
    }*/

    public LiveData<User> getDatas()
    {

        Call<User> call = gitHubService.getRepos("meansoup");
        final MutableLiveData<User> data = new MutableLiveData<>();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful() && response.body() != null) {
                    data.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t){
                Log.e("Not Response", t.getLocalizedMessage());
            }


        });
        return data;
    }

}
