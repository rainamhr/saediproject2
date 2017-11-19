package com.example.queen.saediproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.queen.saediproject.Fragment.startFragment;

public class mainSTartingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_starting);

      //  startActivity(new Intent(mainSTartingActivity.this,startFragment.class));
       // finish();
        Thread myThread = new Thread() {

            @SuppressLint("ResourceType")
            @Override
            public void run() {
                try {
                    sleep(3000);

                    Intent intent = new Intent(mainSTartingActivity.this, startFragment.class);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }
}
