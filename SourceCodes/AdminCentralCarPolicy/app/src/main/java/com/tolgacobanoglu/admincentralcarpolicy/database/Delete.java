package com.tolgacobanoglu.admincentralcarpolicy.database;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;


import com.google.firebase.firestore.FirebaseFirestore;
import com.tolgacobanoglu.admincentralcarpolicy.model.Transaction;

public class Delete
{
    private FirebaseFirestore database;

    public void deleteUser(Context context,String username)
    {
        try {
            database = FirebaseFirestore.getInstance();
            database.collection("Users").document(username)
                    .delete()
                    .addOnSuccessListener(aVoid -> Log.d(TAG, "DocumentSnapshot successfully deleted!"))
                    .addOnFailureListener(e -> Log.w(TAG, "Error deleting document", e));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(context, "Unsuccessfully transaction, try again!", Toast.LENGTH_LONG).show();
        }

    }


    public void deleteLicensePlate(Context context,String cityCode, String letterGroup, String digitGroup)
    {
        try
        {
            database = FirebaseFirestore.getInstance();
            database.collection("LicensePlates").document(cityCode+letterGroup+digitGroup)
                    .delete()
                    .addOnSuccessListener(aVoid -> Log.d(TAG, "DocumentSnapshot successfully deleted!"))
                    .addOnFailureListener(e -> Log.w(TAG, "Error deleting document", e));
            Create create = new Create();
            Transaction transaction = new Transaction("Remove License Plate",cityCode+letterGroup+digitGroup+" delete to database for transfer second hand");
            create.newTransaction(transaction);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(context, "Unsuccessfully transaction, try again!", Toast.LENGTH_LONG).show();
        }


    }

    public void deleteLicensePlateWithDescription(Context context,String cityCode, String letterGroup, String digitGroup,String description)
    {
        try
        {
            database = FirebaseFirestore.getInstance();
            database.collection("LicensePlates").document(cityCode+letterGroup+digitGroup)
                    .delete()
                    .addOnSuccessListener(aVoid -> Log.d(TAG, "DocumentSnapshot successfully deleted!"))
                    .addOnFailureListener(e -> Log.w(TAG, "Error deleting document", e));
            Create create = new Create();
            Transaction transaction = new Transaction("Remove License Plate",cityCode+letterGroup+digitGroup+" delete to database for "+description);
            create.newTransaction(transaction);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(context, "Unsuccessfully transaction, try again!", Toast.LENGTH_LONG).show();
        }


    }
}
