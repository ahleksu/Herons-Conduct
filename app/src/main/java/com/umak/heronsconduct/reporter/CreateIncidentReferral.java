package com.umak.heronsconduct.reporter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.inputmethodservice.KeyboardView;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.umak.heronsconduct.R;
import com.umak.heronsconduct.admin.AdminIncidentReferrals;
import com.umak.heronsconduct.register.Register_Parent;

import org.w3c.dom.Text;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CreateIncidentReferral extends AppCompatActivity {

    String [] ref_type = {"Student to Student", "Faculty to Student", "Student to Faculty"};
    String [] incident_type;
    String [] location;

    TextInputLayout fname, sname,id_num,date,time,floor,specific_area,description, fname_offender, sname_offender, id_num_offender, fname_witness, sname_witness, id_num_witness;


    EditText txt_firstname_reporter,txt_lastname_reporter,txt_date,txt_idnumber_reporter,txt_time,txt_floor,txt_specific_area,txt_description,txt_firstname_parties,txt_lastname_parties,txt_idnumber_parties, witness_firstname, witnerss_id,last_name_witness;;
    ImageView img_upload;

    AutoCompleteTextView autoCompleteTextView, autoCompleteTextView2, autoCompleteTextView3;
    ArrayAdapter<String> adapterItems, adapterItems2, adapterItems3;

    Button cancelRefBtn, submitRefBtn;
    ImageView backReporterHome;

    Uri uri;


    //reference type output
    String reftypeOutput = "";
    String locationOutput = "";
    String icidentTypeOutput = "";
    Dialog dialog;

    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

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


        //inititialize xml value
        initXml();

        //getting the first, ID Number and lastnane of reporter
        getPrimaryDataMethod();

        //upload Image method for ui
        uploadImageMethod();

        //upload in Firebase
        uploadDataMethod();




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
                reftypeOutput = adapterView.getItemAtPosition(i).toString();
                //Toast.makeText(getApplicationContext(), "Item: "+item, Toast.LENGTH_SHORT).show();
            }
        });

        autoCompleteTextView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                icidentTypeOutput = adapterView.getItemAtPosition(i).toString();
                //Toast.makeText(getApplicationContext(), "Item: "+item, Toast.LENGTH_SHORT).show();
            }
        });

        autoCompleteTextView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                locationOutput = adapterView.getItemAtPosition(i).toString();
                //Toast.makeText(getApplicationContext(), "Item: "+item, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void uploadDataMethod() {
        submitRefBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ProgressBar progressBar = findViewById(R.id.progressbar);
                progressBar.setVisibility(View.VISIBLE);
                FirebaseStorage uploadStorage = FirebaseStorage.getInstance();
                StorageReference uploadRefeecne = FirebaseStorage.getInstance().getReference();


                if(uri == null){
                    Toast.makeText(getApplicationContext(), "Evidence is required" , Toast.LENGTH_SHORT).show();
                } else if(!txt_firstname_reporter.getText().toString().equals("") || txt_lastname_reporter.getText().toString().equals("") || txt_date.getText().toString().equals("") || txt_time.getText().toString().equals("") || txt_floor.getText().toString().equals("") || txt_specific_area.getText().toString().equals("") || txt_description.getText().toString().equals("") || txt_firstname_parties.getText().toString().equals("") || txt_lastname_parties.equals("")|| txt_idnumber_parties.getText().toString().equals("")){



                    //get reference to firebase storage
                    StorageReference uploadIncedental = uploadRefeecne.child("incedent/" + firebaseAuth.getCurrentUser().getEmail() + FieldValue.serverTimestamp() );

                    uploadIncedental.putFile(uri).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {

                        }
                    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            uploadIncedental.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    HashMap<String, Object> addIncident = new HashMap<>();

                                    addIncident.put("img_url", uri);
                                    addIncident.put("firstname_reporter", txt_firstname_reporter.getText().toString());
                                    addIncident.put("lastname_reporter", txt_lastname_reporter.getText().toString());
                                    addIncident.put("IDNumber_reporter", txt_idnumber_reporter.getText().toString());
                                    addIncident.put("typeOfReferal", reftypeOutput);

                                    addIncident.put("incidenttype", icidentTypeOutput);
                                    addIncident.put("loc_of_incendent", icidentTypeOutput);
                                    addIncident.put("lcoation", locationOutput);

                                    addIncident.put("date", txt_date.getText().toString());
                                    addIncident.put("time", txt_time.getText().toString());
                                    addIncident.put("floor", txt_floor.getText().toString());

                                    //descriptiom
                                    addIncident.put("description", txt_description.getText().toString());

                                    //parties
                                    addIncident.put("firstname_parties", txt_firstname_parties.getText().toString());
                                    addIncident.put("lastname_parties", txt_lastname_parties.getText().toString());
                                    addIncident.put("IDNumber_parties", txt_idnumber_parties.getText().toString());

                                    //witness
                                    addIncident.put("witnerss_id", witnerss_id.getText().toString());
                                    addIncident.put("witness_firstname", witness_firstname.getText().toString());
                                    addIncident.put("witness_lastname", last_name_witness.getText().toString());
                                    addIncident.put("reported_by", firebaseAuth.getUid());

                                    firebaseFirestore.collection("Incident_referrals").add(addIncident).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                        @Override
                                        public void onSuccess(DocumentReference documentReference) {
                                            //Exit Dialog
                                            dialog = new Dialog(CreateIncidentReferral.this);
                                            dialog.setContentView(R.layout.custom_dialog);

                                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                                dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background));
                                            }

                                            dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                                            dialog.setCancelable(false);
                                            dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

                                            //Custom Exit Dialog
                                            Button ok = dialog.findViewById(R.id.ok_btn_id);

                                            TextView text = dialog.findViewById(R.id.accCollege);

                                            text.setText("Your report has been recorded");

                                            ok.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View view) {
                                                    Intent intent = new Intent(getApplicationContext(), Reporter.class);
                                                    startActivity(intent);
                                                    finish();
                                                }
                                            });

                                            dialog.show();

                                            //Toast.makeText(getApplicationContext(),"Success", Toast.LENGTH_SHORT).show();
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    });

                                }
                            });
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);

                        }
                    });

                }

            }
        });
    }

    private void uploadImageMethod() {
        img_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img_upload.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ImagePicker.with(CreateIncidentReferral.this)
                                .galleryOnly()
                                .crop()
                                .compress(1024)
                                .maxResultSize(1080, 1080)
                                .start();
                    }
                });
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            //Image Uri will not be null for RESULT_OK
            uri = data.getData();
            img_upload.setImageURI(uri);
        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show();
        }
    }


    private void getPrimaryDataMethod() {
        firebaseFirestore.collection("reporter").document(firebaseAuth.getUid())
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        DocumentSnapshot documentSnapshot = task.getResult();
                        txt_firstname_reporter.setText(documentSnapshot.get("first_name").toString());
                        txt_lastname_reporter.setText(documentSnapshot.get("last_name").toString());
                        txt_idnumber_reporter.setText(documentSnapshot.get("reporterID").toString());
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("firebase", e.getMessage());
                    }
                });
    }

    private void initXml() {


        txt_idnumber_reporter = findViewById(R.id.txt_idnumber_reporter);
        img_upload = findViewById(R.id.img_upload);
        txt_firstname_reporter  = findViewById(R.id.txt_firstname_reporter);
        txt_lastname_reporter  = findViewById(R.id.txt_lastname_reporter);
        txt_date  = findViewById(R.id.txt_date);
        txt_time  = findViewById(R.id.txt_time);
        txt_floor  = findViewById(R.id.txt_floor);
        txt_specific_area  = findViewById(R.id.txt_specific_area);
        txt_description  = findViewById(R.id.txt_description);
        txt_firstname_parties  = findViewById(R.id.txt_firstname_parties);
        txt_lastname_parties  = findViewById(R.id.txt_lastname_parties);
        txt_idnumber_parties  = findViewById(R.id.txt_idnumber_parties);
        witness_firstname = findViewById(R.id.witness_firstname);
        witnerss_id = findViewById(R.id.witnerss_id);
        last_name_witness = findViewById(R.id.last_name_witness);


    }


}