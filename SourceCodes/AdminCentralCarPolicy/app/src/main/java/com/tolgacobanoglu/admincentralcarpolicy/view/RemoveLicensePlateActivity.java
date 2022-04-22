package com.tolgacobanoglu.admincentralcarpolicy.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tolgacobanoglu.admincentralcarpolicy.database.Create;
import com.tolgacobanoglu.admincentralcarpolicy.database.Delete;
import com.tolgacobanoglu.admincentralcarpolicy.databinding.ActivityRemoveLicensePlateBinding;
import com.tolgacobanoglu.admincentralcarpolicy.model.RemovedLicensePlate;
import com.tolgacobanoglu.admincentralcarpolicy.regex.LicensePlateInputs;

import java.util.Locale;

public class RemoveLicensePlateActivity extends AppCompatActivity {

    private ActivityRemoveLicensePlateBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = ActivityRemoveLicensePlateBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    public void removeFromDatabase(View view)
    {
        String removedCityCode = binding.cityCodeInput.getText().toString().toUpperCase(Locale.ROOT);
        String removedLetterGroup = binding.letterGroupInput.getText().toString().toUpperCase(Locale.ROOT);
        String removedDigitGroup = binding.digitGroupInput.getText().toString().toUpperCase(Locale.ROOT);
        String description = binding.descriptionInput.getText().toString();

        LicensePlateInputs validator = new LicensePlateInputs();

        if (validator.checkCityCodeWithoutLicensePlate(removedCityCode))
        {
            if (validator.checkLetterGroupWithoutLicensePlate(removedLetterGroup))
            {
                if (validator.checkDigitGroupWithoutLicensePlate(removedDigitGroup))
                {
                    Delete delete = new Delete();
                    delete.deleteLicensePlateWithDescription(RemoveLicensePlateActivity.this,removedCityCode,removedLetterGroup,removedDigitGroup,description);
                    RemovedLicensePlate removedLicensePlate = new RemovedLicensePlate(removedCityCode,removedLetterGroup,removedDigitGroup);
                    Create create = new Create();
                    create.newRemovedLicensePlate(RemoveLicensePlateActivity.this,removedLicensePlate);
                    Toast.makeText(RemoveLicensePlateActivity.this, "License plate is removed!!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RemoveLicensePlateActivity.this,MainActivity.class);
                    finish();
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(RemoveLicensePlateActivity.this, "Invalid Digit Group", Toast.LENGTH_LONG).show();
                }
            }
            else
            {
                Toast.makeText(RemoveLicensePlateActivity.this, "Invalid Letter Group", Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(RemoveLicensePlateActivity.this, "Invalid City Code", Toast.LENGTH_LONG).show();
        }
    }



}