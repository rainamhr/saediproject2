package com.example.queen.saediproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {
    String imageUrl, title, description;
    @BindView(R.id.description_textview)
    TextView descriptionTextView;
    @BindView(R.id.title_textview)
    TextView titleTextView;
    @BindView(R.id.picture_imageview)
    ImageView pictureImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            imageUrl = bundle.getString("imageURL");
            title = bundle.getString("title");
            description = bundle.getString("description");
        }
        Log.d("imageurl", imageUrl);

        Picasso.with(this).load(imageUrl).into(pictureImageView);
        titleTextView.setText(title);
        descriptionTextView.setMovementMethod(new ScrollingMovementMethod());
        descriptionTextView.setText(String.valueOf(Html.fromHtml(description).toString()));
    }


}
