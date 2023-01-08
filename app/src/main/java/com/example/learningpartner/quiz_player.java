package com.example.learningpartner;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.learningpartner.activity.main_menu;

public class quiz_player extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionTextView;
    TextView questionTextView;
    Button option_a, option_b, option_c, option_d;
    Button submit_btn;

    int score=0;
    int totalQuestion = QuestionAnswer.question.size();
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_player);

        totalQuestionTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        option_a = findViewById(R.id.option_a);
        option_b = findViewById(R.id.option_b);
        option_c = findViewById(R.id.option_c);
        option_d = findViewById(R.id.option_d);
        submit_btn = findViewById(R.id.submit_btn);

        option_a.setOnClickListener(this);
        option_b.setOnClickListener(this);
        option_c.setOnClickListener(this);
        option_d.setOnClickListener(this);
        submit_btn.setOnClickListener(this);

        totalQuestionTextView.setText("Total question : " + totalQuestion);

        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {

        option_a.setBackgroundColor(Color.BLACK);
        option_b.setBackgroundColor(Color.BLACK);
        option_c.setBackgroundColor(Color.BLACK);
        option_d.setBackgroundColor(Color.BLACK);

        Button clickedButton = (Button) view;
        if (clickedButton.getId()==R.id.submit_btn){
            if (selectedAnswer.equals(QuestionAnswer.correctAnswers.get(currentQuestionIndex))){
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();
        } else {
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.GRAY);
        }

    }

    void loadNewQuestion(){
        if (currentQuestionIndex==totalQuestion){
            finishQuiz();
            return;
        }
        questionTextView.setText(QuestionAnswer.question.get(currentQuestionIndex));
        option_a.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        option_b.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        option_c.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        option_d.setText(QuestionAnswer.choices[currentQuestionIndex][3]);
    }

    void finishQuiz(){
        String passStatus = "";
        if (score > totalQuestion*0.60){
            passStatus = "Passed";
        } else {
            passStatus = "Failed";
        }

        new AlertDialog.Builder(this)
            .setTitle(passStatus)
            .setMessage("Score is " + score + " out of " + totalQuestion)
            .setPositiveButton("Restart", (dialogInterface, i) -> restartQuiz())
            .setCancelable(false)
            .show();
    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();

    }

    public void gotoMenu(View view){
        Intent intent = new Intent(getApplicationContext(), main_menu.class);
        startActivity(intent);
        finish();
    }


}