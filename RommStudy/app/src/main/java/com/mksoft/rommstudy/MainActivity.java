package com.mksoft.rommstudy;

import android.os.AsyncTask;
import android.os.Bundle;

import com.mksoft.rommstudy.DB.AppDB;
import com.mksoft.rommstudy.DB.ReposityDB;
import com.mksoft.rommstudy.addPage.AddPageFragment;
import com.mksoft.rommstudy.listPage.ListViewPageFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class MainActivity extends AppCompatActivity {

    AddPageFragment addPageFragment;
    ListViewPageFragment listViewPageFragment;
    HideKeyboard hideKeyboard;
    ReposityDB reposityDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }
    private void init(){
        addPageFragment = new AddPageFragment();
        listViewPageFragment = new ListViewPageFragment();
        hideKeyboard = new HideKeyboard(this);
        reposityDB = new ReposityDB(getApplication());
        getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, listViewPageFragment).commit();
    }
    public void onFragmentChange(int idx, Bundle bundle){
        if(idx == 1){
            getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, listViewPageFragment).commit();
            //list 페이지
        }else if(idx == 2){
            getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, addPageFragment).commit();
            //add 페이지
        }
    }
    public HideKeyboard getHideKeyboard(){
        return hideKeyboard;
    }

    public ReposityDB getReposityDB() {
        return reposityDB;
    }

}
