package com.umak.heronsconduct.general;

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

import com.umak.heronsconduct.R;

public class TermsOfService extends AppCompatActivity {

    TextView tos1_details,tos2_details,tos3_details, tos4_details, tos5_details, tos6_details,tos7_details,tos8_details;
    LinearLayout tos1, tos2, tos3, tos4, tos5, tos6, tos7, tos8;
    ImageView tosBackBtn, dropdownIcon1, dropdownIcon2, dropdownIcon3, dropdownIcon4, dropdownIcon5, dropdownIcon6, dropdownIcon7, dropdownIcon8;
    boolean isClicked1, isClicked2, isClicked3, isClicked4, isClicked5, isClicked6, isClicked7, isClicked8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_of_service);

        //Button
        tosBackBtn = findViewById(R.id.tosBackBtn);

        //Dropdowns
        dropdownIcon1 = findViewById(R.id.dropdownIcon1);
        dropdownIcon2 = findViewById(R.id.dropdownIcon2);
        dropdownIcon3 = findViewById(R.id.dropdownIcon3);
        dropdownIcon4 = findViewById(R.id.dropdownIcon4);
        dropdownIcon5 = findViewById(R.id.dropdownIcon5);
        dropdownIcon6 = findViewById(R.id.dropdownIcon6);
        dropdownIcon7 = findViewById(R.id.dropdownIcon7);
        dropdownIcon8 = findViewById(R.id.dropdownIcon8);

        //FAQs details
        tos1_details = findViewById(R.id.tos1_details);
        tos2_details = findViewById(R.id.tos2_details);
        tos3_details = findViewById(R.id.tos3_details);
        tos4_details = findViewById(R.id.tos4_details);
        tos5_details = findViewById(R.id.tos5_details);
        tos6_details = findViewById(R.id.tos6_details);
        tos7_details = findViewById(R.id.tos7_details);
        tos8_details = findViewById(R.id.tos8_details);


        //Layouts
        tos1 = findViewById(R.id.tos1);
        tos1.getLayoutTransition().enableTransitionType(LayoutTransition.APPEARING);
        tos2 = findViewById(R.id.tos2);
        tos2.getLayoutTransition().enableTransitionType(LayoutTransition.APPEARING);
        tos3 = findViewById(R.id.tos3);
        tos3.getLayoutTransition().enableTransitionType(LayoutTransition.APPEARING);
        tos4 = findViewById(R.id.tos4);
        tos4.getLayoutTransition().enableTransitionType(LayoutTransition.APPEARING);
        tos5 = findViewById(R.id.tos5);
        tos5.getLayoutTransition().enableTransitionType(LayoutTransition.APPEARING);
        tos6 = findViewById(R.id.tos6);
        tos6.getLayoutTransition().enableTransitionType(LayoutTransition.APPEARING);
        tos7 = findViewById(R.id.tos7);
        tos7.getLayoutTransition().enableTransitionType(LayoutTransition.APPEARING);
        tos8 = findViewById(R.id.tos8);
        tos8.getLayoutTransition().enableTransitionType(LayoutTransition.APPEARING);

        tosBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        dropdownIcon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v = (tos1_details.getVisibility() == View.GONE) ? View.VISIBLE: View.GONE;
                TransitionManager.beginDelayedTransition(tos1, new AutoTransition());
                tos1_details.setVisibility(v);

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
                int v = (tos2_details.getVisibility() == View.GONE) ? View.VISIBLE: View.GONE;
                TransitionManager.beginDelayedTransition(tos2, new AutoTransition());
                tos2_details.setVisibility(v);

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
                int v = (tos3_details.getVisibility() == View.GONE) ? View.VISIBLE: View.GONE;
                TransitionManager.beginDelayedTransition(tos3, new AutoTransition());
                tos3_details.setVisibility(v);

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
                int v = (tos4_details.getVisibility() == View.GONE) ? View.VISIBLE: View.GONE;
                TransitionManager.beginDelayedTransition(tos4, new AutoTransition());
                tos4_details.setVisibility(v);

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
                int v = (tos5_details.getVisibility() == View.GONE) ? View.VISIBLE: View.GONE;
                TransitionManager.beginDelayedTransition(tos5, new AutoTransition());
                tos5_details.setVisibility(v);

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

        dropdownIcon6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v = (tos6_details.getVisibility() == View.GONE) ? View.VISIBLE: View.GONE;
                TransitionManager.beginDelayedTransition(tos6, new AutoTransition());
                tos6_details.setVisibility(v);

                RotateAnimation rotateAnimation = new RotateAnimation(0, 180, RotateAnimation.RELATIVE_TO_SELF,
                        0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);

                if(isClicked6){
                    RotateAnimation rotateAnimation1 = new RotateAnimation(180, 0, RotateAnimation.RELATIVE_TO_SELF,
                            0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotateAnimation.setDuration(500);
                    dropdownIcon6.startAnimation(rotateAnimation1);
                    isClicked6=false;
                    rotateAnimation.setFillAfter(true);
                }else{
                    rotateAnimation.setDuration(500);
                    dropdownIcon6.startAnimation(rotateAnimation);
                    isClicked6=true;
                    rotateAnimation.setFillAfter(true);
                }
            }
        });

        dropdownIcon7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v = (tos7_details.getVisibility() == View.GONE) ? View.VISIBLE: View.GONE;
                TransitionManager.beginDelayedTransition(tos7, new AutoTransition());
                tos7_details.setVisibility(v);

                RotateAnimation rotateAnimation = new RotateAnimation(0, 180, RotateAnimation.RELATIVE_TO_SELF,
                        0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);

                if(isClicked7){
                    RotateAnimation rotateAnimation1 = new RotateAnimation(180, 0, RotateAnimation.RELATIVE_TO_SELF,
                            0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotateAnimation.setDuration(500);
                    dropdownIcon7.startAnimation(rotateAnimation1);
                    isClicked7=false;
                    rotateAnimation.setFillAfter(true);
                }else{
                    rotateAnimation.setDuration(500);
                    dropdownIcon7.startAnimation(rotateAnimation);
                    isClicked7=true;
                    rotateAnimation.setFillAfter(true);
                }
            }
        });

        dropdownIcon8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v = (tos8_details.getVisibility() == View.GONE) ? View.VISIBLE: View.GONE;
                TransitionManager.beginDelayedTransition(tos8, new AutoTransition());
                tos8_details.setVisibility(v);

                RotateAnimation rotateAnimation = new RotateAnimation(0, 180, RotateAnimation.RELATIVE_TO_SELF,
                        0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);

                if(isClicked6){
                    RotateAnimation rotateAnimation1 = new RotateAnimation(180, 0, RotateAnimation.RELATIVE_TO_SELF,
                            0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotateAnimation.setDuration(500);
                    dropdownIcon8.startAnimation(rotateAnimation1);
                    isClicked8=false;
                    rotateAnimation.setFillAfter(true);
                }else{
                    rotateAnimation.setDuration(500);
                    dropdownIcon8.startAnimation(rotateAnimation);
                    isClicked8=true;
                    rotateAnimation.setFillAfter(true);
                }
            }
        });





    }
}