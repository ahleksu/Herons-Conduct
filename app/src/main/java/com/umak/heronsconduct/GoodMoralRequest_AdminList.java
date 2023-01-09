package com.umak.heronsconduct;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class GoodMoralRequest_AdminList extends AppCompatActivity {
    private ArrayList<GoodMoralRequest_AdminUser> usersList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_moral_request_admin_list);
        recyclerView = findViewById(R.id.goodMoralRecyclerView);
        usersList = new ArrayList<>();

        setUserInfo();
        setAdapter();

    }

    private void setAdapter() {
        GoodMoralRequest_AdminRecyclerAdapter adapter = new GoodMoralRequest_AdminRecyclerAdapter(usersList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

    }

    private void setUserInfo() {
        usersList.add(new GoodMoralRequest_AdminUser("Howard","hbayquen.UmakEmail","CCIS","1-7-2023", "2am"));
        usersList.add(new GoodMoralRequest_AdminUser("Howard","hbayquen.UmakEmail","CCIS","1-7-2023", "2am"));
        usersList.add(new GoodMoralRequest_AdminUser("Howard","hbayquen.UmakEmail","CCIS","1-7-2023", "2am"));
        usersList.add(new GoodMoralRequest_AdminUser("Howard","hbayquen.UmakEmail","CCIS","1-7-2023", "2am"));
        usersList.add(new GoodMoralRequest_AdminUser("Howard","hbayquen.UmakEmail","CCIS","1-7-2023", "2am"));
        usersList.add(new GoodMoralRequest_AdminUser("Howard","hbayquen.UmakEmail","CCIS","1-7-2023", "2am"));
        usersList.add(new GoodMoralRequest_AdminUser("Howard","hbayquen.UmakEmail","CCIS","1-7-2023", "2am"));
    }
}