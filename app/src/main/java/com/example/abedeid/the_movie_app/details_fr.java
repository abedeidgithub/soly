package com.example.abedeid.the_movie_app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class details_fr extends Fragment {
    TextView title, Re, run, Vote, over;
    ImageView img;
    private final static String API_KEY = "78bf6a2ef253cfbbb8e3067ab8956a4b";
    int id;
    RecyclerView recyclerView,reviewers_view;
Button fa;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_details_fr, container, false);
        title = (TextView) view.findViewById(R.id.Title);
        Re = (TextView) view.findViewById(R.id.ReleasedTime);
        run = (TextView) view.findViewById(R.id.Time);
        Vote = (TextView) view.findViewById(R.id.VoteAverage);
        over = (TextView) view.findViewById(R.id.Overview);
        img = (ImageView) view.findViewById(R.id.image);
        recyclerView= (RecyclerView) view.findViewById(R.id.talirs_view);
        reviewers_view= (RecyclerView) view.findViewById(R.id.reviewers_view);
        fa= (Button) view.findViewById(R.id.favourite_Btn);
        id = data_pass.getId();
        ApiInterface api = ApiClient.getClient().create(ApiInterface.class);
        Call<MovieDetails> movieDetailsCall = api.get_Details(id, API_KEY);
        movieDetailsCall.enqueue(new Callback<MovieDetails>() {
            @Override
            public void onResponse(Call<MovieDetails> call, Response<MovieDetails> response) {
                title.setText(response.body().getOriginalTitle());
                Re.setText(response.body().getReleaseDate().substring(0, 4));
                Log.d("Soly", response.body().getReleaseDate().substring(0, 4));
                run.setText(response.body().getRuntime() + " min");
                Vote.setText(response.body().getVoteAverage() + "/10");
                over.setText(response.body().getOverview());
                String poster = "http://image.tmdb.org/t/p/w320/" + response.body().getPosterPath();
                Picasso.with(getContext()).load(poster).into(img);

            }

            @Override
            public void onFailure(Call<MovieDetails> call, Throwable t) {

            }
        });
        ApiInterface api_ = ApiClient.getClient().create(ApiInterface.class);
        Call<Re_T> gettalir = api_.gettalir(id, API_KEY);
        gettalir.enqueue(new Callback<Re_T>() {
            @Override
            public void onResponse(Call<Re_T> call, Response<Re_T> response) {
                List<Tailrs> tailrses = response.body().getResults();
                Recyle_view_Adapter_Tailrs adapter = new Recyle_view_Adapter_Tailrs(getContext(), tailrses);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));

            }

            @Override
            public void onFailure(Call<Re_T> call, Throwable t) {

            }
        });

        ///////////////
        ApiInterface api_1 = ApiClient.getClient().create(ApiInterface.class);
        Call<Re_Re> review = api_1.getReview(id, API_KEY);
        review.enqueue(new Callback<Re_Re>() {
            @Override
            public void onResponse(Call<Re_Re> call, Response<Re_Re> response) {
                List<RE> reList = response.body().getResults();
                Recyle_view_Adapter_Reviwers adapter = new Recyle_view_Adapter_Reviwers(getContext(), reList);
                reviewers_view.setAdapter(adapter);
                reviewers_view.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));

            }

            @Override
            public void onFailure(Call<Re_Re> call, Throwable t) {

            }
        });

        ///////////////
        fa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "will saved", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


}
