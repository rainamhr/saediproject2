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

        Intent intent = new Intent(this, ViewPagerActivity.class);
        startActivity(intent);
        finish();
    }
}
