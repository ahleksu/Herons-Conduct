package com.umak.heronsconduct.onboarding;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.umak.heronsconduct.R;
import com.umak.heronsconduct.admin.Admin;
import com.umak.heronsconduct.reporter.Reporter;
import com.umak.heronsconduct.student_parent.Parent;
import com.umak.heronsconduct.student_parent.Student;


public class SplashScreen extends AppCompatActivity {

    Handler h = new Handler();

    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        h.postDelayed(new Runnable() {
            @Override
            public void run() {




                    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

                    if(firebaseUser != null){
                        firebaseFirestore.collection("ACCOUNT_TABLE")
                                .document(firebaseAuth.getUid())
                                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                    @Override
                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                                        if (documentSnapshot.getData() != null) {

                                            String typeofAccount = documentSnapshot.get("type").toString();

                                            if (typeofAccount.equals("student")) {
                                                Intent intent = new Intent(getApplicationContext(), Student.class);
                                                startActivity(intent);
                                                finish();
                                            } else if(typeofAccount.equals("parent")) {
                                                Intent intent = new Intent(getApplicationContext(), Parent.class);
                                                startActivity(intent);
                                                finish();
                                            }
                                            else if (typeofAccount.equals("reporter")) {
                                                Intent intent = new Intent(getApplicationContext(), Reporter.class);
                                                startActivity(intent);
                                            } else if(typeofAccount.equals("admin")) {
                                                Intent intent = new Intent(getApplicationContext(), Admin.class);
                                                startActivity(intent);
                                                finish();
                                            }

                                        }
                                    }
                                });
                    }else{
                        Intent i = new Intent(SplashScreen.this, Onboarding.class);
                        startActivity(i);
                        finish();
                    }

            }
        }, 2000);



    }
}