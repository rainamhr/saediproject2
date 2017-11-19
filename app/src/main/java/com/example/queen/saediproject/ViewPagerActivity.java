package com.example.queen.saediproject;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.queen.saediproject.Adapter.ViewPageAdapter;

public class ViewPagerActivity extends AppCompatActivity {
   private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        mViewPager = findViewById(R.id.viewPager);

        mViewPager.setAdapter(new ViewPageAdapter(getSupportFragmentManager()));

       // mViewPager.setPageTransformer(false, new IntroPageTransformer());
    }
}
