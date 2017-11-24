package com.example.queen.saediproject;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.queen.saediproject.Helper.DatabaseHelper;

import java.sql.Array;
import java.util.ArrayList;

public class list extends AppCompatActivity {/*
    DatabaseHelper databaseHelper;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        databaseHelper = new DatabaseHelper(this);
        listView = findViewById(R.id.listView);
        populateLIstView();
    }

    private void populateLIstView() {
        Cursor data = databaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while (data.moveToNext()){
                listData.add(data.getString(0));
        }
        ArrayAdapter itemAdapter = new ArrayAdapter<String>(this, R.layout.activity_list,data);
        listView.setAdapter(itemAdapter);
    }*/
}
