package com.tolgacobanoglu.admincentralcarpolicy.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tolgacobanoglu.admincentralcarpolicy.R;

public class AddLicensePlateChooseActivity extends AppCompatActivity
{
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_license_plate_choose);
    }

    public void addNew(View view)
    {
        intent = new Intent(AddLicensePlateChooseActivity.this,AddNewLicensePlateActivity.class);
        finish();
        startActivity(intent);
    }

    public void secondHandTransfer(View view)
    {
        intent = new Intent(AddLicensePlateChooseActivity.this,AddSecondHandLicensePlateFirstRemoveActivity.class);
        finish();
        startActivity(intent);
    }

}