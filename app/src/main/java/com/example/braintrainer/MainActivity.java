package com.example.braintrainer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.TabHost;
import android.widget.TextView;
import androidx.gridlayout.widget.GridLayout;

import java.util.concurrent.ThreadLocalRandom;


public class MainActivity extends AppCompatActivity {
    TextView timerTextView;
    TextView quesTextView;
    TextView solvedTextView;

    GridLayout gridLayout;

    Button goButton;
    Button button1;
    Button button2;
    Button button3;
    Button button4;

    int num1,num2,op1,op2,op3,ansOpt;
    String num1String, num2String, op1String, op2String, op3String;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void quesGenerator() {
        num1 = ThreadLocalRandom.current().nextInt(1,100+1);
        num2 = ThreadLocalRandom.current().nextInt(1,100+1);
        op1 = ThreadLocalRandom.current().nextInt(2,200+1);
        op2 = ThreadLocalRandom.current().nextInt(2,100+1);
        op3 = ThreadLocalRandom.current().nextInt(2,100+1);
        ansOpt = ThreadLocalRandom.current().nextInt(1,4+1);

        num1String = String.valueOf(num1);
        num2String = String.valueOf(num2);
        op1String = String.valueOf(op1);
        op2String = String.valueOf(op2);
        op3String = String.valueOf(op3);

        quesTextView.setText(num1String+" + "+num2String+" = ?");

        if(ansOpt==1) {
            button1.setText(String.valueOf(num1+num2));
            button2.setText(String.valueOf(op1));
            button3.setText(String.valueOf(op2));
            button4.setText(String.valueOf(op3));
        } else if(ansOpt==2) {
            button2.setText(String.valueOf(num1+num2));
            button1.setText(String.valueOf(op1));
            button3.setText(String.valueOf(op2));
            button4.setText(String.valueOf(op3));
        } else if(ansOpt==3) {
            button3.setText(String.valueOf(num1+num2));
            button2.setText(String.valueOf(op1));
            button1.setText(String.valueOf(op2));
            button4.setText(String.valueOf(op3));
        } else {
            button4.setText(String.valueOf(num1+num2));
            button2.setText(String.valueOf(op1));
            button3.setText(String.valueOf(op2));
            button1.setText(String.valueOf(op3));
        }

    }

    public void checkAns() {
        if(ansOpt==1) {

        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onGo(View view) {
        goButton.setText("reset!");
        timerTextView.setVisibility(View.VISIBLE);
        quesTextView.setVisibility(View.VISIBLE);
        solvedTextView.setVisibility(View.VISIBLE);

        gridLayout.setVisibility(View.VISIBLE);

        quesGenerator();


        new CountDownTimer(31000, 1000) {


            public void onTick(long milliSecondsLeft) {

                int secondsLeft = (int) milliSecondsLeft/1000;

                String secondsLeftString = String.valueOf(secondsLeft);

                timerTextView.setText(secondsLeftString+"s");


            }

            public void onFinish() {


            }
        }.start();



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerTextView = findViewById(R.id.timerTextView);
        quesTextView = findViewById(R.id.quesTextView);
        solvedTextView = findViewById(R.id.solvedTextView);
        gridLayout = findViewById(R.id.gridLayout);
        goButton = findViewById(R.id.goButton);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
    }
}