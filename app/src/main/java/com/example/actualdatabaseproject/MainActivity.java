package com.example.actualdatabaseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    private ViewFlipper animate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animate = findViewById(R.id.ANIMATE);

        int[] images = {R.drawable.sixerslogo, R.drawable.raptors, R.drawable.denverlogo,
                R.drawable.nets, R.drawable.pistons, R.drawable.spurs,
                R.drawable.celtics, R.drawable.mavericks, R.drawable.wizards,
                R.drawable.knicks, R.drawable.pelicans, R.drawable.warriors,
                R.drawable.rockets, R.drawable.trailblazers, R.drawable.thunder};

        for (int image:images){
            flipperImages(image);
        }

    }

    public void flipperImages(int image){
        ImageButton imageButton = new ImageButton(this);
        imageButton.setBackgroundResource(image);

        animate.addView(imageButton);
        animate.setFlipInterval(1000);
        animate.setAutoStart(true);

        animate.setInAnimation(this, android.R.anim.slide_in_left);
        animate.setOutAnimation(this, android.R.anim.slide_out_right);


    }

    public void openAddGameActivity(View view){
        Intent intent = new Intent(this, DisplayPlayerPage.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);//slide to right
    }
}