package com.mksoft.a0131studyandroid;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;

import com.mksoft.a0131studyandroid.DI.DaggerGitHubServiceComponent;
import com.mksoft.a0131studyandroid.DI.GitHubServiceComponent;
import com.mksoft.a0131studyandroid.Fragment.Fragment1;
import com.mksoft.a0131studyandroid.Fragment.Fragment2;
import com.mksoft.a0131studyandroid.Repository.GitHubService;

import javax.inject.Singleton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Fragment1 fragment1;
    Fragment2 fragment2;
    FrameLayout mainContainer;
    GitHubServiceComponent gitHubServiceComponent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        mainContainer = findViewById(R.id.mainContainer);
        getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment1).commit();//처음 기본 플레그먼트 설정
        gitHubServiceComponent = DaggerGitHubServiceComponent.create();
    }

    public GitHubServiceComponent getGitHubServiceComponent(){
        return gitHubServiceComponent;
    }
    public void onFragmentChange(int idx){
        if(idx == 1){

            getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment1).commit();
            //메인버튼 프레그먼트
        }else if(idx == 2){

            getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).commit();
            //add 페이지
        }
    }
}
