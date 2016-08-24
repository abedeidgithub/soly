package com.example.abedeid.the_movie_app;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Abed Eid on 24/08/2016.
 */
public class Re_T {
    @SerializedName("results")
    private List<Tailrs> results;

    public List<Tailrs> getResults() {
        return results;
    }

    public void setResults(List<Tailrs> results) {
        this.results = results;
    }
}
