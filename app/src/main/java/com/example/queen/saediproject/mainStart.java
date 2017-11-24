package com.example.queen.saediproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.queen.saediproject.Fragment.startFragment;

public class mainStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_start);
        /*Intent intent = new Intent(this, ViewPagerActivity.class);
        startActivity(intent);
        finish();*/

        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent intent = new Intent(mainStart.this, ViewPagerActivity.class);
        startActivity(intent);
        finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}
