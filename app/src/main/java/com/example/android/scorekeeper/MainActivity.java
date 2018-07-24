package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreA = 0;
    int scoreB = 0;
    int setPointA = 0;
    int setPointB = 0;
    int breakPointA = 0;
    int breakPointB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void closeIntro(View v) {
        ScrollView scrolView = findViewById(R.id.introScrollView);
        Button resetButton = findViewById(R.id.resetButton);
        resetButton.setVisibility(View.VISIBLE);
        scrolView.setVisibility(View.GONE);
    }

    public void breakA (View v){
        breakPointA= breakPointA+1;
        displayBreakA(breakPointA);
    }

    public void displayA(int score) {
        TextView scoreAView = findViewById(R.id.teamA_score);
        scoreAView.setText(String.valueOf(score));
    }

    public void displaySetPointA(int setPoint) {
        TextView setPointAView = findViewById(R.id.teamA_set_point);
        setPointAView.setText(String.valueOf(setPoint));
    }

    public void displayWinnerOrLoserA(String status) {
        TextView setPointAView = findViewById(R.id.teamA_score);
        setPointAView.setText(String.valueOf(status));
    }

    public void displayBreakA(int breakPoint){
        TextView breakPointA= findViewById(R.id.teamA_break);
        breakPointA.setText(String.valueOf(breakPoint));
    }



    public void pointA(View v) {
        scoreA = scoreA + 1;
        if (setPointA == 2 && setPointB == 2 && scoreA >= 15 && ((scoreA - 1) != scoreB) && scoreA > scoreB) {
            setPointA = setPointA + 1;
            displayWinnerOrLoserA("Winner");
            displayWinnerOrLoserB("Loser");
            displaySetPointB(setPointA);
        } else if (scoreA >= 25 && ((scoreA - 1) != scoreB) && scoreA > scoreB) {
            scoreA = 0;
            scoreB = 0;
            setPointA = setPointA + 1;
            if (setPointA > 3) {
                displayWinnerOrLoserA("Winner");
                displayWinnerOrLoserB("Loser");
            } else {
                displayA(scoreA);
                displayB(scoreB);
                displaySetPointA(setPointA);
            }
        } else {
            displayA(scoreA);
        }
    }

    //Display team b score
    public void displayB(int score) {
        TextView scoreAView = findViewById(R.id.teamB_score);
        scoreAView.setText(String.valueOf(score));
    }

    public void breakB (View v){
        breakPointB= breakPointB+1;
        displayBreakB(breakPointB);
    }
    public void displayBreakB(int breakPoint){
        TextView breakPointB= findViewById(R.id.teamB_break);
        breakPointB.setText(String.valueOf(breakPoint));
    }

    //display team b set point
    public void displaySetPointB(int setPoint) {
        TextView setPointAView = findViewById(R.id.teamB_set_point);
        setPointAView.setText(String.valueOf(setPoint));
    }

    public void displayWinnerOrLoserB(String status) {
        TextView setPointAView = findViewById(R.id.teamB_score);
        setPointAView.setText(String.valueOf(status));
    }

    public void pointB(View v) {
        scoreB = scoreB + 1;
        if (setPointA == 2 && setPointB == 2 && scoreB >= 15 && ((scoreB - 1) != scoreA) && scoreB > scoreA) {
            setPointB = setPointB + 1;
            displayWinnerOrLoserA("Loser");
            displayWinnerOrLoserB("Winner");
            displaySetPointB(setPointB);
        } else if (scoreB >= 25 && ((scoreB - 1) != scoreA) && scoreB > scoreA) {
            scoreA = 0;
            scoreB = 0;
            setPointB = setPointB + 1;
            if (setPointB > 3) {
                displayWinnerOrLoserA("Loser");
                displayWinnerOrLoserB("Winner");
            } else {
                displayA(scoreA);
                displayB(scoreB);
                displaySetPointB(setPointB);
            }
        } else {
            displayB(scoreB);
        }
    }

    public void reset(View v) {
        scoreA = 0;
        scoreB = 0;
        setPointB = 0;
        setPointA = 0;
        breakPointA=0;
        breakPointB=0;
        displaySetPointA(setPointA);
        displaySetPointB(setPointB);
        displayA(scoreA);
        displayB(scoreB);
        displayBreakA(breakPointA);
        displayBreakB(breakPointB);
    }
}

