package com.umak.heronsconduct.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.umak.heronsconduct.R;

import java.util.ArrayList;

public class AdminStatisticsIncidentReports extends AppCompatActivity {

    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_statistics_incident_reports);

        //Assign variable
        pieChart = findViewById(R.id.pie_chart);

        //Initialize arraylist
        ArrayList<PieEntry> pieEntries = new ArrayList<>();

        //Use for loop
        for (int i = 1; i < 10; i++){
            //Convert to float
            float value = (float) (i * 10.0);

            //Initialize pie chart entry
            PieEntry pieEntry = new PieEntry(i, value);

            pieEntries.add(pieEntry);

        }

        //Initialize pie data set
        PieDataSet pieDataSet = new PieDataSet(pieEntries, "Student");
        //Set colors
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        //Set pie data
        pieChart.setData(new PieData(pieDataSet));
        //Set animation
        pieChart.animateXY(5000, 5000);
        //Hide description
        pieChart.getDescription().setEnabled(false);


    }
}