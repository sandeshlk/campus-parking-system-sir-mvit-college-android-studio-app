package com.example.mad;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StudentMainActivity extends AppCompatActivity {

    databasehelper db;
    TextView e1,e2,e3,e4,e5,e6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_main);

        Button dir1 = findViewById(R.id.dir1);
        Button dir2 = findViewById(R.id.dir2);
        Button dir3 = findViewById(R.id.dir3);
        Button dir4 = findViewById(R.id.dir4);
        Button dir5 = findViewById(R.id.dir5);
        Button dir6 = findViewById(R.id.dir6);
       e1=findViewById(R.id.editText1);
         e2=findViewById(R.id.editText2);
        e3=findViewById(R.id.editText3);
         e4=findViewById(R.id.editText4);
         e5=findViewById(R.id.editText5);
        e6=findViewById(R.id.editText6);


        db = new databasehelper(StudentMainActivity.this,"Park", null,1);

        dir1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://maps.app.goo.gl/See5mLEBt6tf9v3v9";
                openWebUrl(url);
            }
        });

        dir2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://maps.app.goo.gl/KZzTRdZxddwK11aM8";
                openWebUrl(url);
            }
        });

        dir3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://maps.app.goo.gl/DUjTnq3SVrXuWEM4A";
                openWebUrl(url);
            }
        });

        dir4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://maps.app.goo.gl/ranE3foNpQsD93EF8";
                openWebUrl(url);
            }
        });

        dir5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://maps.app.goo.gl/8apfFmXtSm1MP81c9";
                openWebUrl(url);
            }
        });

        dir6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://maps.app.goo.gl/2mS63vY5YzPkptsn6";
                openWebUrl(url);
            }
        });

    }
    public void CheckAvail(View view)
    {
        int av = 0;
        int id = view.getId();
        if(id==R.id.avail1) {
            av = db.ReadRecords(1);
            e1.setText(""+av);
        }
        if(id==R.id.avail2) {
            av = db.ReadRecords(2);
            e2.setText(""+av);
        }
        if(id==R.id.avail3) {
        av = db.ReadRecords(3);
        e3.setText(""+av);
        }
        if(id==R.id.avail4) {
            av = db.ReadRecords(4);
            e4.setText(""+av);
        }
        if(id==R.id.avail5) {
            av = db.ReadRecords(5);
            e5.setText(""+av);
        }
        if(id==R.id.avail6) {
            av = db.ReadRecords(6);
            e6.setText(""+av);
        }

    }


    private void openWebUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
    public void onBackPressed() {
        Intent intent = new Intent(StudentMainActivity.this, RoleSelectionActivity.class);
        startActivity(intent);
        finish();
    }
}

