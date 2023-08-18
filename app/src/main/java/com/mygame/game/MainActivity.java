package com.mygame.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //0 - X
    //1 - O
    //2 - Null
    boolean gameactive=true;
    int activeplayer = 0;
    int [] gamestsate= {2,2,2,2,2,2,2,2,2};
    int [][]wposition= {{0,1,2} ,{3,4,5} ,{6,7,8} ,{0,3,6} ,{1,4,7} ,{2,5,8} ,{0,4,8} ,{2,4,6} };
    public void Tap(View view){
        ImageView img=(ImageView) view;
        int tappedimg=Integer.parseInt(img.getTag().toString());
        if(!gameactive){
            reset(view);
        }
        if(gamestsate[tappedimg]==2 && gameactive){
            gamestsate[tappedimg]=activeplayer;
            img.setTranslationY(-1000f);
            if(activeplayer==0){
                img.setImageResource(R.drawable.img_2);
                activeplayer=1;
                TextView status=findViewById(R.id.status);
                status.setText("X's Turn-Tap to play");
            }
            else{
                img.setImageResource(R.drawable.img_1);
                activeplayer=0;
                TextView status=findViewById(R.id.status);
                status.setText("O's Turn - Tap to play");
            }
        }
       img.animate().translationY(0f).setDuration(400);
        for(int[] wposition: wposition)
        {
            if(gamestsate[wposition[0]]==gamestsate[wposition[1]] &&
                    gamestsate[wposition[1]]==gamestsate[wposition[2]] &&
            gamestsate[wposition[0]]!=2) {
                gameactive=false;
                String winner;
                if (gamestsate[wposition[0]] == 0) {
                    winner = "O has Won";
                } else {
                    winner = "x has Won";
                }
                TextView status = findViewById(R.id.status);
                status.setText(winner);
            }
        }

    }
    public void reset(View view){
        gameactive=true;
        activeplayer=0;
        for(int i=0;i<gamestsate.length;i++)
        {
            gamestsate[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView10)).setImageResource(0);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}