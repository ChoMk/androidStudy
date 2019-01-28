package com.mksoft.memobody;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    MemoBodyFragment memoBodyFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        memoBodyFragment = new MemoBodyFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, memoBodyFragment).commit();
    }
}
