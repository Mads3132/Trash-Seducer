package com.example.trashventure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TitleScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);
    }
    public void goDifficultyScreen(View view){
        Intent difficultyScreen = new Intent(this, DifficultyScreen.class);
        startActivity(difficultyScreen);
    }
}