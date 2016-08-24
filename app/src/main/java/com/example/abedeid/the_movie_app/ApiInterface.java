package com.example.abedeid.the_movie_app;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Abed Eid on 19/08/2016.
 */
public interface ApiInterface {
    @GET("movie/top_rated")
    Call<Result> get_Top_rated(@Query("api_key") String API_KEY);

    @GET("movie/popular")
    Call<Result> get_popular(@Query("api_key") String API_KEY);

    @GET("movie/{id}")
    Call<MovieDetails> get_Details(@Path("id") int id, @Query("api_key") String API_KEY);

    @GET("movie/{id}/videos")
    Call<Re_T> gettalir(@Path("id") int id, @Query("api_key") String API_KEY);

    @GET("movie/{id}/reviews")
    Call<Re_Re> getReview(@Path("id") int id, @Query("api_key") String API_KEY);


}
