package com.tolgacobanoglu.carservicecentralcarpolicy.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tolgacobanoglu.carservicecentralcarpolicy.databinding.ActivityEntryLicensePlateForExpertBinding;
import com.tolgacobanoglu.carservicecentralcarpolicy.regex.LicensePlateValidator;

import java.util.Locale;

public class EntryLicensePlateForExpertActivity extends AppCompatActivity {

    private ActivityEntryLicensePlateForExpertBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEntryLicensePlateForExpertBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.button2.setOnClickListener(v -> {
            LicensePlateValidator validator = new LicensePlateValidator();
            String cityCode = binding.cityCodeInput.getText().toString();
            String letterGroup = binding.letterGroupInput.getText().toString().toUpperCase(Locale.ROOT);
            String digitGroup = binding.digitGroupInput.getText().toString();

            if (validator.checkCityCodeWithoutLicensePlate(cityCode))
            {
                if (validator.checkDigitGroupWithoutLicensePlate(digitGroup))
                {
                    if (validator.checkLetterGroupWithoutLicensePlate(letterGroup))
                    {
                        Intent intent = new Intent(EntryLicensePlateForExpertActivity.this,ExpertDetailsPageActivity.class);
                        intent.putExtra("cityCode",cityCode);
                        intent.putExtra("letterGroup",letterGroup);
                        intent.putExtra("digitGroup",digitGroup);
                        finish();
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(EntryLicensePlateForExpertActivity.this, "Invalid letter group!!", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(EntryLicensePlateForExpertActivity.this, "Invalid digit group!!", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(EntryLicensePlateForExpertActivity.this, "Invalid city code!!", Toast.LENGTH_SHORT).show();
            }


        });

    }
}