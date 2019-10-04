package com.example.actualdatabaseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    TextView infoEntry1 = findViewById(R.id.infoEntry1);
    TextView infoEntry2 = findViewById(R.id.infoEntry2);
    TextView infoEntry3 = findViewById(R.id.infoEntry3);
    TextView infoEntry4 = findViewById(R.id.infoEntry4);
    TextView infoEntry5 = findViewById(R.id.infoEntry5);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
    }

//    public void submitInfo(){
//
//    }


}
