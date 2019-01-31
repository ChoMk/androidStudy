package com.mksoft.a0131studyandroid.DI;

import com.mksoft.a0131studyandroid.Repository.GitHubService;
import com.mksoft.a0131studyandroid.Repository.WebService;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = GitHubServiceModule.class)
public interface GitHubServiceComponent {
    WebService makeWebService();
}
