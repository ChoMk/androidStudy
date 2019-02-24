package com.mksoft.a0131studyandroid.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mksoft.a0131studyandroid.Data.User;
import com.mksoft.a0131studyandroid.viewmodel.GitHubViewModel;
import com.mksoft.a0131studyandroid.MainActivity;
import com.mksoft.a0131studyandroid.R;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.AndroidSupportInjection;

public class Fragment1 extends Fragment {
    MainActivity mainActivity;
    TextView repoText;
    Button getButton;
    Button postButton;
    Button changeButton1;
    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private GitHubViewModel gitHubViewModel;


    public Fragment1(){}
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.configureDagger();
        this.configureViewModel();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity)getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);
        initUI(rootView);
        return rootView;
    }

    private void configureDagger(){
        AndroidSupportInjection.inject(this);
    }
    private void configureViewModel(){
        gitHubViewModel = ViewModelProviders.of(this, viewModelFactory).get(GitHubViewModel.class);
        gitHubViewModel.init();
        gitHubViewModel.getUser().observe(this, new Observer<User>() {

            @Override
            public void onChanged(User user) {
                Log.d("testResultF1", user.login);
            }
        });
    }

    private void initUI(ViewGroup rootView){
        repoText = rootView.findViewById(R.id.repoText);

        getButton = rootView.findViewById(R.id.getButton);

        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        postButton = rootView.findViewById(R.id.postButton);
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        changeButton1 = rootView.findViewById(R.id.changeButton1);
        changeButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.onFragmentChange(2);
            }
        });
    }
}
