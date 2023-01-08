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

public class inputsoal_menu extends AppCompatActivity {
    private EditText mIDSoal, mMatPel, mMateri, mKelas, mSoal, mOptionA, mOptionB, mOptionC, mOptionD, mPembahasan;
    private String IDSoal, Mata_Pelajaran, Materi, Kelas, Soal, OptionA, OptionB, OptionC, OptionD, Pembahasan;
    private Button button;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Soal");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputsoal_menu);

        mIDSoal = findViewById(R.id.idSoal);
        mMatPel = findViewById(R.id.mataPelajaranSoal);
        mMateri = findViewById(R.id.materiSoal);
        mKelas = findViewById(R.id.kelasSoal);
        mSoal = findViewById(R.id.soal);
        mOptionA = findViewById(R.id.optionA);
        mOptionB = findViewById(R.id.optionB);
        mOptionC = findViewById(R.id.optionC);
        mOptionD = findViewById(R.id.optionD);
        mPembahasan = findViewById(R.id.pembahasan);
        button = findViewById(R.id.uploadsoal);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadSoal();
            }
        });
    }

    public void uploadSoal(){
        IDSoal = mIDSoal.getText().toString();
        Mata_Pelajaran = mMatPel.getText().toString();
        Materi = mMateri.getText().toString();
        Kelas = mKelas.getText().toString();
        Soal = mSoal.getText().toString();
        OptionA = mOptionA.getText().toString();
        OptionB = mOptionB.getText().toString();
        OptionC = mOptionC.getText().toString();
        OptionD = mOptionD.getText().toString();
        Pembahasan = mPembahasan.getText().toString();

        if (IDSoal.isEmpty()|| Mata_Pelajaran.isEmpty() || Materi.isEmpty() || Kelas.isEmpty() || Soal.isEmpty() || OptionA.isEmpty() || OptionB.isEmpty() || OptionC.isEmpty() || OptionD.isEmpty() || Pembahasan.isEmpty()){
            String pemberitahuan = "Field dibawah ini harus terisi:\n";
            if (IDSoal.isEmpty()){
                pemberitahuan = pemberitahuan + "[ID Soal]\n";
            }
            if (Mata_Pelajaran.isEmpty()){
                pemberitahuan = pemberitahuan + "[Mata Pelajaran]\n";
            }
            if (Materi.isEmpty()){
                pemberitahuan = pemberitahuan + "[Materi]\n";
            }
            if (Kelas.isEmpty()){
                pemberitahuan = pemberitahuan + "[Kelas]\n";
            }
            if (Soal.isEmpty()){
                pemberitahuan = pemberitahuan + "[Soal]\n";
            }
            if (OptionA.isEmpty()){
                pemberitahuan = pemberitahuan + "[OptionA]\n";
            }
            if (OptionB.isEmpty()){
                pemberitahuan = pemberitahuan + "[OptionB]\n";
            }
            if (OptionC.isEmpty()){
                pemberitahuan = pemberitahuan + "[OptionC]\n";
            }
            if (OptionD.isEmpty()){
                pemberitahuan = pemberitahuan + "[OptionD]\n";
            }
            if (Pembahasan.isEmpty()){
                pemberitahuan = pemberitahuan + "[Pembahasan]\n";
            }
            pemberitahuan = pemberitahuan + "Data Tidak Tersimpan";
            Toast.makeText(inputsoal_menu.this, pemberitahuan, Toast.LENGTH_LONG).show();
        } else {
            root.child(IDSoal).setValue(IDSoal);
            root.child(IDSoal).child("Mata Pelajaran").setValue(Mata_Pelajaran);
            root.child(IDSoal).child("Materi").setValue(Materi);
            root.child(IDSoal).child("Kelas").setValue(Kelas);
            root.child(IDSoal).child("Soal").setValue(Soal);
            root.child(IDSoal).child("OptionA").setValue(OptionA);
            root.child(IDSoal).child("OptionB").setValue(OptionB);
            root.child(IDSoal).child("OptionC").setValue(OptionC);
            root.child(IDSoal).child("OptionD").setValue(OptionD);
            root.child(IDSoal).child("Pembahasan").setValue(Pembahasan);
            Toast.makeText(inputsoal_menu.this, "Data Tersimpan", Toast.LENGTH_LONG).show();
        }
    }

    public void gotoMenu(View view){
        Intent intent = new Intent(getApplicationContext(), main_menu.class);
        startActivity(intent);
        finish();
    }
}