package com.mksoft.memobody;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class MemoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{



    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView registDateTextView;
        TextView endDateTextView;
        TextView memoTextView;


        MyViewHolder(View view){
            super(view);
            registDateTextView = view.findViewById(R.id.registDateTextView);
            endDateTextView = view.findViewById(R.id.endDateTextView);
            memoTextView = view.findViewById(R.id.memoTextView);
        }
    }
    ArrayList<MemoData> items;
    Context context;
    MyViewHolder myViewHolder;
    MemoSortFunction memoSortFunction;

    public MemoAdapter(Context context, ArrayList<MemoData> items){
        this.context = context;
        this.items = items;
        this.memoSortFunction = new MemoSortFunction();

    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.memo_item, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        myViewHolder = (MyViewHolder) holder;
        myViewHolder.registDateTextView.setText(items.get(position).getRegistDateTextView());
        myViewHolder.endDateTextView.setText(items.get(position).getEndDateTextView());
        myViewHolder.memoTextView.setText(items.get(position).getMemoText());

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void deleteItem(int position) {
        items.remove(position);
        notifyItemRemoved(position);
    }//밀어서 삭제 (스와이브 삭제 용)

    public void endDateSort(){
        memoSortFunction.endDateSort(items);
        notifyItemRangeChanged(0,getItemCount());
    }
    public void registDateSort(){
        memoSortFunction.registDateSort(items);
        notifyItemRangeChanged(0,getItemCount());
    }
}//리스트뷰에 필요한 어뎁터를 만들어주는 공간이다.
