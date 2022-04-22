package com.tolgacobanoglu.carservicecentralcarpolicy.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tolgacobanoglu.carservicecentralcarpolicy.R;


public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void signInOnClick(View view)
    {
        Intent intent = new Intent(MainActivity.this,SignInActivity.class);
        startActivity(intent);
    }

    public void signUpOnClick(View view)
    {
        Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
        startActivity(intent);
    }

}