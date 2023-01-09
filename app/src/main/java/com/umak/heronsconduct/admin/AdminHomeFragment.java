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


public class AdminHomeFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admin_home, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        CardView studentListCard = view.findViewById(R.id.studentListCard);
        studentListCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AdminStudentList.class);
                startActivity(intent);
            }
        });

        CardView incidentReferralsCard = view.findViewById(R.id.incidentReferralsCard);
        incidentReferralsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AdminIncidentReferrals.class);
                startActivity(intent);
            }
        });


        CardView goodMoralRequestsCard = view.findViewById(R.id.goodMoralRequestsCard);
        goodMoralRequestsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GoodMoralRequest_AdminList.class);
                startActivity(intent);
            }
        });



    }
}