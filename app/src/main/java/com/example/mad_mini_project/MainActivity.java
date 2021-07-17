package com.example.mad_mini_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner myspinner =(Spinner) findViewById(R.id.spinner2);
        Spinner myspinner1 =(Spinner) findViewById(R.id.spinner3);


        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.names)

        );

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(myAdapter);








        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.names1)

        );

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner1.setAdapter(myAdapter1);






    }

    public void start(View v){
        Spinner myspinner =(Spinner) findViewById(R.id.spinner2);
        Spinner myspinner1 =(Spinner) findViewById(R.id.spinner3);

        String cat = myspinner.getSelectedItem().toString();
        String dif = myspinner1.getSelectedItem().toString();

        Toast.makeText(this, cat, Toast.LENGTH_SHORT).show();
    }


}