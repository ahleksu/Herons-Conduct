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

public class Register_Reporter extends AppCompatActivity {

    ImageButton cancelButton3, cancelButtonError3;

    Button ok_btn3, ok_btnError3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_reporter);

        reg_rep();
    }



    public void reg_rep() {
        EditText edtFNameRep = findViewById(R.id.fNameRep);
        EditText edtMNameRep = findViewById(R.id.mNameRep);
        EditText edtLNameRep = findViewById(R.id.lNameRep);
        EditText edtUmakEmailRep = findViewById(R.id.umakEmailReporter);
        EditText edtIdNumberRep = findViewById(R.id.idNumber_Reporter);
        EditText edtEmailRep = findViewById(R.id.reporter_Email);
        EditText edtPasswordRep = findViewById(R.id.parent_Password);
        EditText edtConfirmPasswordRep = findViewById(R.id.parent_ConfirmPassword);


        Button Register_REPORTER = findViewById(R.id.Register_REPORTER);
        Register_REPORTER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String FNameRep = edtFNameRep.getText().toString();
                String MNameRep = edtMNameRep.getText().toString();
                String LNameRep = edtLNameRep.getText().toString();
                String UmakEmailRep = edtUmakEmailRep.getText().toString();
                String IdNumberRep = edtIdNumberRep.getText().toString();
                String EmailRep = edtEmailRep.getText().toString();
                String PasswordRep = edtPasswordRep.getText().toString();
                String ConfirmPasswordRep = edtConfirmPasswordRep.getText().toString();



                if(TextUtils.isEmpty(FNameRep) || TextUtils.isEmpty(MNameRep) || TextUtils.isEmpty(LNameRep) || TextUtils.isEmpty(UmakEmailRep) || TextUtils.isEmpty(IdNumberRep) || TextUtils.isEmpty(EmailRep) || TextUtils.isEmpty(PasswordRep)) {
                    openDialogError();
                    return;
                }

                if(FNameRep.isEmpty()) {
                    openDialogError();
                    return;
                }

                if(!ConfirmPasswordRep.equals(PasswordRep)) {
                    Toast.makeText(Register_Reporter.this, "Mismatch Password", Toast.LENGTH_SHORT).show();
                }

                else {
                    openDialog();
                }

            }
        });



    }



    private void openDialog() {
        View alertCustomDialog = LayoutInflater.from(Register_Reporter.this).inflate(R.layout.custom_dialog, null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Register_Reporter.this);

        alertDialog.setView(alertCustomDialog);
        cancelButton3 = (ImageButton) alertCustomDialog.findViewById(R.id.cancelID);
        ok_btn3 = (Button) alertCustomDialog.findViewById(R.id.ok_btn_id);

        final AlertDialog dialog = alertDialog.create();


        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();


        cancelButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();

            }
        });
        ok_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                Intent intent = new Intent (getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });
    }



    private void openDialogError() {
        View alertCustomDialog = LayoutInflater.from(Register_Reporter.this).inflate(R.layout.custom_dialog_error, null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Register_Reporter.this);

        alertDialog.setView(alertCustomDialog);
        cancelButtonError3 = (ImageButton) alertCustomDialog.findViewById(R.id.cancelID_error);
        ok_btnError3 = (Button) alertCustomDialog.findViewById(R.id.ok_btn_id_error);

        final AlertDialog dialog = alertDialog.create();


        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();


        cancelButtonError3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();

            }
        });
        ok_btnError3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
    }


    public void x_back2(View View) {
        Intent intent = new Intent(getApplicationContext(), Register.class);
        startActivity(intent);
    }
}