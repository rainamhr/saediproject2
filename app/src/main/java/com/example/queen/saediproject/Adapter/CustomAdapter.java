package com.example.queen.saediproject.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.queen.saediproject.API.Model.MainResponse;
import com.example.queen.saediproject.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by queen on 11/6/17.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyCustomViewHolder> {
    List<MainResponse> mainResponseList;
    Context context;

    public CustomAdapter(List<MainResponse> mainResponseList, Context context) {
        this.mainResponseList = mainResponseList;
        this.context = context;
    }

    @Override
    public MyCustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_display, parent, false);
        return new MyCustomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyCustomViewHolder holder, int position) {

        holder.title.setText(mainResponseList.get(position).getTitleResponse().getRenderedTitle());
        holder.description.setText(String.valueOf( Html.fromHtml(mainResponseList.get(position).getContentResponse().getRenderedContent()).toString()));
        Picasso.with(context).load(mainResponseList.get(position).getBetterFeaturedImage().getMediaDetails().getSizes().getMedium().getSourceUrl()).placeholder(R.drawable.object).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return mainResponseList.size();
    }

    public class MyCustomViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        TextView description;

        public MyCustomViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image1);
            title = itemView.findViewById(R.id.txt_title);
            description = itemView.findViewById(R.id.txt_description);
            description.setMovementMethod(new ScrollingMovementMethod());
        }
    }
}



