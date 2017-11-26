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
import com.android.volley.toolbox.JsonObjectRequest;
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
        mbtnNextStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
                addData();
            }
        });
    }

    private void insertData() {
        final String email = meEmail.getText().toString().trim();
        final String password = mePassword.getText().toString().trim();
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Blank Field", Toast.LENGTH_LONG).show();
            Log.d("clickccc", "clickclick");
        } else {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("sharedPref", MODE_PRIVATE);
            String regId = pref.getString("regId", null);
            Log.e("token", "reg id: " + regId);

           // if (sharedPref.getInstance(this).getToken() == null) {
                Map<String, String> postParam = new HashMap<String, String>();
                postParam.put("username", "codemin");
                postParam.put("password", "admin@123");

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL, new JSONObject(postParam),
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    Toast.makeText(getApplicationContext(), response.getString("username"), Toast.LENGTH_LONG).show();
                                    meEmail.setText(response.getString("username"));
                                    mePassword.setText(response.getString("password"));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(loginActivity.this, "error", Toast.LENGTH_LONG).show();
                        Log.d("Error.Response", String.valueOf(error));
                    }
                });

                requestQueue.add(jsonObjectRequest);

            } /*else {
                Toast.makeText(this, "Token not generated", Toast.LENGTH_LONG).show();
            }
        }*/
    }

    //adding data in sqlite
    public void addData(){
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

   /* public void addToken(){
        boolean isInserted = databaseHelper.addToken(token.)
    }*/
}