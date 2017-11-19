package com.example.queen.saediproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.queen.saediproject.Fragment.startFragment;

public class Main2Activity extends AppCompatActivity {
    TextView textabove;
    TextView textabove1;
    TextView textabove2;
    TextView text1;
    TextView text2;
    TextView text3;
    TextView text4;
    TextView text5;
    TextView gotohome;
    TextView letswork;
    Button mbutton;
    TextView mlbtn_1;
    TextView mlbtn_2;

    RelativeLayout relative_forHome;
    RelativeLayout relative_forwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
/*
        Thread myThread = new Thread() {

            @SuppressLint("ResourceType")
            @Override
            public void run() {
                try {
                    sleep(3000);

                    Intent intent = new Intent(Main2Activity.this, startFragment.class);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();*/

        textabove = findViewById(R.id.textabove);
        textabove1 = findViewById(R.id.textabove1);
        textabove2 = findViewById(R.id.textabove2);
        text1 = findViewById(R.id.text1);
        text2= findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);
        text5 = findViewById(R.id.text5);
        gotohome = findViewById(R.id.gotohome);
        letswork = findViewById(R.id.letswork);
        mbutton = findViewById(R.id.button);
        mlbtn_1 = findViewById(R.id.lbtn_1);
        mlbtn_2 = findViewById(R.id.lbtn_2);

        relative_forHome = findViewById(R.id.relative_forhome);
        relative_forwork = findViewById(R.id.relative_forwork);
        
        goHome();
        myFeeling();

        Typeface font = Typeface.createFromAsset(getAssets(),"fonts/fontawesomewebfont.ttf");
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/MONTSERRAT_LIGHT.TTF");

        mbutton.setTypeface(custom_font);
        textabove.setTypeface(custom_font);
        textabove1.setTypeface(custom_font);
        textabove2.setTypeface(custom_font);
        text1.setTypeface(custom_font);
        text2.setTypeface(custom_font);
        text3.setTypeface(custom_font);
        text4.setTypeface(custom_font);
        text5.setTypeface(custom_font);
        gotohome.setTypeface(custom_font);
        letswork.setTypeface(custom_font);

        mlbtn_1.setTypeface(font);
        mlbtn_2.setTypeface(font);

        mlbtn_1.setText("\uf015");
        mlbtn_2.setText("\uf02d");
    }

    private void myFeeling() {
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, MyFeeling.class);
                startActivity(intent);
            }
        });
    }

    private void goHome() {
        relative_forHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
