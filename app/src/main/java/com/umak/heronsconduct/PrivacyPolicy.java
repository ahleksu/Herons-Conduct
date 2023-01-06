package com.umak.heronsconduct;

import androidx.appcompat.app.AppCompatActivity;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PrivacyPolicy extends AppCompatActivity {

    TextView policy1_text,policy2_text,policy3_text, policy4_text, policy5_text;
    LinearLayout policy1, policy2, policy3, policy4, policy5, policy6;
    ImageView policyBackBtn, dropdownIcon1, dropdownIcon2, dropdownIcon3, dropdownIcon4, dropdownIcon5;
    boolean isClicked1, isClicked2, isClicked3, isClicked4, isClicked5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);

        //Button
        policyBackBtn = findViewById(R.id.policyBackBtn);

        //Dropdowns
        dropdownIcon1 = findViewById(R.id.dropdownIcon1);
        dropdownIcon2 = findViewById(R.id.dropdownIcon2);
        dropdownIcon3 = findViewById(R.id.dropdownIcon3);
        dropdownIcon4 = findViewById(R.id.dropdownIcon4);
        dropdownIcon5 = findViewById(R.id.dropdownIcon5);

        //FAQs details
        policy1_text = findViewById(R.id.policy1_details);
        policy2_text = findViewById(R.id.policy2_details);
        policy3_text = findViewById(R.id.policy3_details);
        policy4_text = findViewById(R.id.policy4_details);
        policy5_text = findViewById(R.id.policy5_details);


        //Layouts
        policy1 = findViewById(R.id.policy1);
        policy1.getLayoutTransition().enableTransitionType(LayoutTransition.APPEARING);
        policy2 = findViewById(R.id.policy1);
        policy2.getLayoutTransition().enableTransitionType(LayoutTransition.APPEARING);
        policy3 = findViewById(R.id.policy3);
        policy3.getLayoutTransition().enableTransitionType(LayoutTransition.APPEARING);
        policy4 = findViewById(R.id.policy4);
        policy4.getLayoutTransition().enableTransitionType(LayoutTransition.APPEARING);
        policy5 = findViewById(R.id.policy5);
        policy5.getLayoutTransition().enableTransitionType(LayoutTransition.APPEARING);

        policyBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        dropdownIcon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v = (policy1_text.getVisibility() == View.GONE) ? View.VISIBLE: View.GONE;
                TransitionManager.beginDelayedTransition(policy1, new AutoTransition());
                policy1_text.setVisibility(v);

                RotateAnimation rotateAnimation = new RotateAnimation(0, 180, RotateAnimation.RELATIVE_TO_SELF,
                        0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);

                if(isClicked1){
                    RotateAnimation rotateAnimation1 = new RotateAnimation(180, 0, RotateAnimation.RELATIVE_TO_SELF,
                            0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotateAnimation.setDuration(500);
                    dropdownIcon1.startAnimation(rotateAnimation1);
                    isClicked1=false;
                    rotateAnimation.setFillAfter(true);
                }else{
                    rotateAnimation.setDuration(500);
                    dropdownIcon1.startAnimation(rotateAnimation);
                    isClicked1=true;
                    rotateAnimation.setFillAfter(true);
                }
            }
        });

        dropdownIcon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v = (policy2_text.getVisibility() == View.GONE) ? View.VISIBLE: View.GONE;
                TransitionManager.beginDelayedTransition(policy2, new AutoTransition());
                policy2_text.setVisibility(v);

                RotateAnimation rotateAnimation = new RotateAnimation(0, 180, RotateAnimation.RELATIVE_TO_SELF,
                        0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);

                if(isClicked2){
                    RotateAnimation rotateAnimation1 = new RotateAnimation(180, 0, RotateAnimation.RELATIVE_TO_SELF,
                            0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotateAnimation.setDuration(500);
                    dropdownIcon2.startAnimation(rotateAnimation1);
                    isClicked2=false;
                    rotateAnimation.setFillAfter(true);
                }else{
                    rotateAnimation.setDuration(500);
                    dropdownIcon2.startAnimation(rotateAnimation);
                    isClicked2=true;
                    rotateAnimation.setFillAfter(true);
                }
            }
        });

        dropdownIcon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v = (policy3_text.getVisibility() == View.GONE) ? View.VISIBLE: View.GONE;
                TransitionManager.beginDelayedTransition(policy3, new AutoTransition());
                policy3_text.setVisibility(v);

                RotateAnimation rotateAnimation = new RotateAnimation(0, 180, RotateAnimation.RELATIVE_TO_SELF,
                        0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);

                if(isClicked3){
                    RotateAnimation rotateAnimation1 = new RotateAnimation(180, 0, RotateAnimation.RELATIVE_TO_SELF,
                            0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotateAnimation.setDuration(500);
                    dropdownIcon3.startAnimation(rotateAnimation1);
                    isClicked3=false;
                    rotateAnimation.setFillAfter(true);
                }else{
                    rotateAnimation.setDuration(500);
                    dropdownIcon3.startAnimation(rotateAnimation);
                    isClicked3=true;
                    rotateAnimation.setFillAfter(true);
                }
            }
        });

        dropdownIcon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v = (policy4_text.getVisibility() == View.GONE) ? View.VISIBLE: View.GONE;
                TransitionManager.beginDelayedTransition(policy4, new AutoTransition());
                policy4_text.setVisibility(v);

                RotateAnimation rotateAnimation = new RotateAnimation(0, 180, RotateAnimation.RELATIVE_TO_SELF,
                        0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);

                if(isClicked4){
                    RotateAnimation rotateAnimation1 = new RotateAnimation(180, 0, RotateAnimation.RELATIVE_TO_SELF,
                            0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotateAnimation.setDuration(500);
                    dropdownIcon4.startAnimation(rotateAnimation1);
                    isClicked4=false;
                    rotateAnimation.setFillAfter(true);
                }else{
                    rotateAnimation.setDuration(500);
                    dropdownIcon4.startAnimation(rotateAnimation);
                    isClicked4=true;
                    rotateAnimation.setFillAfter(true);
                }
            }
        });

        dropdownIcon5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v = (policy5_text.getVisibility() == View.GONE) ? View.VISIBLE: View.GONE;
                TransitionManager.beginDelayedTransition(policy5, new AutoTransition());
                policy5_text.setVisibility(v);

                RotateAnimation rotateAnimation = new RotateAnimation(0, 180, RotateAnimation.RELATIVE_TO_SELF,
                        0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);

                if(isClicked5){
                    RotateAnimation rotateAnimation1 = new RotateAnimation(180, 0, RotateAnimation.RELATIVE_TO_SELF,
                            0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotateAnimation.setDuration(500);
                    dropdownIcon5.startAnimation(rotateAnimation1);
                    isClicked5=false;
                    rotateAnimation.setFillAfter(true);
                }else{
                    rotateAnimation.setDuration(500);
                    dropdownIcon5.startAnimation(rotateAnimation);
                    isClicked5=true;
                    rotateAnimation.setFillAfter(true);
                }
            }
        });




    }
}