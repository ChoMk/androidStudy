package com.mksoft.a0131studyandroid.DI;


import com.mksoft.a0131studyandroid.viewmodel.FactoryViewModel;
import com.mksoft.a0131studyandroid.viewmodel.GitHubViewModel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by Philippe on 02/03/2018.
 */

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(GitHubViewModel.class)
    abstract ViewModel bindUserProfileViewModel(GitHubViewModel repoViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(FactoryViewModel factory);
}
