package com.techtastic.minditup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class Act6_Meditation extends AppCompatActivity {
    TextView time;
    Button timestartbtn,timepausebtn,timeresetbtn;
    private  static final long START_TIME_IN_MILLIS = 120000;
    CountDownTimer countDownTimer;
    boolean timerRunning;
    long timeLeft= START_TIME_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act6_meditation);

        time=findViewById(R.id.time);
        timestartbtn=findViewById(R.id.timestartbtn);
//        timepausebtn=findViewById(R.id.timepausebtn);
        timeresetbtn=findViewById(R.id.timeresetbtn);

        timestartbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(timerRunning){
                    pauseTimer();
                }else {
                    startTimer();
                }
            }
        });
        timeresetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
        updateCountDownText();

    }

    private  void startTimer(){
        countDownTimer=new CountDownTimer(timeLeft,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeft=millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timerRunning=false;
                timestartbtn.setText("START");
                timeLeft=START_TIME_IN_MILLIS;
                updateCountDownText();
            }
        }.start();

        timerRunning=true;
        timestartbtn.setText("PAUSE");

    }

    private void updateCountDownText(){
        int minute=(int) (timeLeft/1000)/60;
        int seconds=(int) (timeLeft/1000)%60;

        String timeLeftString = String.format(Locale.getDefault(),"%02d:%02d",minute,seconds);
        time.setText(timeLeftString);
    }

    private void pauseTimer(){
        countDownTimer.cancel();
        timerRunning=false;
        timestartbtn.setText("START");
    }

    private void resetTimer(){
        timeLeft=START_TIME_IN_MILLIS;
        updateCountDownText();
    }

}