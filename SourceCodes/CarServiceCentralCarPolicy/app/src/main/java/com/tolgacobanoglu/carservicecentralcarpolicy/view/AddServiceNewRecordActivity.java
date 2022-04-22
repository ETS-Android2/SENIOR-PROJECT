package com.tolgacobanoglu.carservicecentralcarpolicy.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tolgacobanoglu.carservicecentralcarpolicy.database.Read;
import com.tolgacobanoglu.carservicecentralcarpolicy.databinding.ActivityAddServiceNewRecordBinding;
import com.tolgacobanoglu.carservicecentralcarpolicy.regex.LicensePlateValidator;

import java.util.Locale;


public class AddServiceNewRecordActivity extends AppCompatActivity {

    private ActivityAddServiceNewRecordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddServiceNewRecordBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

    }

    public void saveRecordOnClick(View view)
    {
        String cityCode = binding.cityCodeInput.getText().toString();
        String letterGroup = binding.letterGroupInput.getText().toString().toUpperCase(Locale.ROOT);
        String digitGroup = binding.digitGroupInput.getText().toString();
        int kilometer = Integer.parseInt(binding.kilometersInput.getText().toString());
        Double damageCost = Double.parseDouble(binding.damageCostInput.getText().toString());
        String damageDetails = binding.damageDetailsInput.getText().toString();
        String operations = binding.operationsInput.getText().toString();


        LicensePlateValidator validator = new LicensePlateValidator();

        if (validator.checkKilometers(kilometer))
        {
            if (validator.checkCityCodeWithoutLicensePlate(cityCode))
            {
                if (validator.checkDigitGroupWithoutLicensePlate(digitGroup))
                {
                    if (validator.checkLetterGroupWithoutLicensePlate(letterGroup))
                    {
                        if (validator.checkDamageCost(damageCost))
                        {
                            Read read = new Read();
                            read.getLicensePlateAndUpdate(getApplicationContext(),cityCode,letterGroup,digitGroup,kilometer,String.valueOf(damageCost)+"TL "+operations,damageDetails,damageCost);
                            Intent intent = new Intent(AddServiceNewRecordActivity.this,HomePageActivity.class);
                            finish();
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(AddServiceNewRecordActivity.this, "Invalid damage cost!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(AddServiceNewRecordActivity.this, "Invalid letter group!!", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(AddServiceNewRecordActivity.this, "Invalid digit group!!", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(AddServiceNewRecordActivity.this, "Invalid city code!!", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(AddServiceNewRecordActivity.this, "Invalid kilometer!!", Toast.LENGTH_SHORT).show();
        }



    }


}