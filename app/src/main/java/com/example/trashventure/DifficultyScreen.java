package com.example.trashventure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class DifficultyScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_screen);
    }
    public void goGameScreenTh(View view){
        Intent gameScreenTh = new Intent(this, GameScreenTh.class);
        startActivity(gameScreenTh);
    }

    public void goGameScreenAa(View view){
        Intent gameScreenAa = new Intent(this, GameScreenAa.class);
        startActivity(gameScreenAa);
    }

    public void goGameScreenSk(View view){
        Intent gameScreenSk = new Intent(this, GameScreenSk.class);
        startActivity(gameScreenSk);
    }
}