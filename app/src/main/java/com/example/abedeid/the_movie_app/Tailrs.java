package com.example.abedeid.the_movie_app;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Abed Eid on 24/08/2016.
 */
public class Tailrs {
    @SerializedName("key")
    private String key;

    @SerializedName("name")
    private String name;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
