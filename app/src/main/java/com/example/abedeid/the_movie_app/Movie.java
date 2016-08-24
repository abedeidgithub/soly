package com.example.abedeid.the_movie_app;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Abed Eid on 19/08/2016.
 */
public class Movie {

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("id")
    private Integer id;

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public Integer getId() {
        return id;
    }
}
