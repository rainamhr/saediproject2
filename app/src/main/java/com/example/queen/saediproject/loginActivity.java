package com.example.queen.saediproject;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class loginActivity extends AppCompatActivity {
    TextView mlogin;
    TextView memail;
    TextView mpassword;
    EditText meEmail;
    EditText mePassword;
    Button mbtnNextStep;

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


        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/MONTSERRAT_SEMIBOLD.TTF");
        mlogin.setTypeface(custom_font);

        Typeface custom_font1 = Typeface.createFromAsset(getAssets(),  "fonts/MONTSERRAT_REGULAR.TTF");
        memail.setTypeface(custom_font1);
        mpassword.setTypeface(custom_font1);
        mbtnNextStep.setTypeface(custom_font1);

        mbtnNextStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
