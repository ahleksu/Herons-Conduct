package com.umak.heronsconduct.reporter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.umak.heronsconduct.R;

import org.w3c.dom.Text;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class CreateIncidentReferral extends AppCompatActivity {

    String [] ref_type = {"Student to Student", "Faculty to Student", "Student to Faculty"};
    String [] incident_type;
    String [] location;

    TextInputLayout fname, sname,id_num,date,time,floor,specific_area,description, fname_offender, sname_offender, id_num_offender, fname_witness, sname_witness, id_num_witness;


    AutoCompleteTextView autoCompleteTextView, autoCompleteTextView2, autoCompleteTextView3;
    ArrayAdapter<String> adapterItems, adapterItems2, adapterItems3;

    Button cancelRefBtn, submitRefBtn;
    ImageView backReporterHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_incident_referral);


        //TextFields
        fname = findViewById(R.id.parties_first_name);
        sname = findViewById(R.id.parties_last_name);
        id_num = findViewById(R.id.parties_id_number);
        date = findViewById(R.id.ref_date);
        time = findViewById(R.id.ref_time);
        floor = findViewById(R.id.ref_floor);
        specific_area = findViewById(R.id.ref_specific_area);
        description = findViewById(R.id.ref_description);
        fname_offender = findViewById(R.id.fname_of_offender);

        //Parties Involved
        sname_offender = findViewById(R.id.lname_of_offender);
        id_num_offender = findViewById(R.id.idnum_offender);
        fname_witness = findViewById(R.id.fname_of_witness);
        sname_witness = findViewById(R.id.lname_of_witness);
        id_num_witness = findViewById(R.id.idnum_witness);

        //Buttons
        cancelRefBtn = findViewById(R.id.cancel_ref_btn);
        submitRefBtn = findViewById(R.id.submit_ref_btn);
        backReporterHome = findViewById(R.id.back_to_reporterHome);


        //String Array
        incident_type = getResources().getStringArray(R.array.incident);
        location = getResources().getStringArray(R.array.location);

        autoCompleteTextView = findViewById(R.id.auto_complete_txt);
        autoCompleteTextView2 = findViewById(R.id.auto_complete_txt2);
        autoCompleteTextView3 = findViewById(R.id.auto_complete_txt3);

        adapterItems = new ArrayAdapter<String>(this, R.layout.ref_type_list_item, ref_type);
        adapterItems2 = new ArrayAdapter<String>(this, R.layout.ref_type_list_item, incident_type);
        adapterItems3 = new ArrayAdapter<String>(this, R.layout.ref_type_list_item, location);

        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView2.setAdapter(adapterItems2);
        autoCompleteTextView3.setAdapter(adapterItems3);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), "Item: "+item, Toast.LENGTH_SHORT).show();
            }
        });

        autoCompleteTextView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), "Item: "+item, Toast.LENGTH_SHORT).show();
            }
        });

        autoCompleteTextView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), "Item: "+item, Toast.LENGTH_SHORT).show();
            }
        });

    }



}