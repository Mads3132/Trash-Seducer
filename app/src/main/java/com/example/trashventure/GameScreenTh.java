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
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class GameScreenTh extends AppCompatActivity {

    VideoView videoTh;

    String nextPosition1, nextPosition2, nextPosition3, nextPosition4;

    ImageButton button1th, button2th, button3th, button4th;

    Uri uriTh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game_screen_th);

        //Finds the video in the raw folder
        videoTh = (VideoView) findViewById(R.id.gameVideoViewTh);
        String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.thisted_intro_klip;
        uriTh = Uri.parse(videoPath);
        videoTh.setVideoURI(uriTh);

        videoTh.start(); //Starts the video

        //Sets up media controller for pausing the video
        //MediaController mediaController = new MediaController(this);
        //videoTh.setMediaController(mediaController);
        //mediaController.setAnchorView(videoTh);

        //Makes it so that the buttons can be changed in the code instead of the corresponding xml file
        button1th = (ImageButton)findViewById(R.id.choiceButton1Th);
        button2th = (ImageButton)findViewById(R.id.choiceButton2Th);
        button3th = (ImageButton)findViewById(R.id.choiceButton3Th);
        button4th = (ImageButton)findViewById(R.id.choiceButton4Th);

        //Starts the initial method for Thisted
        startingThisted();
    }

    public void selectPosition(String position){
        switch(position){
            //This switch makes sure you get send to the correct method after clicking a button
            case "Restaffald": restaffaldThisted(); break;
            case "Papir og Pap": papirOgPapThisted(); break;
            case "Bioaffald": bioaffaldThisted(); break;
            case "Genbrug": genbrugThisted(); break;
        }
    }

    public void activateButtons(){
        //A method for enabling all buttons as well as making sure the buttons aren't grayscale
        ColorMatrix matrix = new ColorMatrix();
        button1th.setColorFilter(new ColorMatrixColorFilter(matrix));
        button2th.setColorFilter(new ColorMatrixColorFilter(matrix));
        button3th.setColorFilter(new ColorMatrixColorFilter(matrix));
        button4th.setColorFilter(new ColorMatrixColorFilter(matrix));
        button1th.setEnabled(true);
        button2th.setEnabled(true);
        button3th.setEnabled(true);
        button4th.setEnabled(true);
        button1th.setVisibility(View.VISIBLE);
        button2th.setVisibility(View.VISIBLE);
        button3th.setVisibility(View.VISIBLE);
        button4th.setVisibility(View.VISIBLE);
    }

    public void startingThisted(){
        //Sets the initial button images to match with our "UML"
        button1th.setImageResource(R.drawable.restaffald);
        button2th.setImageResource(R.drawable.bioaffald);
        button3th.setImageResource(R.drawable.papir_og_pap);
        button4th.setImageResource(R.drawable.genbrug);

        nextPosition1 = "Restaffald";
        nextPosition2 = "Papir og Pap";
        nextPosition3 = "Bioaffald";
        nextPosition4 = "Genbrug";
    }

    public void restaffaldThisted(){
        videoTh = (VideoView) findViewById(R.id.gameVideoViewTh);
        String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.thisted_restaffald;
        uriTh = Uri.parse(videoPath);

        videoTh.setVideoURI(uriTh);

        videoTh.start();

        //Delay that plays the explanation video after the video is finished
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                videoTh = (VideoView) findViewById(R.id.gameVideoViewTh);
                String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.thisted_restaffald_f;
                uriTh = Uri.parse(videoPath);
                //Set clean transition here
                videoTh.setVideoURI(uriTh);
                videoTh.start();
            }
        }, 5000); // Millisecond 1000 = 1 sec

        //In case we need to change the buttons, this will be done here
        button1th.setImageResource(R.drawable.restaffald);
        button2th.setImageResource(R.drawable.bioaffald);
        button3th.setImageResource(R.drawable.papir_og_pap);
        button4th.setImageResource(R.drawable.genbrug);
        //Makes the button gray and disables it
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        button1th.setColorFilter(new ColorMatrixColorFilter(matrix));
        button1th.setEnabled(false);

    }

    public void papirOgPapThisted(){
        videoTh = (VideoView) findViewById(R.id.gameVideoViewTh);
        String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.thisted_papir_og_pap;
        uriTh = Uri.parse(videoPath);

        videoTh.setVideoURI(uriTh);

        videoTh.start();

        //Delay that plays the explanation video after the video is finished
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                videoTh = (VideoView) findViewById(R.id.gameVideoViewTh);
                String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.thisted_papir_og_pap_f;
                uriTh = Uri.parse(videoPath);
                //Set clean transition here
                videoTh.setVideoURI(uriTh);
                videoTh.start();
            }
        }, 5000); // Millisecond 1000 = 1 sec

        //In case we need to change the buttons, this will be done here
        button1th.setImageResource(R.drawable.restaffald);
        button2th.setImageResource(R.drawable.bioaffald);
        button3th.setImageResource(R.drawable.papir_og_pap);
        button4th.setImageResource(R.drawable.genbrug);
        //Makes the button gray and disables it
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        button3th.setColorFilter(new ColorMatrixColorFilter(matrix));
        button3th.setEnabled(false);

    }

    public void bioaffaldThisted(){
        videoTh = (VideoView) findViewById(R.id.gameVideoViewTh);
        String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.thisted_bioaffald;
        uriTh = Uri.parse(videoPath);

        videoTh.setVideoURI(uriTh);

        videoTh.start();

        //Delay that plays the explanation video after the video is finished
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                videoTh = (VideoView) findViewById(R.id.gameVideoViewTh);
                String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.thisted_bioaffald_f;
                uriTh = Uri.parse(videoPath);
                //Set clean transition here
                videoTh.setVideoURI(uriTh);
                videoTh.start();
            }
        }, 6000); // Millisecond 1000 = 1 sec

        //In case we need to change the buttons, this will be done here
        button1th.setImageResource(R.drawable.restaffald);
        button2th.setImageResource(R.drawable.bioaffald);
        button3th.setImageResource(R.drawable.papir_og_pap);
        button4th.setImageResource(R.drawable.genbrug);
        //Makes the button gray and disables it
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        button2th.setColorFilter(new ColorMatrixColorFilter(matrix));
        button2th.setEnabled(false);

    }

    public void genbrugThisted(){
        videoTh = (VideoView) findViewById(R.id.gameVideoViewTh);
        String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.thisted_genbrug;
        uriTh = Uri.parse(videoPath);

        videoTh.setVideoURI(uriTh);

        videoTh.start();

        //Delay that plays the explanation video after the video is finished
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                videoTh = (VideoView) findViewById(R.id.gameVideoViewTh);
                String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.thisted_genbrug_f;
                uriTh = Uri.parse(videoPath);
                //Set clean transition here
                videoTh.setVideoURI(uriTh);
                videoTh.start();
            }
        }, 12000); // Millisecond 1000 = 1 sec

        //In case we need to change the buttons, this will be done here
        button1th.setImageResource(R.drawable.restaffald);
        button2th.setImageResource(R.drawable.bioaffald);
        button3th.setImageResource(R.drawable.papir_og_pap);
        button4th.setImageResource(R.drawable.genbrug);
        //Makes the button gray and disables it
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        button4th.setColorFilter(new ColorMatrixColorFilter(matrix));
        button4th.setEnabled(false);

    }

    //Makes sure that the buttons send you from current position to the next one
    public void button1th(View view){selectPosition(nextPosition1);}
    public void button2th(View view){selectPosition(nextPosition2);}
    public void button3th(View view){selectPosition(nextPosition3);}
    public void button4th(View view){selectPosition(nextPosition4);}
}