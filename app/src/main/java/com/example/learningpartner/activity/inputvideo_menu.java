package com.example.learningpartner.activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.learningpartner.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class inputvideo_menu extends AppCompatActivity {
    private EditText mIDVideo, mMatPel, mMateri, mKelas, mLink;
    private Button button;
    private String IDVideo, Mata_Pelajaran, Materi, Kelas, Link;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Video");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputvideo_menu);

        mIDVideo = findViewById(R.id.idVideo);
        mMatPel = findViewById(R.id.mataPelajaran);
        mMateri = findViewById(R.id.materi);
        mKelas = findViewById(R.id.kelas);
        mLink = findViewById(R.id.link);
        button = findViewById(R.id.upload);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadVideo();
            }
        });
    }

    public void uploadVideo(){
        IDVideo = mIDVideo.getText().toString();
        Mata_Pelajaran = mMatPel.getText().toString();
        Materi = mMateri.getText().toString();
        Kelas = mKelas.getText().toString();
        Link = mLink.getText().toString();

        if (IDVideo.isEmpty() || Mata_Pelajaran.isEmpty() || Materi.isEmpty() || Kelas.isEmpty() || Link.isEmpty()){
            String pemberitahuan = "Field dibawah ini harus terisi:\n";
            if (IDVideo.isEmpty()){
                pemberitahuan = pemberitahuan + "[ID Video]\n ";
            }
            if (Mata_Pelajaran.isEmpty()){
                pemberitahuan = pemberitahuan + "[Mata Pelajaran]\n ";
            }
            if (Materi.isEmpty()){
                pemberitahuan = pemberitahuan + "[Materi]\n ";
            }
            if (Kelas.isEmpty()){
                pemberitahuan = pemberitahuan + "[Kelas]\n ";
            }
            if (Link.isEmpty()){
                pemberitahuan = pemberitahuan + "[Link]\n ";
            }
            pemberitahuan = pemberitahuan + "Data Tidak Tersimpan";
            Toast.makeText(inputvideo_menu.this, pemberitahuan, Toast.LENGTH_LONG).show();
        } else {
            root.child(IDVideo).setValue(IDVideo);
            root.child(IDVideo).child("Mata Pelajaran").setValue(Mata_Pelajaran);
            root.child(IDVideo).child("Materi").setValue(Materi);
            root.child(IDVideo).child("Kelas").setValue(Kelas);
            root.child(IDVideo).child("Link").setValue(Link);
            Toast.makeText(inputvideo_menu.this, "Data Tersimpan", Toast.LENGTH_LONG).show();
        }
    }
    public void gotoMenu(View view){
        Intent intent = new Intent(getApplicationContext(), main_menu.class);
        startActivity(intent);
        finish();
    }
}