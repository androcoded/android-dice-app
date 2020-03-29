package com.example.diceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //this project based on the mortuza korti udemy tuitorial


    private Button btnRollTheDice;
    private ImageView imgViewDice1;
    private ImageView imgViewDice2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRollTheDice = findViewById(R.id.btnRollTheDiceId);
        imgViewDice1 = findViewById(R.id.imgView_dice1_id);
        imgViewDice2 = findViewById(R.id.imgView_dice2_id);
        final int[] imgeResource ={R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};
        final MediaPlayer mp = MediaPlayer.create(this,R.raw.dice_sound);
        btnRollTheDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random randomNum1 = new Random();
                int imgeIndex1 =randomNum1.nextInt(6);
                imgViewDice1.setImageResource(imgeResource[imgeIndex1]);
                Random randomNum2 = new Random();
                int imgeIndex2 = randomNum2.nextInt(6);
                imgViewDice2.setImageResource(imgeResource[imgeIndex2]);
                YoYo.with(Techniques.BounceInDown)
                        .duration(200)
                        .repeat(0)
                        .playOn(findViewById(R.id.imgView_dice1_id));
                mp.start();
                YoYo.with(Techniques.BounceInDown)
                        .duration(200)
                        .repeat(0)
                        .playOn(findViewById(R.id.imgView_dice2_id));

            }
        });
    }
}
