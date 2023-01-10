package com.umak.heronsconduct.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.umak.heronsconduct.R;

import java.util.ArrayList;

public class AdminStatisticsStudentReports extends AppCompatActivity {

    BarChart barChart2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_statistics_student_reports);

        //Assign variable
        barChart2 = findViewById(R.id.bar_chart2);

        //Initialize arraylist
        ArrayList<BarEntry> barEntries = new ArrayList<>();

        //Use for loop
        for (int i = 1; i < 10; i++) {
            //Convert to float
            float value = (float) (i * 10.0);

            //Initialize pie chart entry
            BarEntry barEntry = new BarEntry(i, value);

            barEntries.add(barEntry);
        }

        //Initialize pie data set
        BarDataSet barDataSet = new BarDataSet(barEntries, "Student");
        //Set colors
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        //Hide draw value
        barDataSet.setDrawValues(false);

        //Set bar data
        barChart2.setData(new BarData(barDataSet));
        //Set animation
        barChart2.animateY(5000);
        //Hide description
        barChart2.getDescription().setText("Student Reports");
        barChart2.getDescription().setTextColor(Color.BLUE);



    }



}