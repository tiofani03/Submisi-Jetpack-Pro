package com.tiooooo.mymovie.data.source;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TvSeriesResponse {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("poster_path")
    private String img;

    @SerializedName("vote_count")
    private String vote_count;

    @SerializedName("vote_average")
    private Double vote_avg;

    @SerializedName("overview")
    private String desc;

    @SerializedName("first_air_date")
    private String first_air_date;

    @SerializedName("popularity")
    private Double popularity;

    @SerializedName("results")
    private ArrayList<TvSeriesResponse> tvSeriesList;


    public TvSeriesResponse(int id, String name, String img, String vote_count, Double vote_avg, String desc, String first_air_date, Double popularity) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.vote_count = vote_count;
        this.vote_avg = vote_avg;
        this.desc = desc;
        this.first_air_date = first_air_date;
        this.popularity = popularity;
    }

    public TvSeriesResponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getFirst_air_date() {
        return first_air_date;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public ArrayList<TvSeriesResponse> getTvSeriesList() {
        return tvSeriesList;
    }

    public void setTvSeriesList(ArrayList<TvSeriesResponse> tvSeriesList) {
        this.tvSeriesList = tvSeriesList;
    }
}
