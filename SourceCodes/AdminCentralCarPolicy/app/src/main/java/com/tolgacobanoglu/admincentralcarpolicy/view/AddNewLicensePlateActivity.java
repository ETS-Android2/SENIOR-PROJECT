package com.tolgacobanoglu.admincentralcarpolicy.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tolgacobanoglu.admincentralcarpolicy.database.Create;
import com.tolgacobanoglu.admincentralcarpolicy.databinding.ActivityAddNewLicensePlateBinding;
import com.tolgacobanoglu.admincentralcarpolicy.model.LicensePlate;
import com.tolgacobanoglu.admincentralcarpolicy.model.Transaction;
import com.tolgacobanoglu.admincentralcarpolicy.regex.LicensePlateInputs;

import java.util.Locale;

public class AddNewLicensePlateActivity extends AppCompatActivity
{

    private ActivityAddNewLicensePlateBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = ActivityAddNewLicensePlateBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    public void saveToDatabaseClick(View view)
    {

        String ownerName = binding.nameInput.getText().toString().toUpperCase(Locale.ROOT);
        String ownerSurname = binding.surnameInput.getText().toString().toUpperCase(Locale.ROOT);
        String cityCode = binding.cityCodeInput.getText().toString();
        String letterGroup = binding.letterGroupInput.getText().toString().toUpperCase(Locale.ROOT);
        String digitGroup = binding.digitGroupInput.getText().toString();
        String chassisNumber = binding.chassisNumberInput.getText().toString();
        String model = binding.modelInput.getText().toString();
        String modelYear = binding.modelYearInput.getText().toString();


        LicensePlate licensePlate = new LicensePlate(ownerName,ownerSurname,cityCode,letterGroup,digitGroup,chassisNumber,0D,"-",0,model,modelYear,"-","-");
        LicensePlateInputs validator = new LicensePlateInputs(licensePlate);

        if (validator.checkName())
        {
            if (validator.checkSurname())
            {
                if (validator.checkCityCode())
                {
                    if (validator.checkLetterGroup())
                    {
                        if (validator.checkDigitGroup())
                        {
                            if (validator.checkChassisNumber())
                            {
                                if (validator.checkModelYear())
                                {
                                    Create create = new Create();
                                    create.newLicensePlate(AddNewLicensePlateActivity.this,licensePlate);
                                    Toast.makeText(this, "ADDED TO DATABASE", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(AddNewLicensePlateActivity.this,MainActivity.class);
                                    finish();
                                    startActivity(intent);
                                }
                                else
                                {
                                    Toast.makeText(this, "Invalid Model Year", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else
                            {
                                Toast.makeText(this, "Invalid Chassis number", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(this, "Invalid digit group!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(this, "Invalid letter group!", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(this, "Invalid city code!", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(this,"Invalid surname!",Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this, "Invalid name!", Toast.LENGTH_SHORT).show();
        }
    }



}