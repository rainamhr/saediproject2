package com.example.queen.saediproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import com.example.queen.saediproject.Utils.sharedPref;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import rx.observers.TestObserver;

public class loginActivity extends AppCompatActivity {
    TextView mlogin;
    TextView memail;
    TextView mpassword;
    EditText meEmail;
    EditText mePassword;
    Button mbtnNextStep;

    RequestQueue requestQueue;
    String URL = "http://saediworks.co/vishal/anttodo/wp-json/jwt-auth/v1/token";

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mlogin = findViewById(R.id.txt_login);
        memail = findViewById(R.id.txt_email);
        mpassword = findViewById(R.id.text_password);
        meEmail = findViewById(R.id.editText_email);
        mePassword = findViewById(R.id.editText_password);
        mbtnNextStep = findViewById(R.id.btn_next_step);

        requestQueue = Volley.newRequestQueue(this);

        databaseHelper = new DatabaseHelper(this);

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/MONTSERRAT_SEMIBOLD.TTF");
        mlogin.setTypeface(custom_font);

        Typeface custom_font1 = Typeface.createFromAsset(getAssets(), "fonts/MONTSERRAT_REGULAR.TTF");
        memail.setTypeface(custom_font1);
        mpassword.setTypeface(custom_font1);
        mbtnNextStep.setTypeface(custom_font1);
        Log.d("activity","here");
        insertData();
        //addData();
    }

    private void insertData() {
        //PostCommentResponse.requestStarted();
    /*    final String email = meEmail.getText().toString().trim();
        final String password = mePassword.getText().toString().trim();*/

       // Log.d("Tesasdast", email + " " + password);
        Log.d("Tesast", "I am here");
/*
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Blank Field", Toast.LENGTH_LONG).show();
        } else {*/
            // if (sharedPref.getInstance(this).getToken() != null) {
            final StringRequest postRequest = new StringRequest(Request.Method.POST, URL,
                    new Response.Listener<String>() {
                        public void onResponse(String response) {
                            Log.d("response", response);
                           /* try {
                                Log.d("Tesast", "I am here");
                                JSONObject obj = new JSONObject(response);
                                Log.d("enter", response);
                                Toast.makeText(getApplicationContext(), obj.getString("username"), Toast.LENGTH_LONG).show();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }*/
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(loginActivity.this, "error", Toast.LENGTH_LONG).show();
                            Log.d("Error.Response", String.valueOf(error));
                        }
                    }
            ) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    String userEmail = meEmail.getText().toString();
                    String userPassword = mePassword.getEditableText().toString();
                    Log.e("DATA", "MAP");
                    //params.put("token", sharedPref.getInstance(getApplicationContext()).getToken());
                    params.put("username", userEmail);
                    params.put("password ", userPassword);

                    return params;
                }

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("Content-Type", "application/x-www-form-urlencoded");
                    return params;
                }
            };
            requestQueue.add(postRequest);
        }
    /*else {
                Toast.makeText(this, "Token not generated", Toast.LENGTH_LONG).show();
            }*/


    public void addData(){
        mbtnNextStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginActivity.this,MainActivity.class);
                startActivity(intent);
               boolean isInserted =  databaseHelper.addData(meEmail.getText().toString(),
                       mePassword.getText().toString());
               if (isInserted == true)
                   Toast.makeText(loginActivity.this,"successful",Toast.LENGTH_LONG).show();
               else{
                   Toast.makeText(loginActivity.this,"failed",Toast.LENGTH_LONG).show();

               }
            }
        });
    }
}
