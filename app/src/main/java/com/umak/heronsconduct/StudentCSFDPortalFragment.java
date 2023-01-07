package com.umak.heronsconduct;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.net.CacheRequest;


public class StudentCSFDPortalFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    // CALL IN XML FILE
    CardView studentReqGMC, viewAnnouncementsCard, studentHandBookCard;



    View view;



    public StudentCSFDPortalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StudentSettingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StudentSettingsFragment newInstance(String param1, String param2) {
        StudentSettingsFragment fragment = new StudentSettingsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_student_c_s_f_d_portal, container, false);

        //connection of xml and java method
        csfdXML();


        //method on request good moral
        studentReqGMC_Method();

        //method View Announcements
        viewAnnouncementsCard_Method();

        //method Student Hand Book
        studentHandBookCard_Method();


        return view;
    }

    private void studentReqGMC_Method(){
        studentReqGMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GoodMoralRequest_Student.class);
                startActivity(intent);
            }
        });
    }

    private void viewAnnouncementsCard_Method() {
        viewAnnouncementsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Announcements_CSFD.class);
                startActivity(intent);
            }
        });
    }

    private void studentHandBookCard_Method() {
        studentHandBookCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Student_Handbook.class);
                startActivity(intent);
            }
        });
    }






    private void csfdXML() {
        studentReqGMC = view.findViewById(R.id.studentReqGMC);
        viewAnnouncementsCard = view.findViewById(R.id.viewAnnouncementsCard);
        studentHandBookCard = view.findViewById(R.id.studentHandBookCard);
    }





}