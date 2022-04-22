package com.tolgacobanoglu.admincentralcarpolicy.database;

import android.content.Context;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.tolgacobanoglu.admincentralcarpolicy.model.LicensePlate;
import com.tolgacobanoglu.admincentralcarpolicy.model.RemovedLicensePlate;

public class Read
{

    private FirebaseFirestore database;

    public void getLicensePlateAndUpdateToTransferSecondHand(Context context, String cityCode, String letterGroup, String digitGroup, String newCityCode, String newLetterGroup, String newDigitGroup, String newOwnerName, String newOwnerSurname)
    {
        try
        {
            database = FirebaseFirestore.getInstance();

            DocumentReference docRef = database.collection("LicensePlates").document(cityCode+letterGroup+digitGroup);

            docRef.get().addOnSuccessListener(documentSnapshot -> {
                LicensePlate existLicensePlate;
                try {
                    existLicensePlate = documentSnapshot.toObject(LicensePlate.class);
                    LicensePlate newLicensePlate = null;
                    if (existLicensePlate != null) {
                        newLicensePlate = new LicensePlate(newOwnerName,newOwnerSurname,newCityCode,newLetterGroup,newDigitGroup,existLicensePlate.getChassisNumber(),existLicensePlate.getDamageCosts(),existLicensePlate.getDamageDetails(),existLicensePlate.getKilometers(),existLicensePlate.getModel(),existLicensePlate.getModelYear(),existLicensePlate.getOperations(),existLicensePlate.getExpertReport());
                    }
                    Delete databaseOperations = new Delete();
                    databaseOperations.deleteLicensePlate(context,cityCode,letterGroup,digitGroup);
                    Create databaseOperations2 = new Create();
                    databaseOperations2.newLicensePlate(context,newLicensePlate);
                    System.out.println(existLicensePlate);
                    Toast.makeText(context, "Update is successful!", Toast.LENGTH_SHORT).show();
                    RemovedLicensePlate removedLicensePlate = new RemovedLicensePlate(cityCode,letterGroup,digitGroup);
                    databaseOperations2.newRemovedLicensePlate(context,removedLicensePlate);
                }catch (Exception e)
                {
                    e.printStackTrace();
                    Toast.makeText(context, "Probably Your entered license plate does not exist,check again", Toast.LENGTH_LONG).show();
                }
            }).addOnFailureListener(e -> {
                e.printStackTrace();
                Toast.makeText(context, "Probably Your entered license plate does not exist,check again", Toast.LENGTH_SHORT).show();
            });
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(context, "Unsuccessfully transaction, try again!", Toast.LENGTH_LONG).show();
        }
    }


}
