package com.tolgacobanoglu.makeaquerycentralcarpolicy.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.tolgacobanoglu.makeaquerycentralcarpolicy.R;
import com.tolgacobanoglu.makeaquerycentralcarpolicy.database.Create;
import com.tolgacobanoglu.makeaquerycentralcarpolicy.databinding.ActivityFeedBackBinding;
import com.tolgacobanoglu.makeaquerycentralcarpolicy.model.Feedback;

public class FeedBackActivity extends AppCompatActivity {

    private ActivityFeedBackBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFeedBackBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

    }

    public void sendFeedback(View view)
    {
        String email = binding.emailText.getText().toString();
        String description = binding.descriptionText.getText().toString();

        Feedback feedback = new Feedback(email,description);
        Create create = new Create();
        create.addNewFeedBack(feedback,FeedBackActivity.this);
        finish();

    }

}