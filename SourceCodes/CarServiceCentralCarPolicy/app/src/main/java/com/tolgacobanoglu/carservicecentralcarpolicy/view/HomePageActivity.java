package com.tolgacobanoglu.carservicecentralcarpolicy.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tolgacobanoglu.carservicecentralcarpolicy.R;

public class HomePageActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    public void addNewReport(View view)
    {
        Intent intent = new Intent(HomePageActivity.this, AddServiceNewRecordActivity.class);
        startActivity(intent);
    }

    public void queryToLicensePlate(View view)
    {
        Intent intent = new Intent(HomePageActivity.this,QueryTypeSelectionActivity.class);
        startActivity(intent);
    }
}