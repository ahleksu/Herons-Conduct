package com.umak.heronsconduct.general;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import android.content.Intent;
import android.graphics.Matrix;

import android.animation.LayoutTransition;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.umak.heronsconduct.R;

public class FAQs extends AppCompatActivity {

    TextView faqs1_text,faqs2_text,faqs3_text, faqs4_text, faqs5_text, faqs6_text;
    LinearLayout faqs1, faqs2, faqs3, faqs4, faqs5, faqs6;
    ImageView faqsBackBtn, dropdownIcon1, dropdownIcon2, dropdownIcon3, dropdownIcon4, dropdownIcon5, dropdownIcon6;
    boolean isClicked1, isClicked2, isClicked3, isClicked4, isClicked5, isClicked6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqs);

        //Button
        faqsBackBtn = findViewById(R.id.faqsBackBtn);

        //Dropdowns
        dropdownIcon1 = findViewById(R.id.dropdownIcon1);
        dropdownIcon2 = findViewById(R.id.dropdownIcon2);
        dropdownIcon3 = findViewById(R.id.dropdownIcon3);
        dropdownIcon4 = findViewById(R.id.dropdownIcon4);
        dropdownIcon5 = findViewById(R.id.dropdownIcon5);
        dropdownIcon6 = findViewById(R.id.dropdownIcon6);

        //FAQs details
        faqs1_text = findViewById(R.id.faqs1_details);
        faqs2_text = findViewById(R.id.faqs2_details);
        faqs3_text = findViewById(R.id.faqs3_details);
        faqs4_text = findViewById(R.id.faqs4_details);
        faqs5_text = findViewById(R.id.faqs5_details);
        faqs6_text = findViewById(R.id.faqs6_details);


        //Layouts
        faqs1 = findViewById(R.id.faqs1);
        faqs1.getLayoutTransition().enableTransitionType(LayoutTransition.APPEARING);
        faqs2 = findViewById(R.id.faqs2);
        faqs2.getLayoutTransition().enableTransitionType(LayoutTransition.APPEARING);
        faqs3 = findViewById(R.id.faqs3);
        faqs3.getLayoutTransition().enableTransitionType(LayoutTransition.APPEARING);
        faqs4 = findViewById(R.id.faqs4);
        faqs4.getLayoutTransition().enableTransitionType(LayoutTransition.APPEARING);
        faqs5 = findViewById(R.id.faqs5);
        faqs5.getLayoutTransition().enableTransitionType(LayoutTransition.APPEARING);
        faqs6 = findViewById(R.id.faqs6);
        faqs6.getLayoutTransition().enableTransitionType(LayoutTransition.APPEARING);

        faqsBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        dropdownIcon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v = (faqs1_text.getVisibility() == View.GONE) ? View.VISIBLE: View.GONE;
                TransitionManager.beginDelayedTransition(faqs1, new AutoTransition());
                faqs1_text.setVisibility(v);

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
                int v = (faqs2_text.getVisibility() == View.GONE) ? View.VISIBLE: View.GONE;
                TransitionManager.beginDelayedTransition(faqs2, new AutoTransition());
                faqs2_text.setVisibility(v);

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
                int v = (faqs3_text.getVisibility() == View.GONE) ? View.VISIBLE: View.GONE;
                TransitionManager.beginDelayedTransition(faqs3, new AutoTransition());
                faqs3_text.setVisibility(v);

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
                int v = (faqs4_text.getVisibility() == View.GONE) ? View.VISIBLE: View.GONE;
                TransitionManager.beginDelayedTransition(faqs4, new AutoTransition());
                faqs4_text.setVisibility(v);

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
                int v = (faqs5_text.getVisibility() == View.GONE) ? View.VISIBLE: View.GONE;
                TransitionManager.beginDelayedTransition(faqs5, new AutoTransition());
                faqs5_text.setVisibility(v);

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
                int v = (faqs6_text.getVisibility() == View.GONE) ? View.VISIBLE: View.GONE;
                TransitionManager.beginDelayedTransition(faqs6, new AutoTransition());
                faqs6_text.setVisibility(v);

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



    }
}