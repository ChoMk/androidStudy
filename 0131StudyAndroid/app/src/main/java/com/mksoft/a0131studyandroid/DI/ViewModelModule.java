package com.mksoft.a0131studyandroid.DI;

import com.mksoft.a0131studyandroid.Repository.WebService;
import com.mksoft.a0131studyandroid.viewmodel.FactoryViewModel;
import com.mksoft.a0131studyandroid.viewmodel.GitHubViewModel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(GitHubViewModel.class)
    abstract ViewModel bindGitHubViewModel(GitHubViewModel gitHubViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(FactoryViewModel factory);
}
