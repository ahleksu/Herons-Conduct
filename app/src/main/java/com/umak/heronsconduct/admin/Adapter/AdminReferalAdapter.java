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
import com.umak.heronsconduct.admin.Model.AdminReferalModel;


import java.util.ArrayList;

public class AdminReferalAdapter extends RecyclerView.Adapter<AdminReferalAdapter.MyViewHolder> {

    public final MyInterface myInterfaces;


    Context context;
    ArrayList<AdminReferalModel> adminReferalModels;
    String onclick;

    public AdminReferalAdapter(Context context, ArrayList<AdminReferalModel> adminReferalModels, MyInterface myInterfaces, String onclick){
        this.context = context;
        this.adminReferalModels = adminReferalModels;
        this.myInterfaces = myInterfaces;
        this.onclick = onclick;
    }

    @NonNull
    @Override
    public AdminReferalAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType  ) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.inc_ref_list_item, parent, false);

        return new AdminReferalAdapter.MyViewHolder(view, myInterfaces, onclick);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminReferalAdapter.MyViewHolder holder, int position) {
        //hold na siya ng data
        holder.titleOfRef.setText(adminReferalModels.get(position).getTitle());
        holder.ref_id.setText(adminReferalModels.get(position).getCodeNumber());
        holder.offender_college.setText(adminReferalModels.get(position).getCollege());
        holder.reporter_name.setText(adminReferalModels.get(position).getReporter());
        holder.offender_name.setText(adminReferalModels.get(position).getOffender());
        holder.refLocationref.setText(adminReferalModels.get(position).getLocation());
        holder.refTime.setText(adminReferalModels.get(position).getTime());

        Picasso.get().load(adminReferalModels.get(position).getImage()).error(R.drawable.placeholder).into(holder.image);

    }


    @Override
    public int getItemCount() {

        return adminReferalModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{


        //Textview
        TextView titleOfRef,ref_id,offender_college,reporter_name,offender_name,refLocationref,refTime;

        //imgaeview
        ImageView image;

        public MyViewHolder(@NonNull View itemView, MyInterface myInterfaces, String onclick) {
            super(itemView);

            titleOfRef = itemView.findViewById(R.id.titleOfRef);
            ref_id = itemView.findViewById(R.id.ref_id);
            offender_college = itemView.findViewById(R.id.offender_college);
            reporter_name = itemView.findViewById(R.id.reporter_name);
            offender_name = itemView.findViewById(R.id.offender_name);
            refLocationref = itemView.findViewById(R.id.refLocation);
            refTime = itemView.findViewById(R.id.refTime);
            image = itemView.findViewById(R.id.sample);



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
