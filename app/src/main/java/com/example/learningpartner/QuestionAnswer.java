package com.example.learningpartner;

import java.util.ArrayList;

public class QuestionAnswer {
    public static ArrayList<String> question = new ArrayList<>();
    public static ArrayList<String> correctAnswers = new ArrayList<>();

    public void setQuestion(String[] listQuestion){
        for (int i=0; i < listQuestion.length; i++){
            this.question.add(listQuestion[i]);
        }
    }

    public void setCorrectAnswers(String[] listCorrectAnswer){
        for (int i=0; i < listCorrectAnswer.length; i++){
            this.question.add(listCorrectAnswer[i]);
        }
    }

    public static String choices[][]={
            {"Google", "Apple", "Nokia", "Samsung"},
            {"Java", "Kotlin", "Notepad", "Python"},
            {"Facebook", "WhatsApp", "Instagram", "Youtube"}
    };
}
