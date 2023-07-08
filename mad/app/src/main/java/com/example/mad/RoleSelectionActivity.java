package com.example.mad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RoleSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_selection);

        Button studentButton = findViewById(R.id.studentButton);
        Button securityButton = findViewById(R.id.securityButton);

        studentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Proceed to the list of parking areas for students
                Intent intent = new Intent(RoleSelectionActivity.this, StudentMainActivity.class);
                startActivity(intent);
                finish(); // Optional: Prevent going back to the role selection screen
            }
        });

        securityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Transition to the login screen for security guards
                Intent intent = new Intent(RoleSelectionActivity.this, SecurityLoginActivity.class);
                startActivity(intent);
                finish(); // Optional: Prevent going back to the role selection screen
            }
        });
    }
}
