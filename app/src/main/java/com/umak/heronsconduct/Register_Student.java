package com.umak.heronsconduct;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.AbstractList;
import java.util.Calendar;

public class Register_Student extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private DatePickerDialog datePickerDialog;
    private EditText dateButton;

    ImageButton cancelButton, cancelButtonError;
    Button ok_btn, ok_btnError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student);

        //method for register button
        reg_stu();

        //dropdown
        spinner();


/*
        Button have_accStudent = findViewById(R.id.login_haveAccSTU);
        have_accStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });

 */


    }

    public void spinner() {
        Spinner spinner = findViewById(R.id.genderStudent);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.genders, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Spinner spinner1 = findViewById(R.id.collegeStudent);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.colleges, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this);


        Spinner spinner3 = findViewById(R.id.courseStudent);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.courses, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(this);
    }



    public void reg_stu() {
        EditText edtFNameSTU = findViewById(R.id.fNameStudent);
        EditText edtMNameSTU = findViewById(R.id.mNameStudent);
        EditText edtLNameSTU = findViewById(R.id.lNameStudent);
        Spinner edtGenderSTU = findViewById(R.id.genderStudent);
        EditText edtBirthSTU = findViewById(R.id.birthdateStudent);
        EditText edtAddressSTU = findViewById(R.id.addressStudent);
        EditText edtContactNumSTU = findViewById(R.id.contactNumberStudent);
        EditText edtUmakEmailSTU = findViewById(R.id.umakEmailStudent);
        EditText edtStudentID = findViewById(R.id.studentID);
        EditText edtPersonalEmailSTU = findViewById(R.id.personalEmail_Student);
        Spinner edtCollegeSTU = findViewById(R.id.collegeStudent);
        EditText edtYearSTU = findViewById(R.id.yearLevelStudent);
        Spinner edtCourseSTU = findViewById(R.id.courseStudent);
        EditText edtPasswordSTU = findViewById(R.id.passwordStudent);
        EditText edtConfirmPasswordSTU = findViewById(R.id.ConfirmPassword_Student);


        Button reg_stu = findViewById(R.id.Register_STU);
        reg_stu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String FNameSTU = edtFNameSTU.getText().toString();
                String MNameSTU = edtMNameSTU.getText().toString();
                String LNameSTU = edtLNameSTU.getText().toString();
                String GenderSTU = edtGenderSTU.toString();
                String BirthSTU = edtBirthSTU.getText().toString();
                String AddressSTU = edtAddressSTU.getText().toString();
                String ContactNumSTU = edtContactNumSTU.getText().toString();
                String UmakEmailSTU = edtUmakEmailSTU.getText().toString();
                String StudentIDSTU = edtStudentID.getText().toString();
                String PersonalEmailSTU = edtPersonalEmailSTU.getText().toString();
                String CollegeSTU = edtCollegeSTU.toString();
                String YearSTU = edtYearSTU.toString();
                String CourseSTU = edtCourseSTU.toString();
                String PasswordSTU = edtPasswordSTU.getText().toString();
                String ConfirmPasswordSTU = edtConfirmPasswordSTU.getText().toString();


                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                Toast.makeText(Register_Student.this, "REGISTER", Toast.LENGTH_SHORT).show();
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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {



        String text = adapterView.getItemAtPosition(i).toString();
        //Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();

        ((TextView) adapterView.getChildAt(0)).setTextSize(12);
        ((TextView) adapterView.getChildAt(0)).setTextColor(Color.BLACK);

        String text1 = adapterView.getItemAtPosition(i).toString();


        ((TextView) adapterView.getChildAt(0)).setTextSize(12);
        ((TextView) adapterView.getChildAt(0)).setTextColor(Color.BLACK);

        String text2 = adapterView.getItemAtPosition(i).toString();

        ((TextView) adapterView.getChildAt(0)).setTextSize(12);
        ((TextView) adapterView.getChildAt(0)).setTextColor(Color.BLACK);

        String text3 = adapterView.getItemAtPosition(i).toString();

        ((TextView) adapterView.getChildAt(0)).setTextSize(12);
        ((TextView) adapterView.getChildAt(0)).setTextColor(Color.BLACK);

    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}