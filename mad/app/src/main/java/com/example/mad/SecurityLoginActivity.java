package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class SecurityLoginActivity extends AppCompatActivity {
    private EditText usernameEditText, passwordEditText;
    private Button loginButton;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_login);

        firebaseAuth = FirebaseAuth.getInstance();

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredUsername = usernameEditText.getText().toString().trim();
                String enteredPassword = passwordEditText.getText().toString().trim();

                // Authenticate the user using Firebase Authentication
                firebaseAuth.signInWithEmailAndPassword(enteredUsername, enteredPassword)
                        .addOnCompleteListener(SecurityLoginActivity.this, task -> {
                            if (task.isSuccessful()) {
                                // Successful login
                                Toast.makeText(SecurityLoginActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();

                                // Transition to the main screen for security guards
                                Intent intent = new Intent(SecurityLoginActivity.this, SecurityMainActivity.class);
                                startActivity(intent);
                                finish(); // Prevent the user from going back to the login screen
                            } else {
                                // Invalid credentials
                                try {
                                    throw task.getException();
                                } catch (FirebaseAuthInvalidUserException invalidUserException) {
                                    Toast.makeText(SecurityLoginActivity.this, "Invalid email address", Toast.LENGTH_SHORT).show();
                                } catch (FirebaseAuthInvalidCredentialsException invalidCredentialsException) {
                                    Toast.makeText(SecurityLoginActivity.this, "Invalid password", Toast.LENGTH_SHORT).show();
                                } catch (Exception e) {
                                    Toast.makeText(SecurityLoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
    public void onBackPressed() {

        Intent intent = new Intent(SecurityLoginActivity.this, RoleSelectionActivity.class);
        startActivity(intent);

        // Finish the current activity
        finish();
    }
}


