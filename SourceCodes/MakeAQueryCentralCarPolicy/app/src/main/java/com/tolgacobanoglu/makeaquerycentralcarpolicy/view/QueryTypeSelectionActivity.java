package com.tolgacobanoglu.makeaquerycentralcarpolicy.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;

import com.tolgacobanoglu.makeaquerycentralcarpolicy.R;

public class QueryTypeSelectionActivity extends AppCompatActivity {

    private Button button;
    private Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_type_selection);
        button = findViewById(R.id.button);
        button3 = findViewById(R.id.button3);
    }

    public void goToDetailsPage(View view)
    {
        Intent intent = new Intent(QueryTypeSelectionActivity.this, EntryLicensePlateForDetailsActivity.class);
        startActivity(intent);
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                button.setEnabled(false);
            }
            public void onFinish() {
                button.setEnabled(true);
            }
        }.start();
    }

        public void goToExpertDetailsPage(View view)
        {
            Intent intent = new Intent(QueryTypeSelectionActivity.this, EntryLicensePlateForExpertActivity.class);
            startActivity(intent);
            new CountDownTimer(30000, 1000) {

                public void onTick(long millisUntilFinished) {
                    button3.setEnabled(false);
                }
                public void onFinish() {
                    button3.setEnabled(true);
                }
            }.start();
        }

    public void giveFeedBack(View view)
    {
        Intent intent = new Intent(QueryTypeSelectionActivity.this,FeedBackActivity.class);
        startActivity(intent);
    }

}