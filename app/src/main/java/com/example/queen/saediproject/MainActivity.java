package com.example.queen.saediproject;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Message;
import android.support.v7.app.AlertDialog;
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
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.queen.saediproject.Helper.DatabaseHelper;

import org.json.JSONArray;

import java.nio.charset.MalformedInputException;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    TextView mcreateAccount;
    TextView mfirstName, mefirstName;
    TextView mlastName, meLastName;
    TextView mphoneNo, mePhone;
    TextView maddress, maddress1, maddress2;
    Button mbtn_create;
    Button mbtn_view;
    RequestQueue queue;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mcreateAccount = findViewById(R.id.createAccount);
        mfirstName = findViewById(R.id.text_firstName);
        mefirstName = findViewById(R.id.editText_firstName);
        mlastName = findViewById(R.id.text_lastName);
        meLastName = findViewById(R.id.editText_lastName);
        mphoneNo = findViewById(R.id.text_phone_no);
        mePhone = findViewById(R.id.editText_phoneNo);
        maddress = findViewById(R.id.text_Address);
        maddress1 = findViewById(R.id.editText_address);
        maddress2 = findViewById(R.id.editText_city);
        mbtn_create = findViewById(R.id.btn_createProfile);
        mbtn_view = findViewById(R.id.btn_viewProfile);

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/MONTSERRAT_SEMIBOLD.TTF");
        mcreateAccount.setTypeface(custom_font);

        Typeface custon_font_1 = Typeface.createFromAsset(getAssets(), "fonts/MONTSERRAT_REGULAR.TTF");
        mfirstName.setTypeface(custon_font_1);
        mlastName.setTypeface(custon_font_1);
        mphoneNo.setTypeface(custon_font_1);;
        maddress.setTypeface(custon_font_1);
        mbtn_create.setTypeface(custon_font_1);
        queue = Volley.newRequestQueue(this);

        databaseHelper = new DatabaseHelper(this );

        addProfile();
        viewData();
    }

    public void addProfile(){
       mbtn_create.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this,navigationDrawer.class);
               startActivity(intent);
               boolean isInserted = databaseHelper.addProfile(mefirstName.getText().toString(),
                       meLastName.getText().toString(),
                       mePhone.getText().toString(),
                       maddress1.getText().toString(),
                       maddress2.getText().toString());
               if (isInserted == true)
                   Toast.makeText(MainActivity.this,"Profile successful",Toast.LENGTH_LONG).show();
               else{
                   Toast.makeText(MainActivity.this," Profile failed",Toast.LENGTH_LONG).show();

               }
           }
       });
    }

    public void viewData(){
        mbtn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Cursor res = databaseHelper.getData();
                Cursor res1 = databaseHelper.getProfile();
                Log.d("databasee","emter");
                if (res1.getCount()==0){
                    showMessage("Error", "Nothing found");
                        //Toast.makeText(MainActivity.this,"view", Toast.LENGTH_LONG).show();
                        return;
                }

                StringBuffer buffer  = new StringBuffer();
                while (res1.moveToNext()) {
                   /* buffer.append("ID :" + res.getString(0) + "\n");
                    buffer.append("Email :" + res.getString(0) + "\n");
                    buffer.append("Password :" + res.getString(0) + "\n");*/
                    buffer.append("First Name :" + res1.getString(3) + "\n");
                    buffer.append("Last Name :" + res1.getString(4) + "\n");
                    buffer.append("Phone :" + res1.getString(5) + "\n");
                    buffer.append("Address :" + res1.getString(6) + "\n");
                    buffer.append("City :" + res1.getString(7) + "\n");
                }
                showMessage("Data",buffer.toString());
            }
        });
    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.setCancelable(true);
    }
}
