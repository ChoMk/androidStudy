package com.mksoft.rommstudy.addPage;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.mksoft.rommstudy.DB.AppDB;
import com.mksoft.rommstudy.MainActivity;
import com.mksoft.rommstudy.R;
import com.mksoft.rommstudy.dataType.User;
import com.mksoft.rommstudy.listPage.UserAdapter;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AddPageFragment extends Fragment {
    MainActivity mainActivity;
    Button addPageBackButton;
    Button addPageSubButton;
    EditText addPageUserNameEditText;
    EditText addPageUserMajorEditText;
    EditText addPageUserAgeEditText;
    RelativeLayout addPageRelativeLayout;


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
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.add_user_layout, container, false);
        initUI(rootView);
        hideKeyboard();
        clickBack();
        clickSub();

        return rootView;
    }
    private void initUI(ViewGroup root){
        addPageBackButton = root.findViewById(R.id.addPageBackButton);
        addPageSubButton = root.findViewById(R.id.addPageSubButton);
        addPageUserNameEditText = root.findViewById(R.id.addPageUserNameEditText);
        addPageUserMajorEditText = root.findViewById(R.id.addPageUserMajorEditText);
        addPageUserAgeEditText = root.findViewById(R.id.addPageUserAgeEditText);
        addPageRelativeLayout = root.findViewById(R.id.addPageRelativeLayout);

    }
    private void hideKeyboard(){
        mainActivity.getHideKeyboard().hideKeyboard();
    }

    private void clickBack(){
        addPageBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.onFragmentChange(1, null);
            }
        });
    }
    private void clickSub(){
        addPageSubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addInDB();
                mainActivity.onFragmentChange(1, null);
            }
        });
    }
    private void addInDB(){
        if(addPageUserAgeEditText.getText().length() != 0 && addPageUserMajorEditText.getText().length() !=0
                && addPageUserAgeEditText.getText().length() !=0){
            User user = new User();
            user.age = Integer.parseInt(addPageUserAgeEditText.getText().toString());
            user.userMajor = addPageUserMajorEditText.getText().toString();
            user.userName = addPageUserNameEditText.getText().toString();

            mainActivity.getReposityDB().insertUser(user);
        }

    }
}


