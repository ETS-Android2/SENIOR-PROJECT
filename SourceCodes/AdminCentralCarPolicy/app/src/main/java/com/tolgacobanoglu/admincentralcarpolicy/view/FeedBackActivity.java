package com.tolgacobanoglu.admincentralcarpolicy.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.tolgacobanoglu.admincentralcarpolicy.R;
import com.tolgacobanoglu.admincentralcarpolicy.adapter.FeedbackRecyclerAdapter;
import com.tolgacobanoglu.admincentralcarpolicy.model.Feedback;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FeedBackActivity extends AppCompatActivity {

    private FirebaseFirestore database;
    private RecyclerView recyclerView;
    private FeedbackRecyclerAdapter feedbackRecyclerAdapter;
    private List<Feedback> feedbackList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);

        database = FirebaseFirestore.getInstance();
        recyclerView = findViewById(R.id.feedbackRecycler);
        feedbackList = new ArrayList<>();

        getDataFromDatabase();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        feedbackRecyclerAdapter = new FeedbackRecyclerAdapter(feedbackList);
        recyclerView.setAdapter(feedbackRecyclerAdapter);

    }



    public void getDataFromDatabase()
    {
        CollectionReference collectionReference = database.collection("FeedBacks");
        collectionReference.orderBy("time", Query.Direction.DESCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {

                if (e != null) {
                    Toast.makeText(FeedBackActivity.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }

                if (queryDocumentSnapshots != null) {

                    for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()) {

                        Map<String,Object> data = snapshot.getData();

                        //Casting
                        Timestamp time = (Timestamp) data.get("time");
                        String sFeedback = (String) data.get("content");
                        String email = (String) data.get("email");


                        Feedback feedback = new Feedback(time,email,sFeedback);

                        feedbackList.add(feedback);

                    }
                    feedbackRecyclerAdapter.notifyDataSetChanged();

                }

            }
        });


    }
}