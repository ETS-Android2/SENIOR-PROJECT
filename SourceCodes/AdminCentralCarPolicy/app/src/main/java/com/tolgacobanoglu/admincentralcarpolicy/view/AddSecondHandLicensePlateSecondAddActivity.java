package com.tolgacobanoglu.admincentralcarpolicy.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tolgacobanoglu.admincentralcarpolicy.database.Create;
import com.tolgacobanoglu.admincentralcarpolicy.database.Read;
import com.tolgacobanoglu.admincentralcarpolicy.databinding.ActivityAddSecondHandLicensePlateSecondAddBinding;
import com.tolgacobanoglu.admincentralcarpolicy.model.Transaction;
import com.tolgacobanoglu.admincentralcarpolicy.regex.LicensePlateInputs;

import java.util.Locale;

public class AddSecondHandLicensePlateSecondAddActivity extends AppCompatActivity
{

    private ActivityAddSecondHandLicensePlateSecondAddBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = ActivityAddSecondHandLicensePlateSecondAddBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    public void saveToDatabase(View view)
    {

        String oldCityCode = getIntent().getStringExtra("cityCode");
        String oldLetterGroup = getIntent().getStringExtra("letterGroup");
        String oldDigitGroup = getIntent().getStringExtra("digitGroup");

        String newCityCode = binding.cityCodeInput.getText().toString();
        String newLetterGroup = binding.letterGroupInput.getText().toString().toUpperCase(Locale.ROOT);
        String newDigitGroup = binding.digitGroupInput.getText().toString();
        String newOwnerName = binding.nameInput.getText().toString().toUpperCase(Locale.ROOT);
        String newOwnerSurname = binding.surnameInput.getText().toString().toUpperCase(Locale.ROOT);


        LicensePlateInputs validator = new LicensePlateInputs();

        if (validator.checkCityCodeWithoutLicensePlate(oldCityCode))
       {
            if (validator.checkLetterGroupWithoutLicensePlate(oldLetterGroup))
            {
                if (validator.checkDigitGroupWithoutLicensePlate(oldDigitGroup))
                {
                    if (validator.checkCityCodeWithoutLicensePlate(newCityCode))
                    {
                        if (validator.checkLetterGroupWithoutLicensePlate(newLetterGroup))
                        {
                            if (validator.checkDigitGroupWithoutLicensePlate(newDigitGroup))
                            {
                                if (validator.checkNameWithoutLicensePlate(newOwnerName))
                                {
                                    if (validator.checkSurnameWithoutLicensePlate(newOwnerSurname))
                                    {
                                        Read read = new Read();
                                        read.getLicensePlateAndUpdateToTransferSecondHand(AddSecondHandLicensePlateSecondAddActivity.this,oldCityCode,oldLetterGroup,oldDigitGroup,newCityCode,newLetterGroup,newDigitGroup,newOwnerName,newOwnerSurname);
                                        Create create = new Create();
                                        Transaction transaction = new Transaction("Create License Plate Second Hand",oldCityCode+oldLetterGroup+oldDigitGroup+" is removed "+newCityCode+newLetterGroup+newDigitGroup+" create to database");
                                        create.newTransaction(transaction); // there is two time log one is for second hand there is declaration for transfer second think is one more license plate is creating
                                        Intent intent = new Intent(AddSecondHandLicensePlateSecondAddActivity.this, MainActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        finish();
                                        startActivity(intent);
                                    }
                                    else
                                    {
                                        Toast.makeText(AddSecondHandLicensePlateSecondAddActivity.this, "Invalid Surname", Toast.LENGTH_LONG).show();
                                    }
                                }
                                else
                                {
                                    Toast.makeText(AddSecondHandLicensePlateSecondAddActivity.this, "Invalid Name", Toast.LENGTH_LONG).show();
                                }
                            }
                            else
                            {
                                Toast.makeText(AddSecondHandLicensePlateSecondAddActivity.this, "Invalid Digit Group", Toast.LENGTH_LONG).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(AddSecondHandLicensePlateSecondAddActivity.this, "Invalid Letter Group", Toast.LENGTH_LONG).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(AddSecondHandLicensePlateSecondAddActivity.this, "Invalid City Code", Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(AddSecondHandLicensePlateSecondAddActivity.this, "Previous page you did not entered valid Digit Group!!", Toast.LENGTH_LONG).show();
                }
            }
            else
            {
                Toast.makeText(AddSecondHandLicensePlateSecondAddActivity.this, "Previous page you did not entered valid Letter Group!!", Toast.LENGTH_LONG).show();
            }
       }
       else
       {
           Toast.makeText(AddSecondHandLicensePlateSecondAddActivity.this, "Previous page you did not entered valid City Code!!", Toast.LENGTH_LONG).show();
       }
    }
}