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

public class GameScreenAa extends AppCompatActivity {

    VideoView videoAa;

    String nextPosition1, nextPosition2, nextPosition3, nextPosition4;

    ImageButton button1aa, button2aa, button3aa, button4aa;

    Uri uriAa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game_screen_aa);

        //Finds the video in the raw folder
        videoAa = (VideoView) findViewById(R.id.gameVideoViewAa);
        String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.aalborg_intro_klip;
        uriAa = Uri.parse(videoPath);
        videoAa.setVideoURI(uriAa);

        videoAa.start(); //Starts the video

        //Sets up media controller for pausing the video
        //MediaController mediaController = new MediaController(this);
        //videoAa.setMediaController(mediaController);
        //mediaController.setAnchorView(videoAa);

        //Makes it so that the buttons can be changed in the code instead of the corresponding xml file
        button1aa = (ImageButton)findViewById(R.id.choiceButton1Aa);
        button2aa = (ImageButton)findViewById(R.id.choiceButton2Aa);
        button3aa = (ImageButton)findViewById(R.id.choiceButton3Aa);
        button4aa = (ImageButton)findViewById(R.id.choiceButton4Aa);

        //Starts the initial method for Aalborg
        startingAalborg();
    }

    public void selectPosition(String position){
        switch(position){
            //This switch makes sure you get send to the correct method after clicking a button
            case "Restaffald": restaffaldAalborg(); break;
            case "Papir og Pap": papirOgPapAalborg(); break;
            case "Metal og Plast": metalOgPlastAalborg(); break;
            case "Skyl": skylAalborg(); break;
            case "Skyl_ny": skylAalborgNy(); break;
            case "Skyl Bioaffald": skylAalborgBioaffald(); break;
            case "Skyl Glas": skylAalborgGlas(); break;
            case "Skyl Papir": skylAalborgPapir(); break;
            case "Skyl Metal": skylAalborgMetal(); break;
        }
    }

    public void activateButtons(){
        //A method for enabling all buttons as well as making sure the buttons aren't grayscale
        ColorMatrix matrix = new ColorMatrix();
        button1aa.setColorFilter(new ColorMatrixColorFilter(matrix));
        button2aa.setColorFilter(new ColorMatrixColorFilter(matrix));
        button3aa.setColorFilter(new ColorMatrixColorFilter(matrix));
        button4aa.setColorFilter(new ColorMatrixColorFilter(matrix));
        button1aa.setEnabled(true);
        button2aa.setEnabled(true);
        button3aa.setEnabled(true);
        button4aa.setEnabled(true);
        button1aa.setVisibility(View.VISIBLE);
        button2aa.setVisibility(View.VISIBLE);
        button3aa.setVisibility(View.VISIBLE);
        button4aa.setVisibility(View.VISIBLE);
    }

    public void startingAalborg(){
        //Sets the initial button images to match with our "UML"
        button1aa.setImageResource(R.drawable.restaffald);
        button2aa.setImageResource(R.drawable.skyl);
        button3aa.setImageResource(R.drawable.papir_og_pap);
        button4aa.setImageResource(R.drawable.metal_og_plast);

        nextPosition1 = "Restaffald";
        nextPosition2 = "Skyl";
        nextPosition3 = "Papir og Pap";
        nextPosition4 = "Metal og Plast";
    }

    public void restaffaldAalborg(){
        videoAa = (VideoView) findViewById(R.id.gameVideoViewAa);
        String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.aalborg_restaffald;
        uriAa = Uri.parse(videoPath);

        videoAa.setVideoURI(uriAa);

        videoAa.start();

        //Delay that plays the explanation video after the video is finished
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                videoAa = (VideoView) findViewById(R.id.gameVideoViewAa);
                String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.aalborg_restaffald_f;
                uriAa = Uri.parse(videoPath);
                //Set clean transition here
                videoAa.setVideoURI(uriAa);
                videoAa.start();
            }
        }, 2000); // Millisecond 1000 = 1 sec

        //In case we need to change the buttons, this will be done here
        button1aa.setImageResource(R.drawable.restaffald);
        button2aa.setImageResource(R.drawable.skyl);
        button3aa.setImageResource(R.drawable.papir_og_pap);
        button4aa.setImageResource(R.drawable.metal_og_plast);
        //Makes the button gray and disables it
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        button1aa.setColorFilter(new ColorMatrixColorFilter(matrix));
        button1aa.setEnabled(false);

    }

    public void skylAalborg(){
        videoAa = (VideoView) findViewById(R.id.gameVideoViewAa);
        String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.aalborg_skyl;
        uriAa = Uri.parse(videoPath);

        videoAa.setVideoURI(uriAa);

        videoAa.start();

        //In case we need to change the buttons, this will be done here
        button1aa.setImageResource(R.drawable.restaffald);
        button2aa.setImageResource(R.drawable.skyl);
        button3aa.setImageResource(R.drawable.papir_og_pap);
        button4aa.setImageResource(R.drawable.metal_og_plast);
        //Makes the button gray and disables it
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        button2aa.setColorFilter(new ColorMatrixColorFilter(matrix));
        button2aa.setEnabled(false);

        //Delay that presents the new options
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                skylAalborgNy();
            }
        }, 9000); // Millisecond 1000 = 1 sec

    }

    public void skylAalborgNy(){
        activateButtons(); //Makes sure that all buttons are active
        videoAa = (VideoView) findViewById(R.id.gameVideoViewAa);
        String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.aalborg_skyl_f;
        uriAa = Uri.parse(videoPath);

        videoAa.setVideoURI(uriAa);

        videoAa.start();

        //In case we need to change the buttons, this will be done here
        button1aa.setImageResource(R.drawable.bioaffald);
        button2aa.setImageResource(R.drawable.glas);
        button3aa.setImageResource(R.drawable.papir_og_pap);
        button4aa.setImageResource(R.drawable.metal_og_plast);

        nextPosition1 = "Skyl Bioaffald";
        nextPosition2 = "Skyl Glas";
        nextPosition3 = "Skyl Papir";
        nextPosition4 = "Skyl Metal";
    }

    public void skylAalborgMetal(){
        videoAa = (VideoView) findViewById(R.id.gameVideoViewAa);
        String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.aalborg_skyl_metal_og_plast;
        uriAa = Uri.parse(videoPath);

        videoAa.setVideoURI(uriAa);

        videoAa.start();

        //Delay that plays the explanation video after the video is finished
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                videoAa = (VideoView) findViewById(R.id.gameVideoViewAa);
                String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.aalborg_skyl_metal_og_plast_f;
                uriAa = Uri.parse(videoPath);
                //Set clean transition here
                videoAa.setVideoURI(uriAa);
                videoAa.start();
            }
        }, 4000); // Millisecond 1000 = 1 sec

        //In case we need to change the buttons, this will be done here
        button1aa.setImageResource(R.drawable.bioaffald);
        button2aa.setImageResource(R.drawable.glas);
        button3aa.setImageResource(R.drawable.papir_og_pap);
        button4aa.setImageResource(R.drawable.metal_og_plast);
        //Makes the button gray and disables it
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        button4aa.setColorFilter(new ColorMatrixColorFilter(matrix));
        button4aa.setEnabled(false);
    }

    public void skylAalborgPapir(){
        videoAa = (VideoView) findViewById(R.id.gameVideoViewAa);
        String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.aalborg_papir_og_pap;
        uriAa = Uri.parse(videoPath);

        videoAa.setVideoURI(uriAa);

        videoAa.start();

        //Delay that plays the explanation video after the video is finished
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                videoAa = (VideoView) findViewById(R.id.gameVideoViewAa);
                String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.aalborg_skyl_papir_og_pap_f;
                uriAa = Uri.parse(videoPath);
                //Set clean transition here
                videoAa.setVideoURI(uriAa);
                videoAa.start();
            }
        }, 2000); // Millisecond 1000 = 1 sec

        //In case we need to change the buttons, this will be done here
        button1aa.setImageResource(R.drawable.bioaffald);
        button2aa.setImageResource(R.drawable.glas);
        button3aa.setImageResource(R.drawable.papir_og_pap);
        button4aa.setImageResource(R.drawable.metal_og_plast);
        //Makes the button gray and disables it
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        button3aa.setColorFilter(new ColorMatrixColorFilter(matrix));
        button3aa.setEnabled(false);
    }

    public void skylAalborgGlas(){
        videoAa = (VideoView) findViewById(R.id.gameVideoViewAa);
        String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.aalborg_skyl_glas;
        uriAa = Uri.parse(videoPath);

        videoAa.setVideoURI(uriAa);

        videoAa.start();

        //Delay that plays the explanation video after the video is finished
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                videoAa = (VideoView) findViewById(R.id.gameVideoViewAa);
                String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.aalborg_skyl_glas_f;
                uriAa = Uri.parse(videoPath);
                //Set clean transition here
                videoAa.setVideoURI(uriAa);
                videoAa.start();
            }
        }, 4000); // Millisecond 1000 = 1 sec

        //In case we need to change the buttons, this will be done here
        button1aa.setImageResource(R.drawable.bioaffald);
        button2aa.setImageResource(R.drawable.glas);
        button3aa.setImageResource(R.drawable.papir_og_pap);
        button4aa.setImageResource(R.drawable.metal_og_plast);
        //Makes the button gray and disables it
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        button2aa.setColorFilter(new ColorMatrixColorFilter(matrix));
        button2aa.setEnabled(false);
    }

    public void skylAalborgBioaffald(){
        videoAa = (VideoView) findViewById(R.id.gameVideoViewAa);
        String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.aalborg_skyl_bioaffald;
        uriAa = Uri.parse(videoPath);

        videoAa.setVideoURI(uriAa);

        videoAa.start();

        //Delay that plays the explanation video after the video is finished
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                videoAa = (VideoView) findViewById(R.id.gameVideoViewAa);
                String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.aalborg_skyl_bioaffald_f;
                uriAa = Uri.parse(videoPath);
                //Set clean transition here
                videoAa.setVideoURI(uriAa);
                videoAa.start();
            }
        }, 4000); // Millisecond 1000 = 1 sec

        //In case we need to change the buttons, this will be done here
        button1aa.setImageResource(R.drawable.bioaffald);
        button2aa.setImageResource(R.drawable.glas);
        button3aa.setImageResource(R.drawable.papir_og_pap);
        button4aa.setImageResource(R.drawable.metal_og_plast);
        //Makes the button gray and disables it
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        button1aa.setColorFilter(new ColorMatrixColorFilter(matrix));
        button1aa.setEnabled(false);
    }

    public void papirOgPapAalborg(){
        videoAa = (VideoView) findViewById(R.id.gameVideoViewAa);
        String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.aalborg_papir_og_pap;
        uriAa = Uri.parse(videoPath);

        videoAa.setVideoURI(uriAa);

        videoAa.start();

        //Delay that plays the explanation video after the video is finished
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                videoAa = (VideoView) findViewById(R.id.gameVideoViewAa);
                String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.aalborg_papir_og_pap_f;
                uriAa = Uri.parse(videoPath);
                //Set clean transition here
                videoAa.setVideoURI(uriAa);
                videoAa.start();
            }
        }, 2000); // Millisecond 1000 = 1 sec

        //In case we need to change the buttons, this will be done here
        button1aa.setImageResource(R.drawable.restaffald);
        button2aa.setImageResource(R.drawable.skyl);
        button3aa.setImageResource(R.drawable.papir_og_pap);
        button4aa.setImageResource(R.drawable.metal_og_plast);
        //Makes the button gray and disables it
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        button3aa.setColorFilter(new ColorMatrixColorFilter(matrix));
        button3aa.setEnabled(false);

    }

    public void metalOgPlastAalborg(){
        videoAa = (VideoView) findViewById(R.id.gameVideoViewAa);
        String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.aalborg_metal_og_plast;
        uriAa = Uri.parse(videoPath);

        videoAa.setVideoURI(uriAa);

        videoAa.start();

        //Delay that plays the explanation video after the video is finished
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                videoAa = (VideoView) findViewById(R.id.gameVideoViewAa);
                String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.aalborg_metal_og_plast_f;
                uriAa = Uri.parse(videoPath);
                //Set clean transition here
                videoAa.setVideoURI(uriAa);
                videoAa.start();
            }
        }, 2000); // Millisecond 1000 = 1 sec

        //In case we need to change the buttons, this will be done here
        button1aa.setImageResource(R.drawable.restaffald);
        button2aa.setImageResource(R.drawable.skyl);
        button3aa.setImageResource(R.drawable.papir_og_pap);
        button4aa.setImageResource(R.drawable.metal_og_plast);
        //Makes the button gray and disables it
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        button4aa.setColorFilter(new ColorMatrixColorFilter(matrix));
        button4aa.setEnabled(false);

    }

    //Makes sure that the buttons send you from current position to the next one
    public void button1aa(View view){selectPosition(nextPosition1);}
    public void button2aa(View view){selectPosition(nextPosition2);}
    public void button3aa(View view){selectPosition(nextPosition3);}
    public void button4aa(View view){selectPosition(nextPosition4);}
}