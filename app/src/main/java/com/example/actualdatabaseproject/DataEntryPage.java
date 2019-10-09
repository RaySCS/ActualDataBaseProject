package com.example.actualdatabaseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DataEntryPage extends AppCompatActivity {

    EditText infoEntry1;
    EditText infoEntry2;
    EditText infoEntry3;
    EditText infoEntry4;
    EditText infoEntry5;
    EditText infoEntry0;

    DatabaseHelper myDB;


    String displayName;
    int displayMinutes;
    int displayPoints;
    int displayAssists;
    int displaySteals;
    int displayRebounds;



//    private SQLiteOpenHelper dbHelper;
//    SQLiteDatabase db = dbHelper.getWritableDatabase();
//    ContentValues values = new ContentValues();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        infoEntry0 = findViewById(R.id.infoEntry0);
        infoEntry1 = findViewById(R.id.infoEntry1);
        infoEntry2 = findViewById(R.id.infoEntry2);
        infoEntry3 = findViewById(R.id.infoEntry3);
        infoEntry4 = findViewById(R.id.infoEntry4);
        infoEntry5 = findViewById(R.id.infoEntry5);
        myDB = new DatabaseHelper(this);

    }

    public void submitInfo(View view){
        displayName = infoEntry0.getText().toString();
        AddData(displayName);

        displayMinutes = Integer.parseInt(infoEntry1.getText().toString());
        AddData(Integer.toString(displayMinutes));


        displayPoints = Integer.parseInt(infoEntry2.getText().toString());
        AddData(Integer.toString(displayPoints));


        displayAssists = Integer.parseInt(infoEntry3.getText().toString());
        AddData(Integer.toString(displayAssists));


        displaySteals = Integer.parseInt(infoEntry4.getText().toString());
        AddData(Integer.toString(displaySteals));


        displayRebounds = Integer.parseInt(infoEntry5.getText().toString());
        AddData(Integer.toString(displayRebounds));


    }

    public void openData(View view){
        Intent intent = new Intent(DataEntryPage.this, ViewListContent.class);
        startActivity(intent);
    }


    public void playerPage(View view){
        Intent intent = new Intent(DataEntryPage.this, DisplayPlayerPage.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);//slide to right
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
