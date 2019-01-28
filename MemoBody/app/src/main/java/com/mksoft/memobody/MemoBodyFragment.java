package com.mksoft.memobody;

import android.content.DialogInterface;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MemoBodyFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    MemoAdapter memoAdapter;
    Button sortButton;
    Button addButton;
    MainActivity mainActivity;
    AlertDialog dialog;
    final CharSequence[] howWrite = {"등록일", "마감일"};
    ArrayList<MemoData> tempList;




    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.memo_body, container, false);
        init(rootView);
        clickSortButton();
        return rootView;
    }

    private void init(ViewGroup rootView){

        mainActivity = (MainActivity) getActivity();
        recyclerView = (RecyclerView)rootView.findViewById(R.id.memoListRecyclerView);
        layoutManager = new LinearLayoutManager(rootView.getContext());

        addButton = (Button)rootView.findViewById(R.id.addButton);
        sortButton = (Button)rootView.findViewById(R.id.sortButton);


        /////////////////////////////////////
        tempList = new ArrayList<>();
        MemoData test1 = new MemoData("2019-01-14", "1", "2019-01-28");
        MemoData test2 = new MemoData("2019-01-24", "2", "2019-01-17");
        MemoData test3 = new MemoData("2019-01-28", "3", "2019-01-12");
        tempList.add(test1);//캐싱값을 받아서 또는 내부 저장 데이터를 받아서 보여주기
        tempList.add(test2);
        tempList.add(test3);

        /////////////////////////////////////



        makeDialog(mainActivity);
        initListView(tempList);

    }


    private void initListView(ArrayList<MemoData> tempList){

        recyclerView.setHasFixedSize(true);
        memoAdapter = new MemoAdapter(getContext(), tempList);
        recyclerView.setAdapter(memoAdapter);
        recyclerView.setLayoutManager(layoutManager);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelperCallback(memoAdapter));
        itemTouchHelper.attachToRecyclerView(recyclerView);


    }

    private void clickSortButton(){
        if(sortButton == null)
            return;
        sortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();

            }
        });
    }
    private void makeDialog(MainActivity mainActivity){
        AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity);
        builder.setTitle("정렬 방법을 선택하세요.");
        builder.setItems(howWrite, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which == 0){
                    memoAdapter.registDateSort();

                }else{

                    memoAdapter.endDateSort();

                }//정렬을 외부에서 하고 다시 리사이크러뷰를 초기화해주는 병신같은 짓은 하지 말자.

            }
        });
        dialog = builder.create();    // 알림창 객체 생성

    }











}
