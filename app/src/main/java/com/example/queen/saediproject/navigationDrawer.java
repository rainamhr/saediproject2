package com.example.queen.saediproject;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.queen.saediproject.Fragment.attendance;
import com.example.queen.saediproject.Fragment.collabs;
import com.example.queen.saediproject.Fragment.myPerformance;
import com.example.queen.saediproject.Fragment.myTasks;
import com.example.queen.saediproject.Utils.CustomTypefaceSpan;

public class navigationDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    NavigationView navigationView = null;
    Toolbar toolbar = null;
    Button mbtn_notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mbtn_notification = findViewById(R.id.btn_notification);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mbtn_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(navigationDrawer.this, Main2Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void Font(MenuItem mi){
            Typeface font = Typeface.createFromAsset(getAssets(), "fonts/MONTSERRAT_SEMIBOLD.TTF");
        SpannableString mNewTitle = new SpannableString(mi.getTitle());
        mNewTitle.setSpan(new CustomTypefaceSpan("" , font), 0 , mNewTitle.length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mi.setTitle(mNewTitle);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_mytasks) {
            myTasks Fragment = new myTasks();
            android.support.v4.app.FragmentTransaction fragmentTransaction=
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_contatiner, Fragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("My Tasks");
            Typeface font = Typeface.createFromAsset(getAssets(), "fonts/MONTSERRAT_SEMIBOLD.TTF");

        } else if (id == R.id.nav_attendance) {
            attendance Fragment = new attendance();
            android.support.v4.app.FragmentTransaction fragmentTransaction=
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_contatiner, Fragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Attendance");
            item.setChecked(true);

        } else if (id == R.id.nav_collabs) {
            collabs Fragment = new collabs();
            android.support.v4.app.FragmentTransaction fragmentTransaction=
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_contatiner, Fragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Collabs");
            item.setChecked(true);

        } else if (id == R.id.nav_performance) {
            myPerformance Fragment = new myPerformance();
            android.support.v4.app.FragmentTransaction fragmentTransaction=
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_contatiner, Fragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("My Performance");
            item.setChecked(true);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
