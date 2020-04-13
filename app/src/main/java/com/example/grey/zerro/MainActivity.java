package com.example.grey.zerro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
TextView proba;
    CountDownTimer t;
    int testcheck = 1488;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
proba =findViewById(R.id.textView);
proba.setText("WWWWWWWWWWWWWWW");
    }

    public void qwerty(View view) {
        proba.setText("qqqqqqqqq");
        long maxTimeInMilliseconds = 120000;// in your case

        startTimer(maxTimeInMilliseconds, 1000);
    }

    public void startTimer(final long finish, long tick) {
       if(t!=null){
           t.cancel();
           t=null;
       }

        t = new CountDownTimer(finish, tick) {

            public void onTick(long millisUntilFinished) {
                long remainedSecs = millisUntilFinished / 1000;
                proba.setText("" + (remainedSecs / 60) + ":" + (remainedSecs % 60));// manage it accordign to you
            }

            public void onFinish() {
                proba.setText("00:00:00");
                Toast.makeText(MainActivity.this, "Finish", Toast.LENGTH_SHORT).show();

                cancel();
            }
        }.start();


    }
}
