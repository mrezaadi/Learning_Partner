package com.example.learningpartner.activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.learningpartner.R;
import com.example.learningpartner.quiz_player;
import com.example.learningpartner.video_player;

public class main_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void gotoInputSoal(View view){
        Intent intent = new Intent(getApplicationContext(), inputsoal_menu.class);
        startActivity(intent);
        finish();
    }

    public void gotoInputVideo(View view){
        Intent intent = new Intent(getApplicationContext(), inputvideo_menu.class);
        startActivity(intent);
        finish();
    }


    public void gotoVideoPlayer(View view){
        Intent intent = new Intent(getApplicationContext(), video_player.class);
        startActivity(intent);
        finish();
    }

    public void gotoQuizPlayer(View view){
        Intent intent = new Intent(getApplicationContext(), quiz_player.class);
        startActivity(intent);
        finish();
    }

    public void gotoChatbot(View view){
        Intent intent = new Intent(getApplicationContext(), chatbot_menu.class);
        startActivity(intent);
        finish();
    }

    public void gotoPlaylist(View view){
        Intent intent = new Intent(getApplicationContext(), playlist_menu.class);
        startActivity(intent);
        finish();
    }

}