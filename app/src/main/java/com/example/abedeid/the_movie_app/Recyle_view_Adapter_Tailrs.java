package com.example.abedeid.the_movie_app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Abed Eid on 19/08/2016.
 */
public class Recyle_view_Adapter_Tailrs extends RecyclerView.Adapter<Recyle_view_Adapter_Tailrs.MyHolder> {

    List<Tailrs> movieList;
    Context context;

    public Recyle_view_Adapter_Tailrs(Context context, List<Tailrs> movieList) {
        this.movieList = movieList;
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tailr, null);
        return new MyHolder(view);

    }

    String Key;
    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {

        String name=movieList.get(position).getName();
         Key="https://www.youtube.com/watch?v="+movieList.get(position).getKey();
        holder.talirs.setText(name);
        Log.d("Soly",Key);
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(Key));
                intent = Intent.createChooser(intent, "Choose .. ");
                context.startActivity(intent);
            }
        });

//        poster = "http://image.tmdb.org/t/p/w320/" + movieList.get(position).getPosterPath();
//        Picasso.with(context).load(poster).into(holder.imageView);
//        holder.card.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent i = new Intent(context, details.class);
//                data_pass d=new data_pass(movieList.get(position).getId());
//                context.startActivity(i);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {
        TextView talirs;
        CardView card;

        public MyHolder(View itemView) {
            super(itemView);
            talirs = (TextView) itemView.findViewById(R.id.talirs);
            card = (CardView) itemView.findViewById(R.id.view_talirs);
        }
    }
}
