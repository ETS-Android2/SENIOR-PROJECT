package com.tolgacobanoglu.carservicecentralcarpolicy.database;

import android.content.Context;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.tolgacobanoglu.carservicecentralcarpolicy.database.locale.Storage;
import com.tolgacobanoglu.carservicecentralcarpolicy.model.Transaction;

public class Update
{
    private FirebaseFirestore database;

    public void updateCarAfterService(Context context, String cityCode, String letterGroup, String digitGroup, String exOperations, String newOperation, String exDamageDetails,String newDamageDetails , Double exDamageCost, Double currentDamageCost , int newKilometer)
    {
        database = FirebaseFirestore.getInstance();
        try
        {
            database.collection("LicensePlates").document(cityCode+letterGroup+digitGroup).update("operations",exOperations+ "|" + newOperation);
            database.collection("LicensePlates").document(cityCode+letterGroup+digitGroup).update("damageDetails",exDamageDetails + "|" + newDamageDetails);
            database.collection("LicensePlates").document(cityCode+letterGroup+digitGroup).update("damageCosts",exDamageCost+currentDamageCost);
            database.collection("LicensePlates").document(cityCode+letterGroup+digitGroup).update("kilometers",newKilometer);

            Transaction transaction = new Transaction("New Service Record", Storage.getDefaults("companyName",context) + " created new record for "+cityCode+letterGroup+digitGroup);
            Create create = new Create();
            create.newTransaction(transaction);
        }
        catch (Exception e)
        {
            Toast.makeText(context, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}
