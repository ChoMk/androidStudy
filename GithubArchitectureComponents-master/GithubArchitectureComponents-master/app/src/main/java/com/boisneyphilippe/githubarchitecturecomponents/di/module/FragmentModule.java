package com.boisneyphilippe.githubarchitecturecomponents.di.module;

import com.boisneyphilippe.githubarchitecturecomponents.fragments.UserProfileFragment;
import com.boisneyphilippe.githubarchitecturecomponents.fragments.UserProfileFragment2;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Philippe on 02/03/2018.
 */

@Module
public abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract UserProfileFragment contributeUserProfileFragment();

    @ContributesAndroidInjector
    abstract UserProfileFragment2 contributeUserProfileFragment2();
}
