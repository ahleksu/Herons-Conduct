package com.umak.heronsconduct.admin;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.umak.heronsconduct.R;
import com.umak.heronsconduct.admin.AdminFindStudents;


public class AdminSearchFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admin_search, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        CardView findStudentCard = view.findViewById(R.id.findStudentCard);
        findStudentCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AdminFindStudents.class);
                startActivity(intent);
            }
        });

        CardView searchReferralsCard = view.findViewById(R.id.searchReferralsCard);
        searchReferralsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AdminSearchReferrals.class);
                startActivity(intent);
            }
        });


    }
}