package com.example.trashventure;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class GameScreenSk extends AppCompatActivity {

    VideoView videoSk;

    String nextPosition1, nextPosition2, nextPosition3, nextPosition4;

    ImageButton button1sk, button2sk, button3sk, button4sk;

    Uri uriSk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game_screen_sk);

        //Finds the video in the raw folder
        videoSk = (VideoView) findViewById(R.id.gameVideoViewSk);
        String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.skive_intro_klip;
        uriSk = Uri.parse(videoPath);
        videoSk.setVideoURI(uriSk);

        videoSk.start(); //Starts the video

        //Sets up media controller for pausing the video
        //MediaController mediaController = new MediaController(this);
        //videoSk.setMediaController(mediaController);
        //mediaController.setAnchorView(videoSk);

        //Makes it so that the buttons can be changed in the code instead of the corresponding xml file
        button1sk = (ImageButton)findViewById(R.id.choiceButton1Sk);
        button2sk = (ImageButton)findViewById(R.id.choiceButton2Sk);
        button3sk = (ImageButton)findViewById(R.id.choiceButton3Sk);
        button4sk = (ImageButton)findViewById(R.id.choiceButton4Sk);

        //Starts the initial method for Skive
        startingSkive();
    }

    public void selectPosition(String position){
        switch(position){
            //This switch makes sure you get send to the correct method after clicking a button
            case "Restaffald": restaffaldSkive(); break;
            case "Metal og Plast": metalOgPlastSkive(); break;
            case "Storskrald": storskraldSkive(); break;
            case "Origami": origamiSkive(); break;
            case "Storskrald Skive Valg": storskraldSkiveValg(); break;
            case "Storskrald Klar": storskraldSkiveValgKlar(); break;
            case "Storskrald Farve": storskraldSkiveValgFarve(); break;
        }
    }

    public void activateButtons(){
        //A method for enabling all buttons as well as making sure the buttons aren't grayscale
        ColorMatrix matrix = new ColorMatrix();
        button1sk.setColorFilter(new ColorMatrixColorFilter(matrix));
        button2sk.setColorFilter(new ColorMatrixColorFilter(matrix));
        button3sk.setColorFilter(new ColorMatrixColorFilter(matrix));
        button4sk.setColorFilter(new ColorMatrixColorFilter(matrix));
        button1sk.setEnabled(true);
        button2sk.setEnabled(true);
        button3sk.setEnabled(true);
        button4sk.setEnabled(true);
        button1sk.setVisibility(View.VISIBLE);
        button2sk.setVisibility(View.VISIBLE);
        button3sk.setVisibility(View.VISIBLE);
        button4sk.setVisibility(View.VISIBLE);
    }

    public void startingSkive(){
        //Sets the initial button images to match with our "UML"
        button1sk.setImageResource(R.drawable.restaffald);
        button2sk.setImageResource(R.drawable.metal_og_plast);
        button3sk.setImageResource(R.drawable.storskrald);
        button4sk.setImageResource(R.drawable.origami);

        nextPosition1 = "Restaffald";
        nextPosition2 = "Metal og Plast";
        nextPosition3 = "Storskrald";
        nextPosition4 = "Origami";
    }

    public void restaffaldSkive(){
        videoSk = (VideoView) findViewById(R.id.gameVideoViewSk);
        String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.skive_restaffald;
        uriSk = Uri.parse(videoPath);

        videoSk.setVideoURI(uriSk);

        videoSk.start();

        //Delay that plays the explanation video after the video is finished
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                videoSk = (VideoView) findViewById(R.id.gameVideoViewSk);
                String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.skive_restaffald_f;
                uriSk = Uri.parse(videoPath);
                //Set clean transition here
                videoSk.setVideoURI(uriSk);
                videoSk.start();
            }
        }, 8000); // Millisecond 1000 = 1 sec

        //In case we need to change the buttons, this will be done here
        button1sk.setImageResource(R.drawable.restaffald);
        button2sk.setImageResource(R.drawable.metal_og_plast);
        button3sk.setImageResource(R.drawable.storskrald);
        button4sk.setImageResource(R.drawable.origami);
        //Makes the button gray and disables it
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        button1sk.setColorFilter(new ColorMatrixColorFilter(matrix));
        button1sk.setEnabled(false);

    }

    public void metalOgPlastSkive(){
        videoSk = (VideoView) findViewById(R.id.gameVideoViewSk);
        String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.skive_metal_og_plast;
        uriSk = Uri.parse(videoPath);

        videoSk.setVideoURI(uriSk);

        videoSk.start();

        //Delay that plays the explanation video after the video is finished
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                videoSk = (VideoView) findViewById(R.id.gameVideoViewSk);
                String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.skive_metal_og_plast_f;
                uriSk = Uri.parse(videoPath);
                //Set clean transition here
                videoSk.setVideoURI(uriSk);
                videoSk.start();
            }
        }, 8000); // Millisecond 1000 = 1 sec

        //In case we need to change the buttons, this will be done here
        button1sk.setImageResource(R.drawable.restaffald);
        button2sk.setImageResource(R.drawable.metal_og_plast);
        button3sk.setImageResource(R.drawable.storskrald);
        button4sk.setImageResource(R.drawable.origami);
        //Makes the button gray and disables it
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        button2sk.setColorFilter(new ColorMatrixColorFilter(matrix));
        button2sk.setEnabled(false);

    }

    public void storskraldSkive(){
        videoSk = (VideoView) findViewById(R.id.gameVideoViewSk);
        String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.skive_storskrald;
        uriSk = Uri.parse(videoPath);

        videoSk.setVideoURI(uriSk);

        videoSk.start();

        //In case we need to change the buttons, this will be done here
        button1sk.setImageResource(R.drawable.restaffald);
        button2sk.setImageResource(R.drawable.metal_og_plast);
        button3sk.setImageResource(R.drawable.storskrald);
        button4sk.setImageResource(R.drawable.origami);
        //Makes the button gray and disables it
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        button3sk.setColorFilter(new ColorMatrixColorFilter(matrix));
        button3sk.setEnabled(false);

        //Delay that presents the new options
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                storskraldSkiveValg();
            }
        }, 4000); // Millisecond 1000 = 1 sec

    }

    public void storskraldSkiveValg(){
        activateButtons(); //Makes sure that all buttons are active

        //In case we need to change the buttons, this will be done here
        button1sk.setImageResource(R.drawable.bioaffald);
        button1sk.setVisibility(View.INVISIBLE); //Makes sure that there's only two buttons
        button1sk.setEnabled(false);

        button2sk.setImageResource(R.drawable.storskrald_klar);
        button3sk.setImageResource(R.drawable.storskrald_farve);

        button4sk.setImageResource(R.drawable.metal_og_plast);
        button4sk.setVisibility(View.INVISIBLE); //Makes sure that there's only two buttons
        button4sk.setEnabled(false);

        nextPosition1 = "";
        nextPosition2 = "Storskrald Klar";
        nextPosition3 = "Storskrald Farve";
        nextPosition4 = "";
    }

    public void storskraldSkiveValgKlar(){
        activateButtons(); //Makes sure that all buttons are active
        videoSk = (VideoView) findViewById(R.id.gameVideoViewSk);
        String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.skive_storskrald_klar;
        uriSk = Uri.parse(videoPath);

        videoSk.setVideoURI(uriSk);

        videoSk.start();

        //Delay that plays the explanation video after the video is finished
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                videoSk = (VideoView) findViewById(R.id.gameVideoViewSk);
                String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.skive_storskrald_klar_f;
                uriSk = Uri.parse(videoPath);
                //Set clean transition here
                videoSk.setVideoURI(uriSk);
                videoSk.start();
            }
        }, 6000); // Millisecond 1000 = 1 sec

        //In case we need to change the buttons, this will be done here
        button1sk.setImageResource(R.drawable.bioaffald);
        button1sk.setVisibility(View.INVISIBLE); //Makes sure that there's only two buttons
        button1sk.setEnabled(false);

        button2sk.setImageResource(R.drawable.storskrald_klar);
        button3sk.setImageResource(R.drawable.storskrald_farve);

        button4sk.setImageResource(R.drawable.metal_og_plast);
        button4sk.setVisibility(View.INVISIBLE); //Makes sure that there's only two buttons
        button4sk.setEnabled(false);

        //Makes the button gray and disables it
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        button2sk.setColorFilter(new ColorMatrixColorFilter(matrix));
        button2sk.setEnabled(false);

        nextPosition1 = "";
        nextPosition2 = "";
        nextPosition3 = "Storskrald Farve";
        nextPosition4 = "";
    }

    public void storskraldSkiveValgFarve(){
        activateButtons(); //Makes sure that all buttons are active
        videoSk = (VideoView) findViewById(R.id.gameVideoViewSk);
        String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.skive_storskrald_farve;
        uriSk = Uri.parse(videoPath);

        videoSk.setVideoURI(uriSk);

        videoSk.start();

        //Delay that plays the explanation video after the video is finished
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                videoSk = (VideoView) findViewById(R.id.gameVideoViewSk);
                String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.skive_storskrald_farve_f;
                uriSk = Uri.parse(videoPath);
                //Set clean transition here
                videoSk.setVideoURI(uriSk);
                videoSk.start();
            }
        }, 6000); // Millisecond 1000 = 1 sec

        //In case we need to change the buttons, this will be done here
        button1sk.setImageResource(R.drawable.bioaffald);
        button1sk.setVisibility(View.INVISIBLE); //Makes sure that there's only two buttons
        button1sk.setEnabled(false);

        button2sk.setImageResource(R.drawable.storskrald_klar);
        button3sk.setImageResource(R.drawable.storskrald_farve);

        button4sk.setImageResource(R.drawable.metal_og_plast);
        button4sk.setVisibility(View.INVISIBLE); //Makes sure that there's only two buttons
        button4sk.setEnabled(false);

        //Makes the button gray and disables it
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        button3sk.setColorFilter(new ColorMatrixColorFilter(matrix));
        button3sk.setEnabled(false);

        nextPosition1 = "";
        nextPosition2 = "Storskrald Klar";
        nextPosition3 = "";
        nextPosition4 = "";
    }

    public void origamiSkive(){
        videoSk = (VideoView) findViewById(R.id.gameVideoViewSk);
        String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.skive_origami;
        uriSk = Uri.parse(videoPath);

        videoSk.setVideoURI(uriSk);

        videoSk.start();

        //Delay that plays the explanation video after the video is finished
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                videoSk = (VideoView) findViewById(R.id.gameVideoViewSk);
                String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.skive_origami_f;
                uriSk = Uri.parse(videoPath);
                //Set clean transition here
                videoSk.setVideoURI(uriSk);
                videoSk.start();
            }
        }, 9000); // Millisecond 1000 = 1 sec

        //In case we need to change the buttons, this will be done here
        button1sk.setImageResource(R.drawable.restaffald);
        button2sk.setImageResource(R.drawable.metal_og_plast);
        button3sk.setImageResource(R.drawable.storskrald);
        button4sk.setImageResource(R.drawable.origami);
        //Makes the button gray and disables it
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        button4sk.setColorFilter(new ColorMatrixColorFilter(matrix));
        button4sk.setEnabled(false);

    }

    //Makes sure that the buttons send you from current position to the next one
    public void button1sk(View view){selectPosition(nextPosition1);}
    public void button2sk(View view){selectPosition(nextPosition2);}
    public void button3sk(View view){selectPosition(nextPosition3);}
    public void button4sk(View view){selectPosition(nextPosition4);}
}