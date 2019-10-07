package com.example.actualdatabaseproject;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterViewAnimator;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayPlayerPage extends AppCompatActivity {


    TextView minuteDisplay, pointsDisplay, assistsDisplay, reboundsDisplay, stealsDisplay;
    ListView scrollPlayersView;
    DatabaseHelper myDB;
    String[] items = new String[]{"Apple", "Orange", "Cantelope", "Test1", "Test2", "Test3"};//Add players name to this array so we can display in the array list
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        scrollPlayersView = findViewById(R.id.scrollPlayersView);
        minuteDisplay = findViewById(R.id.minuteDisplay);
        pointsDisplay = findViewById(R.id.pointsDisplay);
        assistsDisplay = findViewById(R.id.assistsDisplay);
        reboundsDisplay = findViewById(R.id.reboundsDisplay);
        stealsDisplay = findViewById(R.id.stealsDisplay);

        myDB = new DatabaseHelper(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);//add comma then array of names
        scrollPlayersView.setAdapter(adapter);
        scrollPlayersView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor = myDB.getListContents();
                if(cursor.getCount() == 0){
                    Toast.makeText(DisplayPlayerPage.this,"NO DATA", Toast.LENGTH_SHORT).show();
                }
                else{
                    while(cursor.moveToNext()){
                        for(int i = 0;i<cursor.getColumnCount();i++){
                            System.out.println(cursor.getString(i));
                        }
                    }
                }
            }
        });
    }

    public void openAddPlayerActivity(View view){
        Intent intent = new Intent(this, DataEntryPage.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);//slide to right
    }

    public void openData(View view){
        Intent intent = new Intent(DisplayPlayerPage.this, ViewListContent.class);
        startActivity(intent);
    }


}

//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//
//public class DisplayPlayerPage extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_2);
//    }
//
//    public void openAddPlayerActivity(View view){
//        Intent intent = new Intent(this, DataEntryPage.class);
//        startActivity(intent);
//        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);//slide to right
//    }
//
//
//}