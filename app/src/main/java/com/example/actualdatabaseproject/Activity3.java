package com.example.actualdatabaseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

    TextView infoEntry1 = (TextView)findViewById(R.id.infoEntry1);
    TextView infoEntry2 = (TextView)findViewById(R.id.infoEntry2);
    TextView infoEntry3 = (TextView)findViewById(R.id.infoEntry3);
    TextView infoEntry4 = (TextView)findViewById(R.id.infoEntry4);
    TextView infoEntry5 = (TextView)findViewById(R.id.infoEntry5);


    int displayMinutes = 0;
    int displayPoints = 0;
    int displayAssists = 0;
    int displaySteals = 0;
    int displayRebounds = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
    }

    public void submitInfo(){
        displayMinutes = Integer.parseInt(infoEntry1.getText().toString());
        displayPoints = Integer.parseInt(infoEntry2.getText().toString());
        displayAssists = Integer.parseInt(infoEntry3.getText().toString());
        displaySteals = Integer.parseInt(infoEntry4.getText().toString());
        displayRebounds = Integer.parseInt(infoEntry5.getText().toString());


        Toast.makeText(this, "eneterdddd", Toast.LENGTH_SHORT).show();
    }


}
