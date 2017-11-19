package com.example.queen.saediproject.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GestureDetectorCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.queen.saediproject.R;

/**
 * Created by queen on 11/18/17.
 */

public class startFragment extends Fragment {
    ImageView mpercent;
    ImageView mfind;
    private GestureDetectorCompat detectorCompat;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_start,null);
    }
}
