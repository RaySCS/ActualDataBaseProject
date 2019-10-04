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
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {


    ListView scrollPlayersView;
    DatabaseHelper myDB;
    String items[] = new String[] {"Apple, Orange, Cantelope"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        scrollPlayersView = (ListView)findViewById(R.id.scrollPlayersView);
        myDB = new DatabaseHelper(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);//add comma then array of names
        scrollPlayersView.setAdapter(adapter);
        scrollPlayersView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor res = myDB.getListContents();//use column count
            }
        });
    }

    public void openAddPlayerActivity(View view){
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);//slide to right
    }

    public void openData(View view){
        Intent intent = new Intent(Activity2.this, ViewListContent.class);
        startActivity(intent);
    }


}
