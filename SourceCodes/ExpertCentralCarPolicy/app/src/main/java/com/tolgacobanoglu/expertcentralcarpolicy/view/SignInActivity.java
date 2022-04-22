package com.tolgacobanoglu.expertcentralcarpolicy.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.tolgacobanoglu.expertcentralcarpolicy.database.Read;
import com.tolgacobanoglu.expertcentralcarpolicy.database.locale.Storage;
import com.tolgacobanoglu.expertcentralcarpolicy.databinding.ActivitySignInBinding;

public class SignInActivity extends AppCompatActivity
{
    private ActivitySignInBinding binding;
    private FirebaseAuth auth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        auth = FirebaseAuth.getInstance();

    }

    public void signInToSystem(View view)
    {
        String email = binding.emailInput.getText().toString();
        String password = binding.passwordInput.getText().toString();

        try
        {
            auth.signInWithEmailAndPassword(email,password).addOnSuccessListener(authResult -> {
                user = auth.getCurrentUser();

                if (user != null) {
                    if(user.isEmailVerified())
                    {
                        Read read = new Read();
                        read.getUser(email,SignInActivity.this);
                        String status = Storage.getDefaults("status",SignInActivity.this);

                        if (status.equals("expert"))
                        {
                            Intent intent = new Intent(SignInActivity.this,HomePageActivity.class);
                            finish();
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(this, "Unauthorized sign in operation!!", Toast.LENGTH_SHORT).show();
                        }


                    }
                    else
                    {
                        Toast.makeText(SignInActivity.this,"Email is not verified, check your email inbox!!",Toast.LENGTH_LONG).show();
                    }
                }
            }).addOnFailureListener(e -> Toast.makeText(SignInActivity.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}