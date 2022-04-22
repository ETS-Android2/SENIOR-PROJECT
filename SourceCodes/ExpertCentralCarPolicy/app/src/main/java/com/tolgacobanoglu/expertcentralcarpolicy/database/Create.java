package com.tolgacobanoglu.expertcentralcarpolicy.database;

import com.google.firebase.firestore.FirebaseFirestore;
import com.tolgacobanoglu.expertcentralcarpolicy.database.entity.User;
import com.tolgacobanoglu.expertcentralcarpolicy.model.Transaction;

import java.util.HashMap;
import java.util.Map;

public class Create
{
    private FirebaseFirestore database;

    public void newUser(User user)
    {
        try
        {
            database = FirebaseFirestore.getInstance();
            database.collection("Users").document(user.getEmail()).set(user);
            Transaction transaction = new Transaction(user.getCompanyName()+" is enroll system with "+user.getEmail());
            this.newTransaction(transaction);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void newTransaction(Transaction transaction)
    {
        try {
            database = FirebaseFirestore.getInstance();

            Map<String, Object> data = new HashMap<>();
            data.put("time", transaction.getTime());
            data.put("title", transaction.getTitle());
            data.put("content", transaction.getContent());

            database.collection("Transactions").add(data);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
