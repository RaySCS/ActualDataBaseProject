package com.example.actualdatabaseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    private ViewFlipper animate;
    private Button button1;
    private Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animate = findViewById(R.id.ANIMATE);
//        Button[] buttons = new Button[9];
        button1 = findViewById(R.id.button3);
        Integer side1 = Integer.getInteger(button1.getText().toString(), -1);

        button2 = findViewById(R.id.button4);
        Integer side2 = Integer.getInteger(button2.getText().toString(), -1);

        int[] buttons = {side1,side2 };

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
        animate.setFlipInterval(2000);
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