package com.umak.heronsconduct.student_parent;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.umak.heronsconduct.general.PrivacyPolicy;
import com.umak.heronsconduct.R;
import com.umak.heronsconduct.general.TermsOfService;
import com.umak.heronsconduct.general.AboutHeronsConduct;
import com.umak.heronsconduct.general.FAQs;
import com.umak.heronsconduct.login.Login;

public class ParentSettingsFragment extends Fragment {

    FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_parent_settings, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

// About herons conduct
        LinearLayout about_settings_tab = view.findViewById(R.id.about_settings_tab);
        about_settings_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AboutHeronsConduct.class);
                startActivity(intent);
            }
        });

        LinearLayout FAQs_settings_tab = view.findViewById(R.id.FAQs_settings_tab);
        FAQs_settings_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FAQs.class);
                startActivity(intent);
            }
        });

        LinearLayout privacy_settings_tab = view.findViewById(R.id.privacy_settings_tab);
        privacy_settings_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PrivacyPolicy.class);
                startActivity(intent);
            }
        });

        LinearLayout terms_settigns_tab = view.findViewById(R.id.terms_settigns_tab);
        terms_settigns_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TermsOfService.class);
                startActivity(intent);
            }
        });

        LinearLayout logout_tab = view.findViewById(R.id.logout_tab);
        logout_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                Intent intent = new Intent(getActivity(), Login.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        TextView txt_type = view.findViewById(R.id.txt_type_parent);
        TextView txt_name = view.findViewById(R.id.txt_name_parent);
        ImageView img_profile = view.findViewById(R.id.img_profile);

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

        firestore.collection("parent").document(firebaseAuth.getUid())
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





}