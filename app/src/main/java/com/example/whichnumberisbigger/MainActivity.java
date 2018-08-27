package com.example.whichnumberisbigger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textviewScore;
    private Button buttonLeft;
    private Button buttonRight;
    private int score;
    private int leftNum;
    private int rightNum;
    public static final int MAX_NUM = 1000;
    public static final int MIN_NUM = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //wires the widget: connects XML to java
        score = 0;
        wirewidgets();
        updateDisplay();

    }

    private void wirewidgets() {
        textviewScore = findViewById(R.id.textView_main_Score);
        buttonLeft = findViewById(R.id.button_main_Left);
        buttonRight = findViewById(R.id.button_main_Right);
    }

    public void updateDisplay() {
        String scoreString = getResources().getString((R.string.main_Score));
        textviewScore.setText(scoreString + score);
        randomizeNumbers();
        buttonLeft.setText(String.valueOf(leftNum));
        buttonRight.setText(String.valueOf(rightNum));
    }

    private void randomizeNumbers() {

        leftNum = genNumber();
       rightNum = genNumber();
        if (leftNum == rightNum) ;
        {
            rightNum = genNumber();
        }
    }

    private int genNumber()
    {
        int range = MAX_NUM - MIN_NUM + 1;
        return MIN_NUM + (int)(Math.random() * range);
    }

    public void onLeftClick(View view) {

        if (leftNum > rightNum) {
            score++;
            textviewScore.setText(String.valueOf(score));
            Toast.makeText(this, "Good Job!", Toast.LENGTH_SHORT).show();
        } else {
            score--;
            textviewScore.setText(String.valueOf(score));
            Toast.makeText(this, "Try Again!", Toast.LENGTH_SHORT).show();

        }
        updateDisplay();
    }

    public void onRightClick(View view) {


        if (rightNum > leftNum) {
            score++;
            textviewScore.setText(String.valueOf(score));
            Toast.makeText(this, "Good Job!", Toast.LENGTH_SHORT).show();
        } else {
            score--;
            textviewScore.setText(String.valueOf(score));
            Toast.makeText(this, "Try Again!", Toast.LENGTH_SHORT).show();
        }
        updateDisplay();
    }
}
