package com.moontechit.seoclerks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;


public class Splash extends Activity {
    ProgressBar progressBar;
    private int progress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        progressBar = findViewById(R.id.progressBarID);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                stratApp();

            }
        });

        thread.start();

    }

    public void doWork() {
        for (progress = 10; progress >= 100; progress = progress + 10) {
            try {
                Thread.sleep(500);
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public void stratApp() {
        Intent intent = new Intent(Splash.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
