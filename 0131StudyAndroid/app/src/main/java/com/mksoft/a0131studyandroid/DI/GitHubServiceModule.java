package com.mksoft.a0131studyandroid.DI;

import com.mksoft.a0131studyandroid.Repository.GitHubService;
import com.mksoft.a0131studyandroid.Repository.WebService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class GitHubServiceModule {

    @Singleton
    @Provides
    GitHubService provideGitHubService(){
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(GitHubService.class);
    }

}
