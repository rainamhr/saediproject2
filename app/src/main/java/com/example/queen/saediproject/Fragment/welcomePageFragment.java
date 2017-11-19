package com.example.queen.saediproject.Fragment;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.queen.saediproject.Main2Activity;
import com.example.queen.saediproject.MainActivity;
import com.example.queen.saediproject.R;
import com.example.queen.saediproject.loginActivity;

/**
 * Created by queen on 11/18/17.
 */

public class welcomePageFragment extends Fragment {
    TextView termsand;
    Button mbtn_login;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.activity_welcome_page,null);
        mbtn_login = (Button) view.findViewById(R.id.button_login);
        termsand = view.findViewById(R.id.terms);
        termsand.setPaintFlags(termsand.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        mbtn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), loginActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
