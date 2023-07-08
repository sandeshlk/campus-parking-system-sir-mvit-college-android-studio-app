package com.example.mad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mad.databinding.ActivitySecurityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SecurityMainActivity extends AppCompatActivity {


    Button btnInsert;
    databasehelper db2;
     Button  logoutButton;
   EditText availupdate,idupdate  ;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_main);

      availupdate=findViewById(R.id.updateavail);
      idupdate=findViewById(R.id.updateid);
        logoutButton = findViewById(R.id.logoutButton);

        btnInsert = findViewById(R.id.btinsert);
        db2 = new databasehelper(SecurityMainActivity.this,"Park", null,1);


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String avInput = availupdate.getText().toString();
                String idInput = idupdate.getText().toString();

                // Check if the inputs are not empty
                if (!avInput.isEmpty() && !idInput.isEmpty()) {
                    int av = Integer.parseInt(avInput);
                    int idd = Integer.parseInt(idInput);

                    int i = db2.WriteRecords(av, idd);
                    if (i == 0)
                        Toast.makeText(SecurityMainActivity.this, "Not updated", Toast.LENGTH_SHORT).show();
                    if (i == 1)
                        Toast.makeText(SecurityMainActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SecurityMainActivity.this, "Please enter valid inputs", Toast.LENGTH_SHORT).show();
                }
            }

        });
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecurityMainActivity.this, "Logout clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SecurityMainActivity.this, SecurityLoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }




    public void onBackPressed() {

        Intent intent = new Intent(SecurityMainActivity.this, SecurityLoginActivity.class);
        startActivity(intent);
        finish();
    }
}
