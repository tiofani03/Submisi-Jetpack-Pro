package com.tiooooo.mymovie.entity.movie;

import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("poster_path")
    private String img;

    @SerializedName("vote_count")
    private String vote_count;

    @SerializedName("vote_average")
    private Double vote_avg;

    @SerializedName("overview")
    private String desc;

    @SerializedName("release_date")
    private String release_date;

    @SerializedName("popularity")
    private Double popularity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getVote_count() {
        return vote_count;
    }

    public void setVote_count(String vote_count) {
        this.vote_count = vote_count;
    }

    public Double getVote_avg() {
        return vote_avg;
    }

    public void setVote_avg(Double vote_avg) {
        this.vote_avg = vote_avg;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }
}
