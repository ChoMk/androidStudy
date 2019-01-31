package com.mksoft.a0131studyandroid.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mksoft.a0131studyandroid.DI.DaggerGitHubServiceComponent;
import com.mksoft.a0131studyandroid.Data.User;
import com.mksoft.a0131studyandroid.MainActivity;
import com.mksoft.a0131studyandroid.R;
import com.mksoft.a0131studyandroid.Repository.GitHubService;
import com.mksoft.a0131studyandroid.Repository.WebService;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragment1 extends Fragment {
    MainActivity mainActivity;
    TextView repoText;
    Button getButton;
    Button postButton;
    Button changeButton1;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

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

    private void initUI(ViewGroup rootView){
        repoText = rootView.findViewById(R.id.repoText);

        getButton = rootView.findViewById(R.id.getButton);

        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.getGitHubServiceComponent().makeWebService().getDatas(repoText);
            }
        });
        postButton = rootView.findViewById(R.id.postButton);
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.getGitHubServiceComponent().makeWebService().postDatas(new User("guy", "https://www.github.com/meansoup"), getContext());
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
