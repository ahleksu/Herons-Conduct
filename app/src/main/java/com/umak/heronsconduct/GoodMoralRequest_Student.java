package com.umak.heronsconduct;



import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class GoodMoralRequest_Student extends AppCompatActivity {


    ImageButton cancelButtonGD, cancelButtonGD1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_moral_request_student);
        req_goodMoral();


        EditText req_name_goodMoral = findViewById(R.id.req_name_goodMoral);



    }

    public void Cancel_GoodMoral() {
        Button Cancel_GoodMoral = findViewById(R.id.Cancel_GoodMoral);
        Cancel_GoodMoral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }



    public void req_goodMoral() {

        EditText edtReq_name_goodMoral = findViewById(R.id.req_name_goodMoral);
        EditText edtReq_umakEmail_goodmoral = findViewById(R.id.req_umakEmail_goodmoral);
        EditText edtReq_college_goodmoral = findViewById(R.id.req_college_goodmoral);
        EditText edtReq_idnumber_goodMoral = findViewById(R.id.req_idnumber_goodMoral);
        
        
        Button Request_GoodMoral = findViewById(R.id.Request_GoodMoral);
        Request_GoodMoral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String req_nameGoodMoral = edtReq_name_goodMoral.getText().toString();
               String req_EmailGoodMoral = edtReq_name_goodMoral.getText().toString();
               String req_collegeGoodMoral = edtReq_name_goodMoral.getText().toString();
               String req_idNumberGoodMoral = edtReq_name_goodMoral.getText().toString();


                if(TextUtils.isEmpty(req_nameGoodMoral) || TextUtils.isEmpty(req_EmailGoodMoral) || TextUtils.isEmpty(req_collegeGoodMoral) || TextUtils.isEmpty(req_idNumberGoodMoral)) {
                    openDialogError();
                }
                else {
                    openDialog();
                }
                

            }
        });
    }

    private void openDialog() {
        View alertCustomDialog = LayoutInflater.from(GoodMoralRequest_Student.this).inflate(R.layout.req_goodmoral_dialog, null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(GoodMoralRequest_Student.this);

        alertDialog.setView(alertCustomDialog);
        cancelButtonGD = (ImageButton) alertCustomDialog.findViewById(R.id.cancelID);

        final AlertDialog dialog = alertDialog.create();

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        cancelButtonGD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();

            }
        });
    }

    private void openDialogError() {
        View alertCustomDialog = LayoutInflater.from(GoodMoralRequest_Student.this).inflate(R.layout.req_goodmoral_dialog_error, null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(GoodMoralRequest_Student.this);

        alertDialog.setView(alertCustomDialog);
        cancelButtonGD1 = (ImageButton) alertCustomDialog.findViewById(R.id.cancelID);

        final AlertDialog dialog = alertDialog.create();

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        cancelButtonGD1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();

            }
        });
    }

}