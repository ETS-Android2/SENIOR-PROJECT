package com.tolgacobanoglu.carservicecentralcarpolicy.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.tolgacobanoglu.carservicecentralcarpolicy.databinding.ActivityResultPageToCarDetailsQueryBinding;
import com.tolgacobanoglu.carservicecentralcarpolicy.database.entity.LicensePlate;

public class ResultPageToCarDetailsQueryActivity extends AppCompatActivity
{

    private FirebaseFirestore database;
    private ActivityResultPageToCarDetailsQueryBinding binding;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = ActivityResultPageToCarDetailsQueryBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        String cityCode = getIntent().getStringExtra("cityCode");
        String letterGroup = getIntent().getStringExtra("letterGroup");
        String digitGroup = getIntent().getStringExtra("digitGroup");


        database = FirebaseFirestore.getInstance();


        DocumentReference docRef = database.collection("LicensePlates").document(cityCode+letterGroup+digitGroup);
        docRef.get().addOnSuccessListener(documentSnapshot -> {
            LicensePlate licensePlate = documentSnapshot.toObject(LicensePlate.class);
            if (licensePlate != null)
            {
                binding.allPlate.setText(cityCode+" "+letterGroup+" "+digitGroup);
                binding.modelOutput.setText(licensePlate.getModel());
                binding.yearOutput.setText(licensePlate.getModelYear());
                binding.kmOutput.setText(String.valueOf(licensePlate.getKilometers()));
                binding.damageCostOutput.setText(String.valueOf(licensePlate.getDamageCosts()));
                licensePlate.setDamageDetails(licensePlate.getDamageDetails().substring(2));
                licensePlate.setDamageDetails(licensePlate.getDamageDetails().replace('|','\n'));
                binding.damageDetailsOutput.setText(licensePlate.getDamageDetails());
                licensePlate.setOperations(licensePlate.getOperations().substring(2));
                licensePlate.setOperations(licensePlate.getOperations().replace('|','\n'));
                binding.operationsOutput.setText(licensePlate.getOperations());
            }
            else
            {
                Toast.makeText(ResultPageToCarDetailsQueryActivity.this, "There is not exist car like this license plate", Toast.LENGTH_SHORT).show();
            }

        }).addOnFailureListener(e -> Toast.makeText(ResultPageToCarDetailsQueryActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show());


    }
}