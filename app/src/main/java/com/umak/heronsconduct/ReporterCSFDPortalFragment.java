package com.umak.heronsconduct;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ReporterCSFDPortalFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reporter_c_s_f_d_portal, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CardView viewAnnouncementsCard = view.findViewById(R.id.viewAnnouncementsCard);
        viewAnnouncementsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Announcements_CSFD.class);
                startActivity(intent);
            }
        });

        // student handbook

        CardView studentHandBookCard = view.findViewById(R.id.studentHandBookCard);
        studentHandBookCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Student_Handbook.class);
                startActivity(intent);
            }
        });

    }
}