package com.tolgacobanoglu.carservicecentralcarpolicy.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.tolgacobanoglu.carservicecentralcarpolicy.crypto.SHA256;
import com.tolgacobanoglu.carservicecentralcarpolicy.database.Create;
import com.tolgacobanoglu.carservicecentralcarpolicy.database.entity.User;
import com.tolgacobanoglu.carservicecentralcarpolicy.databinding.ActivitySignUpBinding;
import com.tolgacobanoglu.carservicecentralcarpolicy.regex.SignUpValidator;

import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class SignUpActivity extends AppCompatActivity
{

    private ActivitySignUpBinding binding;
    private FirebaseAuth auth;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        auth = FirebaseAuth.getInstance();
    }

    public void signUpToSystem(View view) throws NoSuchAlgorithmException
    {
        String email = binding.emailInput.getText().toString();
        String companyName = binding.companyNameInput.getText().toString().toUpperCase(Locale.ROOT);
        String password = binding.passwordInput.getText().toString();
        String companyAddress = binding.companyAddressInput.getText().toString().toUpperCase(Locale.ROOT);
        String phone = binding.phoneInput.getText().toString();

        SignUpValidator validator = new SignUpValidator();

        if (validator.checkMail(email))
        {
            if (validator.checkCompanyName(companyName))
            {
                    if (validator.checkPhone(phone))
                    {
                        String hashedPassword = SHA256.hashString(binding.passwordInput.getText().toString());
                        User user = new User(email,companyName,companyAddress,hashedPassword,phone);
                        Create create = new Create();
                        create.newUser(user);
                        auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(authResult -> {
                            currentUser = auth.getCurrentUser();
                            if (currentUser != null) {
                                currentUser.sendEmailVerification();
                            }
                            Toast.makeText(SignUpActivity.this, "Sign up is valid, you must verify email now!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                            finish();
                            startActivity(intent);
                        }).addOnFailureListener(e -> Toast.makeText(SignUpActivity.this, "Sign up is failed", Toast.LENGTH_SHORT).show());
                    }
                    else
                    {
                        Toast.makeText(this, "Invalid phone", Toast.LENGTH_SHORT).show();
                    }
            }
            else
            {
                Toast.makeText(this, "Invalid company name", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this, "Invalid email", Toast.LENGTH_SHORT).show();
        }

    }


}