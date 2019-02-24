package com.mksoft.a0131studyandroid.viewmodel;

import com.mksoft.a0131studyandroid.Data.User;
import com.mksoft.a0131studyandroid.Repository.WebService;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


public class GitHubViewModel extends ViewModel {
    private LiveData<User> user;
    private WebService webService;

    @Inject
    public GitHubViewModel(WebService webService){
        this.webService = webService;
        init();
    }

    public void init(){
        if(this.user != null){
            return;
        }
        user = webService.getDatas("test");

    }
    public LiveData<User> getUser(){
        return this.user;
    }
}
