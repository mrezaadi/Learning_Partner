package com.example.learningpartner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.learningpartner.R;
import com.example.learningpartner.activity.main_menu;

public class video_player extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
    }

    public void gotoMenu(View view){
        Intent intent = new Intent(getApplicationContext(), main_menu.class);
        startActivity(intent);
        finish();
    }
}