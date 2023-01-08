package com.example.learningpartner.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.learningpartner.R;

public class playlist_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist_menu);
    }

    public void gotoMenu(View view) {
        Intent intent = new Intent(getApplicationContext(), main_menu.class);
        startActivity(intent);
        finish();
    }
}