package com.mksoft.a0131studyandroid.DI;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = GitHubServiceModule.class
)
public interface FragmentComponent {


}
