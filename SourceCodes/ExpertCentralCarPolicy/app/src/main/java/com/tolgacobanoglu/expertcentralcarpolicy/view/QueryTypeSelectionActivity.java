package com.tolgacobanoglu.expertcentralcarpolicy.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tolgacobanoglu.expertcentralcarpolicy.R;

public class QueryTypeSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_type_selection);
    }

    public void goToDetailsPage(View view)
    {
        Intent intent = new Intent(QueryTypeSelectionActivity.this, EntryLicensePlateForDetailsActivity.class);
        finish();
        startActivity(intent);
    }

    public void goToExpertDetailsPage(View view)
    {
        Intent intent = new Intent(QueryTypeSelectionActivity.this, EntryLicensePlateForExpertActivity.class);
        finish();
        startActivity(intent);
    }

}