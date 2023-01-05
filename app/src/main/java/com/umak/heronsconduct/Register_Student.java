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

public class Register_Student extends AppCompatActivity {




    ImageButton cancelButton, cancelButtonError;
    Button ok_btn, ok_btnError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student);

        reg_stu();


        Button have_acc = findViewById(R.id.login_haveAccSTU);

        have_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });


    }

    public void reg_stu() {
        EditText edtFNameSTU = findViewById(R.id.fNameStudent);
        EditText edtMNameSTU = findViewById(R.id.mNameStudent);
        EditText edtLNameSTU = findViewById(R.id.lNameStudent);
        EditText edtGenderSTU = findViewById(R.id.genderStudent);
        EditText edtBirthSTU = findViewById(R.id.birthdateStudent);
        EditText edtAddressSTU = findViewById(R.id.addressStudent);
        EditText edtContactNumSTU = findViewById(R.id.contactNumberStudent);
        EditText edtUmakEmailSTU = findViewById(R.id.umakEmailStudent);
        EditText edtStudentID = findViewById(R.id.studentID);
        EditText edtPersonalEmailSTU = findViewById(R.id.personalEmail_Student);
        EditText edtCollegeSTU = findViewById(R.id.collegeStudent);
        EditText edtYearSTU = findViewById(R.id.yearLevelStudent);
        EditText edtCourseSTU = findViewById(R.id.courseStudent);
        EditText edtPasswordSTU = findViewById(R.id.passwordStudent);
        EditText edtConfirmPasswordSTU = findViewById(R.id.ConfirmPassword_Student);





        Button reg_stu = findViewById(R.id.Register_STU);
        reg_stu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String FNameSTU = edtFNameSTU.getText().toString();
                String MNameSTU = edtMNameSTU.getText().toString();
                String LNameSTU = edtLNameSTU.getText().toString();
                String GenderSTU = edtGenderSTU.getText().toString();
                String BirthSTU = edtBirthSTU.getText().toString();
                String AddressSTU = edtAddressSTU.getText().toString();
                String ContactNumSTU = edtContactNumSTU.getText().toString();
                String UmakEmailSTU = edtUmakEmailSTU.getText().toString();
                String StudentIDSTU = edtStudentID.getText().toString();
                String PersonalEmailSTU = edtPersonalEmailSTU.getText().toString();
                String CollegeSTU = edtCollegeSTU.getText().toString();
                String YearSTU = edtYearSTU.getText().toString();
                String CourseSTU = edtCourseSTU.getText().toString();
                String PasswordSTU = edtPasswordSTU.getText().toString();
                String ConfirmPasswordSTU = edtConfirmPasswordSTU.getText().toString();


                if(TextUtils.isEmpty(FNameSTU) || TextUtils.isEmpty(MNameSTU) || TextUtils.isEmpty(LNameSTU) || TextUtils.isEmpty(GenderSTU) || TextUtils.isEmpty(BirthSTU) || TextUtils.isEmpty(AddressSTU) || TextUtils.isEmpty(ContactNumSTU) || TextUtils.isEmpty(UmakEmailSTU) || TextUtils.isEmpty(StudentIDSTU) ||
                        TextUtils.isEmpty(PersonalEmailSTU) || TextUtils.isEmpty(CollegeSTU) || TextUtils.isEmpty(YearSTU) || TextUtils.isEmpty(CourseSTU) || TextUtils.isEmpty(PasswordSTU)) {
                    openDialogError();
                    return;
                }

                if(FNameSTU.isEmpty()) {
                    openDialogError();
                    return;
                }

                if(!ConfirmPasswordSTU.equals(PasswordSTU)) {
                    Toast.makeText(Register_Student.this, "Mismatch Password", Toast.LENGTH_SHORT).show();
                }

                else {
                    openDialog();
                }

            }
        });
    }

    private void openDialog() {
        View alertCustomDialog = LayoutInflater.from(Register_Student.this).inflate(R.layout.custom_dialog, null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Register_Student.this);

        alertDialog.setView(alertCustomDialog);
        cancelButton = (ImageButton) alertCustomDialog.findViewById(R.id.cancelID);
        ok_btn = (Button) alertCustomDialog.findViewById(R.id.ok_btn_id);

        final AlertDialog dialog = alertDialog.create();


        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();


        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();

            }
        });
        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                Intent intent = new Intent (getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });
    }



    private void openDialogError() {
        View alertCustomDialog = LayoutInflater.from(Register_Student.this).inflate(R.layout.custom_dialog_error, null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Register_Student.this);

        alertDialog.setView(alertCustomDialog);
        cancelButtonError = (ImageButton) alertCustomDialog.findViewById(R.id.cancelID_error);
        ok_btnError = (Button) alertCustomDialog.findViewById(R.id.ok_btn_id_error);

        final AlertDialog dialog = alertDialog.create();


        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();


        cancelButtonError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();

            }
        });
        ok_btnError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
    }


    


    public void x_back(View view) {

        Intent intent = new Intent(getApplicationContext(), Register.class);
        startActivity(intent);

    }

}