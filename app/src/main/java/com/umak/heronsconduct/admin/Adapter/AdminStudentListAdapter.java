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
import com.umak.heronsconduct.admin.Model.AdminStudentListModel;

import java.util.ArrayList;

public class AdminStudentListAdapter extends RecyclerView.Adapter<AdminStudentListAdapter.MyViewHolder> {

    public final MyInterface myInterfaces;



    Context context;
    ArrayList<AdminStudentListModel> adminStudentLists;
    String onclick;

    public AdminStudentListAdapter(Context context, ArrayList<AdminStudentListModel> adminStudentLists, MyInterface myInterfaces, String onclick){
        this.context = context;
        this.adminStudentLists = adminStudentLists;
        this.myInterfaces = myInterfaces;
        this.onclick = onclick;
    }

    @NonNull
    @Override
    public AdminStudentListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType  ) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.stud_list_item, parent, false);

        return new AdminStudentListAdapter.MyViewHolder(view, myInterfaces, onclick);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminStudentListAdapter.MyViewHolder holder, int position) {
        //hold na siya ng data
        holder.studList_item_name.setText(adminStudentLists.get(position).getStudList_item_name());
        holder.studList_item_college.setText(adminStudentLists.get(position).getStudList_item_college());
        holder.studList_item_umak_email.setText(adminStudentLists.get(position).getStudList_item_umak_email());
        holder.studList_num_acc.setText(adminStudentLists.get(position).getStudList_num_acc());
        holder.studList_num_vio.setText(adminStudentLists.get(position).getStudList_num_vio());


        Picasso.get().load(adminStudentLists.get(position).getImg_profile()).error(R.drawable.placeholder).into(holder.img_profile);
    }


    @Override
    public int getItemCount() {

        return adminStudentLists.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{


        //Textview
        TextView studList_item_name,studList_item_college,studList_item_umak_email,studList_num_acc,studList_num_vio;

        //imgaeview
        ImageView img_profile;

        public MyViewHolder(@NonNull View itemView, MyInterface myInterfaces, String onclick) {
            super(itemView);


            studList_num_vio = itemView.findViewById(R.id.studList_num_vio);
            studList_num_acc = itemView.findViewById(R.id.studList_num_acc);
            studList_item_umak_email = itemView.findViewById(R.id.studList_item_umak_email);
            studList_item_college = itemView.findViewById(R.id.studList_item_college);
            studList_item_name = itemView.findViewById(R.id.studList_item_name);
            img_profile = itemView.findViewById(R.id.img_profile);



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
