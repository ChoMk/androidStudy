package com.mksoft.a0131studyandroid;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.mksoft.a0131studyandroid.DI.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class App extends Application implements HasActivityInjector {

    public static Context context;
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;
//엡 아래 컴포넌트 친구...액티비티
    @Override
    public void onCreate() {
        super.onCreate();
        this.initDagger();
        context = getApplicationContext();
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }


    private void initDagger(){
        DaggerAppComponent.builder().application(this).build().inject(this);
    }
}
