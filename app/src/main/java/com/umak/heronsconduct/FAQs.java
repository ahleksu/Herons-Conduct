package com.umak.heronsconduct;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
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

public class FAQs extends AppCompatActivity {

    TextView details;
    LinearLayout linearLayout;
    ImageView dropdownIcon;
    boolean isClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqs);

        dropdownIcon = findViewById(R.id.dropdownIcon);
        details = findViewById(R.id.dropdown_details);
        linearLayout = findViewById(R.id.details_layout);
        linearLayout.getLayoutTransition().enableTransitionType(LayoutTransition.APPEARING);

        dropdownIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v = (details.getVisibility() == View.GONE) ? View.VISIBLE: View.GONE;
                TransitionManager.beginDelayedTransition(linearLayout, new AutoTransition());
                details.setVisibility(v);

                RotateAnimation rotateAnimation = new RotateAnimation(0, 180, RotateAnimation.RELATIVE_TO_SELF,
                        0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);

                if(isClicked){
                    RotateAnimation rotateAnimation1 = new RotateAnimation(180, 0, RotateAnimation.RELATIVE_TO_SELF,
                            0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotateAnimation.setDuration(500);
                    dropdownIcon.startAnimation(rotateAnimation1);
                    isClicked=false;
                    rotateAnimation.setFillAfter(true);
                }else{
                    rotateAnimation.setDuration(500);
                    dropdownIcon.startAnimation(rotateAnimation);
                    isClicked=true;
                    rotateAnimation.setFillAfter(true);
                }


            }
        });



    }



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void expand(View view) {




    }
}