package com.example.abedeid.the_movie_app;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Abed Eid on 19/08/2016.
 */
public class Recyle_view_Adapter_Reviwers extends RecyclerView.Adapter<Recyle_view_Adapter_Reviwers.MyHolder> {

    List<RE> movieList;
    Context context;

    public Recyle_view_Adapter_Reviwers(Context context, List<RE> movieList) {
        this.movieList = movieList;
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review, null);
        return new MyHolder(view);

    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {

        String name=movieList.get(position).getAuthor();
        String content=movieList.get(position).getContent();
        holder.author.setText(name);
        holder.content.setText(content);



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
        TextView author,content;
        CardView card;

        public MyHolder(View itemView) {
            super(itemView);
            author = (TextView) itemView.findViewById(R.id.author);
            content = (TextView) itemView.findViewById(R.id.content);
            card = (CardView) itemView.findViewById(R.id.view_reviews);
        }
    }
}
