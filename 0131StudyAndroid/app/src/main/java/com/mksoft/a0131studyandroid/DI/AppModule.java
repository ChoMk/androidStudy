package com.mksoft.a0131studyandroid.DI;

import android.app.Application;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mksoft.a0131studyandroid.Repository.WebService;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Philippe on 02/03/2018.
 */

@Module(includes = ViewModelModule.class)
public class AppModule {


    @Provides
    @Singleton
    WebService provideUserRepository() {
        return new WebService();
    }



}
