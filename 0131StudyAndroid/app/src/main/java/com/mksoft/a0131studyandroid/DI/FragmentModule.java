package com.mksoft.a0131studyandroid.DI;


import com.mksoft.a0131studyandroid.Fragment.Fragment1;
import com.mksoft.a0131studyandroid.Fragment.Fragment2;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Philippe on 02/03/2018.
 */

@Module
public abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract Fragment1 contributeUserProfileFragment();

    @ContributesAndroidInjector
    abstract Fragment2 contributeUserProfileFragment2();
}
