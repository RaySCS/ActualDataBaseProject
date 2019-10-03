package com.example.actualdatabaseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

    EditText infoEntry1;
    EditText infoEntry2;
    EditText infoEntry3;
    EditText infoEntry4;
    EditText infoEntry5;


    int displayMinutes;
    int displayPoints;
    int displayAssists;
    int displaySteals;
    int displayRebounds;

    private static final String TAG = "Activity3";

    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        infoEntry1 = (EditText)findViewById(R.id.infoEntry1);
        infoEntry2 = (EditText)findViewById(R.id.infoEntry2);
        infoEntry3 = (EditText)findViewById(R.id.infoEntry3);
        infoEntry4 = (EditText)findViewById(R.id.infoEntry4);
        infoEntry5 = (EditText)findViewById(R.id.infoEntry5);
        myDB = new DatabaseHelper(this);

    }

    public void submitInfo(View view){
        displayMinutes = Integer.parseInt(infoEntry1.getText().toString());
        AddData(Integer.toString(displayMinutes));
//        displayPoints = Integer.parseInt(infoEntry2.getText().toString());
//        displayAssists = Integer.parseInt(infoEntry3.getText().toString());
//        displaySteals = Integer.parseInt(infoEntry4.getText().toString());
//        displayRebounds = Integer.parseInt(infoEntry5.getText().toString());

    }


    public void openData(View view){
        Intent intent = new Intent(Activity3.this, ViewListContent.class);
        startActivity(intent);
    }
    public void AddData(String newEntry) {

        boolean insertData = myDB.addData(newEntry);

        if(insertData==true){
            Toast.makeText(this, "Data Successfully Inserted!", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Something went wrong :(.", Toast.LENGTH_LONG).show();
        }
    }




}
