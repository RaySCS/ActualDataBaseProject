package com.example.actualdatabaseproject;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterViewAnimator;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayPlayerPage extends AppCompatActivity {


    TextView minuteDisplay, pointsDisplay, assistsDisplay, reboundsDisplay, stealsDisplay;
    ListView scrollPlayersView;
    DatabaseHelper myDB;
    String[] items = new String[]{"POne", "PTwo", "PThree", "PFour"};//Add players name to this array so we can display in the array list
    ArrayList<String> alphabet = new ArrayList<String>();
    ArrayList<String> pNamesToDisplay = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        addAlphabetLetters();
        scrollPlayersView = findViewById(R.id.scrollPlayersView);
        minuteDisplay = findViewById(R.id.minuteDisplay);
        pointsDisplay = findViewById(R.id.pointsDisplay);
        assistsDisplay = findViewById(R.id.assistsDisplay);
        reboundsDisplay = findViewById(R.id.reboundsDisplay);
        stealsDisplay = findViewById(R.id.stealsDisplay);

        addPlayersNamesToListView();
        myDB = new DatabaseHelper(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pNamesToDisplay);//add comma then array of names
        scrollPlayersView.setAdapter(adapter);
        scrollPlayersView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //using which item is clicked, we can display certain stats
                displayStats(pNamesToDisplay.get(position));
            }
        });
    }

    int statOne = 0;
    int statTwo = 0;
    int statThree = 0;
    int statFour = 0;
    int statFive = 0;
    public void displayStats(String name){
        for(int x=0;x<arrayListOfData.size();x++){
            if(arrayListOfData.get(x).equals(name)){
                System.out.println("NAME: " + arrayListOfData.get(x));
//                //1,4,2,3,5-order of data
                statOne = Integer.parseInt(arrayListOfData.get(x+1));
                statTwo = Integer.parseInt(arrayListOfData.get(x+4));
                statThree = Integer.parseInt(arrayListOfData.get(x+2));
                statFour = Integer.parseInt(arrayListOfData.get(x+3));
                statFive = Integer.parseInt(arrayListOfData.get(x+5));
                doLabelSetUp();
            }

        }
    }

    public void doLabelSetUp(){
        minuteDisplay.setText("" + statOne);
        pointsDisplay.setText("" + statFour);
        assistsDisplay.setText("" + statTwo);
        reboundsDisplay.setText("" + statThree);
        stealsDisplay.setText("" + statFive);
    }


    public void addAlphabetLetters(){
        alphabet.add("a");
        alphabet.add("b");
        alphabet.add("c");
        alphabet.add("d");
        alphabet.add("e");
        alphabet.add("f");
        alphabet.add("g");
        alphabet.add("h");
        alphabet.add("i");
        alphabet.add("j");
        alphabet.add("k");
        alphabet.add("l");
        alphabet.add("m");
        alphabet.add("n");
        alphabet.add("o");
        alphabet.add("p");
        alphabet.add("q");
        alphabet.add("r");
        alphabet.add("s");
        alphabet.add("t");
        alphabet.add("u");
        alphabet.add("v");
        alphabet.add("w");
        alphabet.add("x");
        alphabet.add("y");
        alphabet.add("z");
    }

    public void addPlayersNamesToListView(){
        myDB = new DatabaseHelper(this);
        addActualDATAValues();
        System.out.println("size: " + arrayListOfData.size());
        for(int x=0;x<arrayListOfData.size();x++){
            char c = arrayListOfData.get(x).charAt(0);
            String actualVal = Character.toString(c);
            System.out.println("RIGHT2 HERE: " + actualVal);
            for(int y=0;y<alphabet.size();y++){
                if(actualVal.equals(alphabet.get(y))){
                    System.out.println("RIGHT HERE: " + actualVal);
                    pNamesToDisplay.add(arrayListOfData.get(x));
                }
            }
        }
    }
    ArrayList<String> arrayListOfData = new ArrayList<>();
    public void addActualDATAValues(){
        Cursor data = myDB.getListContents();
        if(data.getCount() == 0){
            Toast.makeText(this, "There are no contents in this list!",Toast.LENGTH_LONG).show();
        }
        else{
            while(data.moveToNext()){
                arrayListOfData.add(data.getString(1));
            }
        }
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

    public void homePage(View view){
        Intent intent = new Intent(DisplayPlayerPage.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);//slide to right
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