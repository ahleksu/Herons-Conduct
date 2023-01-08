package com.umak.heronsconduct;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class AdminSettingsFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admin_settings, container, false);


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
                Intent intent = new Intent(getActivity(),FAQs.class);
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
                Intent intent = new Intent(getActivity(), Login.class);
                startActivity(intent);
            }
        });


    }
}