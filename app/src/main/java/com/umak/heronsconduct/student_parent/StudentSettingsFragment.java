package com.umak.heronsconduct.student_parent;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;
import com.umak.heronsconduct.R;
import com.umak.heronsconduct.general.TermsOfService;
import com.umak.heronsconduct.general.AboutHeronsConduct;
import com.umak.heronsconduct.general.FAQs;
import com.umak.heronsconduct.general.PrivacyPolicy;
import com.umak.heronsconduct.login.Login;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StudentSettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudentSettingsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    //call in xml file
    TextView txt_name,txt_type;
    LinearLayout logout_tab, about_settings_tab, FAQs_settings_tab, privacy_settings_tab, terms_settigns_tab;
    ImageView img_profile;

    //View
    View view;

    //inittia firebase
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_student_settings, container, false);

        //connection of xml and java
        initXml();

        //method when click logout
        logoutMethod();

        //method for retrive name and Tyupe
        methodRetrieveNameAndType();

        //method for FAQs
        FAQs_settingsMethod();

        //method for Privacy policy
        privacy_settingsMethod();

        //method for Terms of Service
        terms_settignsMethod();

        //method for About Herons
        aboutHeronsMethod();


        return view;
    }




    public StudentSettingsFragment() {
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


    private void methodRetrieveNameAndType() {

        //getting type
        firestore.collection("ACCOUNT_TABLE").document(firebaseAuth.getUid())
                .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if(task.isSuccessful()){
                            DocumentSnapshot documentSnapshot = task.getResult();
                            txt_type.setText(documentSnapshot.get("type").toString());
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        e.printStackTrace();
                    }
                });

        //getting name

        firestore.collection("Student").document(firebaseAuth.getUid())
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                        if(task.isSuccessful()){
                            DocumentSnapshot documentSnapshot = task.getResult();

                            if(documentSnapshot.get("image_url") != null){
                                Picasso.get().load(documentSnapshot.get("image_url").toString()).error(R.drawable.placeholder).into(img_profile);
                            }

                            txt_name.setText(documentSnapshot.get("first_name").toString());
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        e.printStackTrace();
                    }
                });

    }


    private void aboutHeronsMethod(){
        about_settings_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AboutHeronsConduct.class);
                startActivity(intent);
            }
        });
    }



    private void FAQs_settingsMethod() {
        FAQs_settings_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), FAQs.class);
                startActivity(intent);
            }
        });
    }

    private void privacy_settingsMethod() {
        privacy_settings_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PrivacyPolicy.class);
                startActivity(intent);
            }
        });
    }


    private void terms_settignsMethod() {
        terms_settigns_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), TermsOfService.class);
                startActivity(intent);
            }
        });
    }


    private void logoutMethod() {
        logout_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();

                Intent intent = new Intent(getContext(), Login.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }


    private void initXml() {
        txt_name = view.findViewById(R.id.txt_name);
        txt_type = view.findViewById(R.id.txt_type);
        logout_tab = view.findViewById(R.id.logout_tab);
        about_settings_tab = view.findViewById(R.id.about_settings_tab);
        FAQs_settings_tab = view.findViewById(R.id.FAQs_settings_tab);
        privacy_settings_tab = view.findViewById(R.id.privacy_settings_tab);
        terms_settigns_tab = view.findViewById(R.id.terms_settigns_tab);
        img_profile = view.findViewById(R.id.img_profile);
    }
}