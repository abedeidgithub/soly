package com.example.abedeid.the_movie_app;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Abed Eid on 24/08/2016.
 */
public class Re_Re {
    @SerializedName("results")
    private List<RE> results;

    public List<RE> getResults() {
        return results;
    }

    public void setResults(List<RE> results) {
        this.results = results;
    }
}
