package com.example.mad_mini_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class apifetch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apifetch);
        Bundle b = getIntent().getExtras();
        String cat = b.getString("cat");
        String dif = b.getString("dif");
        Toast.makeText(this, cat, Toast.LENGTH_SHORT).show();
    }
}