package com.mksoft.rommstudy.listPage;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.mksoft.rommstudy.DB.AppDB;
import com.mksoft.rommstudy.DB.UserDao;
import com.mksoft.rommstudy.MainActivity;
import com.mksoft.rommstudy.R;
import com.mksoft.rommstudy.dataType.User;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListViewPageFragment extends Fragment {
    MainActivity mainActivity;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    Button listPageAddButton;
    Button listPageSearchButton;

    EditText listPageSeachEditText;
    UserAdapter userAdapter;
    Thread thread;
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
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.user_list_layout, container, false);
        initUI(rootView);
        clickAdd();
        hideKeyboard();
        refreshDB();
        return rootView;
    }
    public void refreshDB(){
        userAdapter.refreshItem(mainActivity.getReposityDB().getUsers());

    }
    private  void initUI(ViewGroup rootView){
        listPageAddButton = rootView.findViewById(R.id.listPageAddButton);
        listPageSearchButton = rootView.findViewById(R.id.listPageSearchButton);
        listPageSeachEditText = rootView.findViewById(R.id.listPageSeachEditText);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        userAdapter = new UserAdapter(getContext());
        recyclerView.setAdapter(userAdapter);

    }
    private void clickAdd(){
        listPageAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.onFragmentChange(2, null);
            }
        });
    }
    private void hideKeyboard(){
        mainActivity.getHideKeyboard().hideKeyboard();
    }

}
