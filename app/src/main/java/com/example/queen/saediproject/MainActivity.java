package com.example.queen.saediproject;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    TextView mcreateAccount;
    TextView mfirstName;
    TextView mlastName;
    TextView mphoneNo;
    TextView maddress;
    Button mbtn_create;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mcreateAccount = findViewById(R.id.createAccount);
        mfirstName = findViewById(R.id.text_firstName);
        mlastName = findViewById(R.id.text_lastName);
        mphoneNo = findViewById(R.id.text_phone_no);
        maddress = findViewById(R.id.text_Address);
        mbtn_create = (Button) findViewById(R.id.btn_createProfile);

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/MONTSERRAT_SEMIBOLD.TTF");
        mcreateAccount.setTypeface(custom_font);

        Typeface custon_font_1 = Typeface.createFromAsset(getAssets(), "fonts/MONTSERRAT_REGULAR.TTF");
        mfirstName.setTypeface(custon_font_1);
        mlastName.setTypeface(custon_font_1);
        mphoneNo.setTypeface(custon_font_1);;
        maddress.setTypeface(custon_font_1);
        mbtn_create.setTypeface(custon_font_1);
        queue = Volley.newRequestQueue(this);

        mbtn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert();
                Intent intent = new Intent(MainActivity.this, navigationDrawer.class);
                startActivity(intent);
            }
        });

    }


}
