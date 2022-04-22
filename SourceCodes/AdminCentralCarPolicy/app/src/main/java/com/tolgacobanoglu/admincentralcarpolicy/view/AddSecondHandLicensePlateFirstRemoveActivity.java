package com.tolgacobanoglu.admincentralcarpolicy.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tolgacobanoglu.admincentralcarpolicy.databinding.ActivityAddSecondHandLicensePlateFirstRemoveBinding;
import com.tolgacobanoglu.admincentralcarpolicy.regex.LicensePlateInputs;

import java.util.Locale;


public class AddSecondHandLicensePlateFirstRemoveActivity extends AppCompatActivity
{
    private ActivityAddSecondHandLicensePlateFirstRemoveBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddSecondHandLicensePlateFirstRemoveBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    public void moveDataAndGoSecondAdd(View view)
    {
        String cityCode = binding.cityCodeInput.getText().toString();
        String letterGroup = binding.letterGroupInput.getText().toString().toUpperCase(Locale.ROOT);
        String digitGroup = binding.digitGroupInput.getText().toString();

        LicensePlateInputs validator = new LicensePlateInputs();

        if (validator.checkCityCodeWithoutLicensePlate(cityCode))
        {
            if (validator.checkLetterGroupWithoutLicensePlate(letterGroup))
            {
                if (validator.checkDigitGroupWithoutLicensePlate(digitGroup))
                {
                    Intent intent = new Intent(AddSecondHandLicensePlateFirstRemoveActivity.this,AddSecondHandLicensePlateSecondAddActivity.class);
                    intent.putExtra("cityCode",cityCode);
                    intent.putExtra("letterGroup",letterGroup);
                    intent.putExtra("digitGroup",digitGroup);
                    //diğer sayfaya geçtiğimizde tüm sayfaları kapatıp sadece MainActivity bırakacağız
                    startActivity(intent);
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

}