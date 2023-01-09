package com.umak.heronsconduct.admin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.umak.heronsconduct.R;

import java.util.ArrayList;

public class GoodMoralRequest_AdminRecyclerAdapter extends RecyclerView.Adapter<GoodMoralRequest_AdminRecyclerAdapter.MyViewHolder> {

    private ArrayList<GoodMoralRequest_AdminUser> usersList;
    public GoodMoralRequest_AdminRecyclerAdapter(ArrayList<GoodMoralRequest_AdminUser> usersList){
        this.usersList = usersList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView Name;
        private TextView College;
        private TextView Email;
        private TextView Date;
        private TextView Time;

        public MyViewHolder(final View view){
            super(view);
            Name = view.findViewById(R.id.goodMoralEntriesName);
            College = view.findViewById(R.id.goodMoralEntriesCollege);
            Email = view.findViewById(R.id.goodMoralEntriesEmail);
            Date = view.findViewById(R.id.goodMoralEntriesDate);
            Time = view.findViewById(R.id.goodMoralEntriesTime);

        }
    }

    @NonNull
    @Override
    public GoodMoralRequest_AdminRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.good_moral_entries, parent, false);


        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull GoodMoralRequest_AdminRecyclerAdapter.MyViewHolder holder, int position) {
        String name = usersList.get(position).getName();
        String college = usersList.get(position).getCollege();
        String email = usersList.get(position).getEmail();
        String date = usersList.get(position).getDate();
        String time = usersList.get(position).getTime();
        holder.Name.setText(name);
        holder.College.setText(college);
        holder.Email.setText(email);
        holder.Date.setText(date);
        holder.Time.setText(time);
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

}