package com.example.queen.saediproject;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class welcomePageActivity extends AppCompatActivity {
    Button mbtn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        mbtn_login = findViewById(R.id.btn_login);

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/MONTSERRAT_REGULAR.TTF");
        mbtn_login.setTypeface(custom_font);

        mbtn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(welcomePageActivity.this, loginActivity.class);
                startActivity(intent);
            }
        });
    }
}
