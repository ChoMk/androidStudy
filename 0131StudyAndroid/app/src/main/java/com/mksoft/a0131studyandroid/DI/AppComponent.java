package com.mksoft.a0131studyandroid.DI;

import android.app.Application;


import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

/**
 * Created by Philippe on 02/03/2018.
 */

@Singleton
@Component(modules={AppModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }

}
