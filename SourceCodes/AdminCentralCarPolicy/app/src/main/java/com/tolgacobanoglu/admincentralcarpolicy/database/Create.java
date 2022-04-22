package com.tolgacobanoglu.admincentralcarpolicy.database;

import android.content.Context;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.tolgacobanoglu.admincentralcarpolicy.model.LicensePlate;
import com.tolgacobanoglu.admincentralcarpolicy.model.RemovedLicensePlate;
import com.tolgacobanoglu.admincentralcarpolicy.model.Transaction;

import java.util.HashMap;
import java.util.Map;

public class Create
{
    private FirebaseFirestore database;

    public void newLicensePlate(Context context,LicensePlate licensePlate)
    {
        try
        {
            database = FirebaseFirestore.getInstance();
            database.collection("LicensePlates").document(licensePlate.getCityCode()+licensePlate.getLetterGroup()+licensePlate.getDigitGroup()).set(licensePlate);

            Transaction transaction = new Transaction("Create License Plate",licensePlate.getCityCode()+licensePlate.getLetterGroup()+licensePlate.getDigitGroup()+" create to database");
            this.newTransaction(transaction);
        }catch (Exception e)
        {
            Toast.makeText(context, "Unsuccessfully create operation", Toast.LENGTH_SHORT).show();
        }
    }

    public void newRemovedLicensePlate(Context context, RemovedLicensePlate removedLicensePlate)
    {
        try
        {
            database = FirebaseFirestore.getInstance();
            Map<String, Object> data = new HashMap<>();
            data.put("cityCode",removedLicensePlate.getCityCode());
            data.put("letterGroup",removedLicensePlate.getLetterGroup());
            data.put("digitGroup",removedLicensePlate.getDigitGroup());
            data.put("time",removedLicensePlate.getTime());

            database.collection("RemovedLicensePlates").add(data);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void newTransaction(Transaction transaction)
    {
        try
        {
            database = FirebaseFirestore.getInstance();

            Map<String, Object> data = new HashMap<>();
            data.put("time",transaction.getTime());
            data.put("title",transaction.getTransactionTitle());
            data.put("content",transaction.getTransactionContent());

            database.collection("Transactions").add(data);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
