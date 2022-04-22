package com.tolgacobanoglu.admincentralcarpolicy.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tolgacobanoglu.admincentralcarpolicy.R;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addNewLicensePlate(View view)
    {
        Intent intentToAddNewLicensePlateActivity = new Intent(MainActivity.this, AddLicensePlateChooseActivity.class);
        startActivity(intentToAddNewLicensePlateActivity);
    }

    public void removeLicensePlate(View view)
    {
        Intent intentToAddNewLicensePlateActivity = new Intent(MainActivity.this, RemoveLicensePlateActivity.class);
        startActivity(intentToAddNewLicensePlateActivity);
    }

    public void viewTransactions(View view)
    {
        Intent intentToTransactionActivity = new Intent(MainActivity.this,TransactionActivity.class);
        startActivity(intentToTransactionActivity);
    }

    public void viewFeedbacks(View view)
    {
        Intent intent = new Intent(MainActivity.this,FeedBackActivity.class);
        startActivity(intent);
    }



}