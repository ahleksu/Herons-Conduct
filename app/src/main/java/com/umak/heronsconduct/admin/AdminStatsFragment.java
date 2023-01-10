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

public class AdminStatsFragment extends Fragment {

    CardView incidentReports, collegeReports, studentReports;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admin_stats, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        incidentReports = view.findViewById(R.id.incidentReportsCard);
        incidentReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AdminStatisticsIncidentReports.class);
                startActivity(intent);
            }
        });

        collegeReports = view.findViewById(R.id.collegesReportCard);
        collegeReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AdminStatisticsCollegeReports.class);
                startActivity(intent);
            }
        });

        studentReports = view.findViewById(R.id.studentReportsCard);
        studentReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AdminStatisticsStudentReports.class);
                startActivity(intent);
            }
        });


    }


}