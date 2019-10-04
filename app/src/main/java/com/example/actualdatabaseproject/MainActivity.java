package com.example.actualdatabaseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ViewAnimator;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    private ViewFlipper animate;
//    long timer =

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animate = findViewById(R.id.ANIMATE);
        Button[] buttons = new Button[9];

        int[] images = {R.drawable.download, R.drawable.try1};


//        for (int i=0; i < images.length; i++){
//            flipperImages(images[i]);
//        }

        for (int image:images){
            flipperImages(image);
        }


    }

    public void flipperImages(int image){
        ImageButton imageButton = new ImageButton(this);
        imageButton.setBackgroundResource(image);

        animate.addView(imageButton);
        animate.setFlipInterval(4000);
        animate.setAutoStart(true);

        animate.setInAnimation(this, android.R.anim.slide_in_left);
        animate.setOutAnimation(this, android.R.anim.slide_out_right);


    }

    public void openAddGameActivity(View view){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);//slide to right
    }
}