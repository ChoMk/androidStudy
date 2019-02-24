package com.mksoft.a0131studyandroid;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.mksoft.a0131studyandroid.Fragment.Fragment1;
import com.mksoft.a0131studyandroid.Fragment.Fragment2;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector {
    Fragment1 fragment1;
    Fragment2 fragment2;
    FrameLayout mainContainer;
    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.configureDagger();
        init();
    }

    private void init(){
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        mainContainer = findViewById(R.id.mainContainer);
        getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment1).commit();//처음 기본 플레그먼트 설정

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

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
    private void configureDagger(){
        AndroidInjection.inject(this);
    }

}
