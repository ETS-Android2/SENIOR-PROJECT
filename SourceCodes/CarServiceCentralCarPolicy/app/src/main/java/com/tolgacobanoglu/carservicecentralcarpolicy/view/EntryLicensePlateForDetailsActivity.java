package com.tolgacobanoglu.carservicecentralcarpolicy.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tolgacobanoglu.carservicecentralcarpolicy.databinding.ActivityEntryLicensePlateForDetailsBinding;
import com.tolgacobanoglu.carservicecentralcarpolicy.regex.LicensePlateValidator;

import java.util.Locale;

public class EntryLicensePlateForDetailsActivity extends AppCompatActivity
{

    private ActivityEntryLicensePlateForDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = ActivityEntryLicensePlateForDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    public void goToDetailsQueryResultPage(View view)
    {
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
                    Intent intent = new Intent(EntryLicensePlateForDetailsActivity.this,ResultPageToCarDetailsQueryActivity.class);
                    intent.putExtra("cityCode",cityCode);
                    intent.putExtra("letterGroup",letterGroup);
                    intent.putExtra("digitGroup",digitGroup);
                    finish();
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(EntryLicensePlateForDetailsActivity.this, "Invalid letter group!!", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(EntryLicensePlateForDetailsActivity.this, "Invalid digit group!!", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(EntryLicensePlateForDetailsActivity.this, "Invalid city code!!", Toast.LENGTH_SHORT).show();
        }

    }


}