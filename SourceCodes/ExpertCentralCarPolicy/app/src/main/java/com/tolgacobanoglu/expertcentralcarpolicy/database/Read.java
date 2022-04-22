package com.tolgacobanoglu.expertcentralcarpolicy.database;

import android.content.Context;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.tolgacobanoglu.expertcentralcarpolicy.database.entity.LicensePlate;
import com.tolgacobanoglu.expertcentralcarpolicy.database.entity.User;
import com.tolgacobanoglu.expertcentralcarpolicy.database.locale.Storage;

public class Read
{
    private FirebaseFirestore database;

    public void getUser(String email,Context context)
    {
        try {
            database = FirebaseFirestore.getInstance();
            DocumentReference docRef = database.collection("Users").document(email);

            docRef.get().addOnSuccessListener(documentSnapshot -> {
                User user = documentSnapshot.toObject(User.class); //database object
                if (user != null)
                {
                    Storage.setDefaults("companyName",user.getCompanyName(),context);
                    Storage.setDefaults("status",user.getStatus(),context);
                }
            }).addOnFailureListener(Throwable::printStackTrace);
        }
        catch (Exception e)
        {
            Toast.makeText(context, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    public void getLicensePlateAndUpdate(Context context,String cityCode, String letterGroup, String digitGroup, int kilometers, String operations, String damageDetails, Double damageCosts) //it reads from database and change the local instance of variable
    {
        try
        {
            database = FirebaseFirestore.getInstance();
            DocumentReference docRef = database.collection("LicensePlates").document(cityCode+letterGroup+digitGroup);

            docRef.get().addOnSuccessListener(documentSnapshot -> {
                LicensePlate licensePlate = documentSnapshot.toObject(LicensePlate.class); //database object
                if (licensePlate != null)
                {
                    Update update = new Update();
                    update.updateCarAfterService(context,cityCode,letterGroup,digitGroup, licensePlate.getOperations(),operations, licensePlate.getDamageDetails(), damageDetails, licensePlate.getDamageCosts(),damageCosts,kilometers);
                    Toast.makeText(context, "Successfully updated!!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(context,"This license plate does not exist!!", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(Throwable::printStackTrace);
        }
        catch (Exception e)
        {
            Toast.makeText(context, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
    }



}