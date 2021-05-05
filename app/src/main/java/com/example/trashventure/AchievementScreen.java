package com.example.trashventure;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.widget.ImageButton;

public class AchievementScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement_screen);

        ImageButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12;

        button1 = (ImageButton)findViewById(R.id.Achievement_papir);
        button2 = (ImageButton)findViewById(R.id.Achievement_restaffald);
        button3 = (ImageButton)findViewById(R.id.Achievement_bioaffald);
        button4 = (ImageButton)findViewById(R.id.Achievement_genbrug);
        button5 = (ImageButton)findViewById(R.id.Achievement_glas);
        button6 = (ImageButton)findViewById(R.id.Achievement_haard_plast);
        button7 = (ImageButton)findViewById(R.id.Achievement_metal_og_plast);
        button8 = (ImageButton)findViewById(R.id.Achievement_origami);
        button9 = (ImageButton)findViewById(R.id.Achievement_skyl);
        button10 = (ImageButton)findViewById(R.id.Achievement_storskrald);
        button11 = (ImageButton)findViewById(R.id.Achievement_storskrald_farve);
        button12 = (ImageButton)findViewById(R.id.Achievement_storskrald_klar);

        //Makes the buttons grey
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        button1.setColorFilter(new ColorMatrixColorFilter(matrix));
        button2.setColorFilter(new ColorMatrixColorFilter(matrix));
        button3.setColorFilter(new ColorMatrixColorFilter(matrix));
        button4.setColorFilter(new ColorMatrixColorFilter(matrix));
        button5.setColorFilter(new ColorMatrixColorFilter(matrix));
        button6.setColorFilter(new ColorMatrixColorFilter(matrix));
        button7.setColorFilter(new ColorMatrixColorFilter(matrix));
        button8.setColorFilter(new ColorMatrixColorFilter(matrix));
        button9.setColorFilter(new ColorMatrixColorFilter(matrix));
        button10.setColorFilter(new ColorMatrixColorFilter(matrix));
        button11.setColorFilter(new ColorMatrixColorFilter(matrix));
        button12.setColorFilter(new ColorMatrixColorFilter(matrix));
    }
}