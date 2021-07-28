package com.example.mad_mini_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class final_Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_);
        TextView to_display=findViewById(R.id.finaloutput);

        Bundle b=getIntent().getExtras();
        String text_to_display=b.getString("txt");
        //int count=Integer.parseInt(text_to_display);
        //if(count<10)
        to_display.setText(text_to_display);

    }
    public void home(View v)
    {
        Intent i=new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void exit(View v)
    {
        Toast.makeText(this, "Thank you for playing", Toast.LENGTH_SHORT).show();
        finishAffinity();
        //System.exit(0);
    }
}