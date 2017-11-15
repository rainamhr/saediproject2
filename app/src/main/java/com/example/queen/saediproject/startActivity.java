package com.example.queen.saediproject;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

public class startActivity extends AppCompatActivity {
    TextView mpercent;
    TextView mfind;
    private GestureDetectorCompat detectorCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //overridePendingTransition(R.anim.slide_in_left,R.anim.slide_in_right);

        mpercent = findViewById(R.id.percent);
        mfind = findViewById(R.id.find);

        detectorCompat = new GestureDetectorCompat(this, new LearnGesture());

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/MONTSERRAT_SEMIBOLD.TTF");
        mpercent.setTypeface(custom_font);

        Typeface custom_font1 = Typeface.createFromAsset(getAssets(), "fonts/MONTSERRAT_REGULAR.TTF");
        mfind.setTypeface(custom_font1);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        detectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class LearnGesture extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            if (e2.getX() > e1.getX()) {

            } else
                if (e2.getX() < e1.getX()) {
                    Intent intent = new Intent(startActivity.this, welcomePageActivity.class);
                    finish();
                    startActivity(intent);
            }
            return true;
        }
    }
}