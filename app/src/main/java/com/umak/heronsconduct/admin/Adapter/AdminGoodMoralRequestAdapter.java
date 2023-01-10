package com.umak.heronsconduct.admin.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.umak.heronsconduct.R;
import com.umak.heronsconduct.admin.Model.GoodMoralRequestModel;

import java.util.ArrayList;

public class AdminGoodMoralRequestAdapter extends RecyclerView.Adapter<AdminGoodMoralRequestAdapter.MyViewHolder> {

    public final MyInterface myInterfaces;


    Context context;
    ArrayList<GoodMoralRequestModel> goodMoralRequestModels;
    String onclick;

    public AdminGoodMoralRequestAdapter(Context context, ArrayList<GoodMoralRequestModel> goodMoralRequestModels, MyInterface myInterfaces, String onclick){
        this.context = context;
        this.goodMoralRequestModels = goodMoralRequestModels;
        this.myInterfaces = myInterfaces;
        this.onclick = onclick;
    }

    @NonNull
    @Override
    public AdminGoodMoralRequestAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType  ) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.good_moral_entries, parent, false);

        return new AdminGoodMoralRequestAdapter.MyViewHolder(view, myInterfaces, onclick);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminGoodMoralRequestAdapter.MyViewHolder holder, int position) {
        //hold na siya ng data
        holder.name_of_requestor.setText(goodMoralRequestModels.get(position).getName_of_requestor());
        holder.requestor_college.setText(goodMoralRequestModels.get(position).getRequestor_college());
        holder.email_of_requestor.setText(goodMoralRequestModels.get(position).getEmail_of_requestor());
        holder.date_of_request.setText(goodMoralRequestModels.get(position).getDate_of_request());


       // Picasso.get().load(goodMoralRequestModels.get(position).getImg_profile()).error(R.drawable.placeholder).into(holder.img_profile);
    }


    @Override
    public int getItemCount() {
        return goodMoralRequestModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        //Textview
        TextView name_of_requestor,requestor_college,email_of_requestor,date_of_request;

        //imgaeview

        public MyViewHolder(@NonNull View itemView, MyInterface myInterfaces, String onclick) {
            super(itemView);

            name_of_requestor = itemView.findViewById(R.id.goodMoralEntriesName);
            requestor_college = itemView.findViewById(R.id.goodMoralEntriesCollege);
            email_of_requestor = itemView.findViewById(R.id.goodMoralEntriesEmail);
            date_of_request = itemView.findViewById(R.id.goodMoralEntriesDate);

            itemView.setOnClickListener(view -> {
                if(myInterfaces != null ){
                    int pos = getAdapterPosition();
                    if(pos!= RecyclerView.NO_POSITION){
                        myInterfaces.onItemClick(pos, onclick);
                    }

                }
            });
        }
    }


}
