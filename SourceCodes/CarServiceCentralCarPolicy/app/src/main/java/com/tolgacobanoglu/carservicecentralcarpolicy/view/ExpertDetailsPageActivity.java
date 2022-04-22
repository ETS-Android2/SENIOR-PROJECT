package com.tolgacobanoglu.carservicecentralcarpolicy.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.tolgacobanoglu.carservicecentralcarpolicy.Utils;
import com.tolgacobanoglu.carservicecentralcarpolicy.database.entity.LicensePlate;
import com.tolgacobanoglu.carservicecentralcarpolicy.databinding.ActivityExpertDetailsPageBinding;

import java.util.HashMap;
import java.util.Map;

public class ExpertDetailsPageActivity extends AppCompatActivity {

    private ActivityExpertDetailsPageBinding binding;
    private FirebaseFirestore database;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = ActivityExpertDetailsPageBinding.inflate(getLayoutInflater());
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
                String reportsAsString = licensePlate.getExpertReport();
                Map<String,String> report = new HashMap<String, String>();
                report = Utils.stringToMap(reportsAsString);

                binding.bonnetOutput.setText(report.get("bonnet"));
                binding.frontBumperOutput.setText(report.get("frontBumper"));
                binding.rearBumperOutput.setText(report.get("rearBumper"));
                binding.leftFrontDoorOutput.setText(report.get("leftFrontDoor"));
                binding.leftBackDoorOutput.setText(report.get("leftBackDoor"));
                binding.rightBackDoorOutput.setText(report.get("rightBackDoor"));
                binding.rightFrontDoorOutput.setText(report.get("rightFrontDoor"));
                binding.baggageOutput.setText(report.get("baggage"));
                binding.roofOutput.setText(report.get("roof"));
                binding.rightMirrorOutput.setText(report.get("rightMirror"));
                binding.leftMirrorOutput.setText(report.get("leftMirror"));
                binding.airConditionsOutput.setText(report.get("airConditions"));
                binding.steeringWheelOutput.setText(report.get("steeringWheel"));
                binding.carUpholsteryOutput.setText(report.get("carUpholstery"));
                binding.headlinerOutput.setText(report.get("headliner"));
                binding.airbagOutput.setText(report.get("airbag"));

            }
            else
            {
                Toast.makeText(ExpertDetailsPageActivity.this, "There is not exist car like this license plate", Toast.LENGTH_SHORT).show();
            }

        }).addOnFailureListener(e -> Toast.makeText(ExpertDetailsPageActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show());



    }
}