package com.mksoft.a0131studyandroid.DI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mksoft.a0131studyandroid.Repository.GitHubService;
import com.mksoft.a0131studyandroid.Repository.WebService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ViewModelModule.class)
public class AppModule {

    private static String BASE_URL = "https://api.github.com/";
    @Provides
    Gson provideGson(){
        return new GsonBuilder().create();
    }
    @Provides
    Retrofit provideRetrofit(Gson gson){
        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build();
        return retrofit;
    }
    @Provides
    @Singleton
    GitHubService provideGithubService(Retrofit retrofit){
        return retrofit.create(GitHubService.class);
    }
    @Provides
    @Singleton
    WebService provideWebservice(GitHubService gitHubService){
        return new WebService(gitHubService);
    }

}
