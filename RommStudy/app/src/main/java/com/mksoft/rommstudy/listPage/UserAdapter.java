package com.mksoft.rommstudy.listPage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mksoft.rommstudy.MainActivity;
import com.mksoft.rommstudy.R;
import com.mksoft.rommstudy.dataType.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView userListItemName;
        TextView userListItemMajor;
        TextView userListItemAge;

        MyViewHolder(View view){
            super(view);
            userListItemName = view.findViewById(R.id.userListItemName);
            userListItemMajor = view.findViewById(R.id.userListItemMajor);
            userListItemAge = view.findViewById(R.id.userListItemAge);
        }
    }
    List<User> items = Collections.emptyList();
    Context context;
    public UserAdapter(Context context){
        this.context = context;


    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final MyViewHolder myViewHolder = (MyViewHolder) holder;

        myViewHolder.userListItemAge.setText(String.valueOf(items.get(position).age));
        myViewHolder.userListItemMajor.setText(items.get(position).userMajor);
        myViewHolder.userListItemName.setText(items.get(position).userName);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public void refreshItem(List<User> items){
        this.items = items;
        notifyDataSetChanged();
    }

}
