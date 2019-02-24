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

public class Fragment2 extends Fragment {
    MainActivity mainActivity;
    TextView repoText2;
    Button getButton2;
    Button postButton2;
    Button changeButton2;
    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private GitHubViewModel gitHubViewModel;


    public Fragment2(){}
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
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment2, container, false);
        initUI(rootView);

        return rootView;
    }

    private void configureDagger(){
        AndroidSupportInjection.inject(this);
    }
    private void configureViewModel(){
        gitHubViewModel = ViewModelProviders.of(this, viewModelFactory).get(GitHubViewModel.class);

        gitHubViewModel.getUser().observe(this, new Observer<User>() {

            @Override
            public void onChanged(User user) {
                Log.d("testResultF1", user.login);
            }
        });
    }

    private void initUI(ViewGroup rootView){
        repoText2 = rootView.findViewById(R.id.repoText2);

        getButton2 = rootView.findViewById(R.id.getButton2);
        getButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
        postButton2 = rootView.findViewById(R.id.postButton2);
        postButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        changeButton2 = rootView.findViewById(R.id.changeButton2);
        changeButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.onFragmentChange(1);
            }
        });
    }
}
