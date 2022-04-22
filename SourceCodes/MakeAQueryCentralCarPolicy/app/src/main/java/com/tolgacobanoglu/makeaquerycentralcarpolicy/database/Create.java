package com.tolgacobanoglu.makeaquerycentralcarpolicy.database;

import android.content.Context;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.tolgacobanoglu.makeaquerycentralcarpolicy.model.Feedback;
import com.tolgacobanoglu.makeaquerycentralcarpolicy.model.Transaction;

import java.util.HashMap;
import java.util.Map;

public class Create
{
    private FirebaseFirestore database;

    public Create()
    {
    }

    public void addNewFeedBack(Feedback feedback, Context context)
    {
        try
        {
            database = FirebaseFirestore.getInstance();

            Map<String, Object> data = new HashMap<>();
            data.put("email",feedback.getEmail());
            data.put("time",feedback.getTime());
            data.put("content",feedback.getFeedback());

            Transaction transaction = new Transaction(feedback.getFeedback());
            database.collection("Transactions").add(transaction);

            database.collection("FeedBacks").add(data);
            Toast.makeText(context, "Thanks for feedback!!", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            Toast.makeText(context, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}
