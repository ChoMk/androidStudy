package com.boisneyphilippe.githubarchitecturecomponents.activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.boisneyphilippe.githubarchitecturecomponents.R;
import com.boisneyphilippe.githubarchitecturecomponents.fragments.UserProfileFragment;
import com.boisneyphilippe.githubarchitecturecomponents.fragments.UserProfileFragment2;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    UserProfileFragment fragment;
    UserProfileFragment2 fragment2;
    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;


    private static String USER_LOGIN = "JakeWharton";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.configureDagger();
        this.showFragment(savedInstanceState);
    }

    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

    // ---

    private void showFragment(Bundle savedInstanceState){
        if (savedInstanceState == null) {

            fragment = new UserProfileFragment();
            fragment2 = new UserProfileFragment2();
            Bundle bundle = new Bundle();
            bundle.putString(UserProfileFragment.UID_KEY, USER_LOGIN);
            fragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment, null)
                    .commit();
        }
    }

    private void configureDagger(){
        AndroidInjection.inject(this);
    }
    public void onFragmentChange(int idx){
        if(idx == 1){
            Bundle bundle = new Bundle();
            bundle.putString(UserProfileFragment.UID_KEY, USER_LOGIN);
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            //메인버튼 프레그먼트
        }else if(idx == 2){
            Bundle bundle = new Bundle();
            bundle.putString(UserProfileFragment2.UID_KEY, USER_LOGIN);
            fragment2.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment2).commit();
            //add 페이지
        }
    }
}
