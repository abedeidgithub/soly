package com.example.abedeid.the_movie_app;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Abed Eid on 19/08/2016.
 */
public class RE {



    @SerializedName("author")
    private String author;

    @SerializedName("content")
    private String content;


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

