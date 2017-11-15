package com.example.queen.saediproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.queen.saediproject.API.Client.Client;
import com.example.queen.saediproject.API.Model.MainResponse;
import com.example.queen.saediproject.Adapter.CustomAdapter;
import com.example.queen.saediproject.Utils.RecyclerItemClickListener;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by sikshya on 11/9/17.
 */

public class display2 extends AppCompatActivity {

    Client client;
    Subscription subscription;
    List<MainResponse> mainResponseList;
    RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display2);
        progressDialog = new ProgressDialog(this);
        progressDialog.show();
        progressDialog.setMessage("Loading...");
        recyclerView = findViewById(R.id.recyclerview_layout2);
        client = Client.Factory.create();

        subscription = client.getMainResponseList("100", "")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<List<MainResponse>>() {
                    @Override
                    public void onCompleted() {

                        recyclerView.setAdapter(new CustomAdapter(mainResponseList, getApplicationContext()));
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        progressDialog.hide();
                        recyclerView.addOnItemTouchListener(
                                new RecyclerItemClickListener(display2.this, new RecyclerItemClickListener.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(View view, int position) {
                                        Intent intentToDetailsActivity = new Intent(display2.this,DetailsActivity.class);
                                         intentToDetailsActivity.putExtra("imageURL",mainResponseList.get(position).getBetterFeaturedImage().getMediaDetails().getSizes().getMedium().getSourceUrl());
                                        intentToDetailsActivity.putExtra("title",mainResponseList.get(position).getTitleResponse().getRenderedTitle());
                                        intentToDetailsActivity.putExtra("description",mainResponseList.get(position).getContentResponse().getRenderedContent());
                                        startActivity(intentToDetailsActivity);
                                    }
                                })
                        );
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("error man", String.valueOf(e.getCause()));
                    }

                    @Override
                    public void onNext(List<MainResponse> mainResponses) {
                        display2.this.mainResponseList = mainResponses;
                    }
                });
    }
}
