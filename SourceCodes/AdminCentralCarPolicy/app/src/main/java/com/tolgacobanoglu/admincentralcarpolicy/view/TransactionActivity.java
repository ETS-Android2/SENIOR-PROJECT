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
import com.tolgacobanoglu.admincentralcarpolicy.adapter.TransactionRecyclerAdapter;
import com.tolgacobanoglu.admincentralcarpolicy.model.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TransactionActivity extends AppCompatActivity
{

    private FirebaseFirestore database;
    private RecyclerView recyclerView;
    private TransactionRecyclerAdapter transactionRecyclerAdapter;
    private List<Transaction> transactionList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        database = FirebaseFirestore.getInstance();
        recyclerView = findViewById(R.id.transactionRecyclerView);
        transactionList = new ArrayList<>();

        getDataFromDatabase();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        transactionRecyclerAdapter = new TransactionRecyclerAdapter(transactionList);
        recyclerView.setAdapter(transactionRecyclerAdapter);

    }



    public void getDataFromDatabase()
    {
        CollectionReference collectionReference = database.collection("Transactions");
        collectionReference.orderBy("time", Query.Direction.DESCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {

                if (e != null) {
                    Toast.makeText(TransactionActivity.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }

                if (queryDocumentSnapshots != null) {

                    for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()) {

                        Map<String,Object> data = snapshot.getData();

                        //Casting
                        Timestamp time = (Timestamp) data.get("time");
                        String content = (String) data.get("content");
                        String title = (String) data.get("title");

                        Transaction transaction = new Transaction(time,content,title);

                        transactionList.add(transaction);

                    }
                    transactionRecyclerAdapter.notifyDataSetChanged();

                }

            }
        });


    }
}