package com.tiooooo.mymovie.data.rest.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class TvSeriesResponse implements Parcelable {


    @SerializedName("id")
    private String id;

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


    public TvSeriesResponse(String id, String name, String img, String vote_count, Double vote_avg, String desc, String first_air_date, Double popularity) {
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

    protected TvSeriesResponse(Parcel in) {
        id = in.readString();
        name = in.readString();
        img = in.readString();
        vote_count = in.readString();
        if (in.readByte() == 0) {
            vote_avg = null;
        } else {
            vote_avg = in.readDouble();
        }
        desc = in.readString();
        first_air_date = in.readString();
        if (in.readByte() == 0) {
            popularity = null;
        } else {
            popularity = in.readDouble();
        }
        tvSeriesList = in.createTypedArrayList(TvSeriesResponse.CREATOR);
    }

    public static final Creator<TvSeriesResponse> CREATOR = new Creator<TvSeriesResponse>() {
        @Override
        public TvSeriesResponse createFromParcel(Parcel in) {
            return new TvSeriesResponse(in);
        }

        @Override
        public TvSeriesResponse[] newArray(int size) {
            return new TvSeriesResponse[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getVote_count() {
        return vote_count;
    }

    public Double getVote_avg() {
        return vote_avg;
    }

    public String getDesc() {
        return desc;
    }

    public String getFirst_air_date() {
        return first_air_date;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(img);
        parcel.writeString(vote_count);
        if (vote_avg == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(vote_avg);
        }
        parcel.writeString(desc);
        parcel.writeString(first_air_date);
        if (popularity == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(popularity);
        }
        parcel.writeTypedList(tvSeriesList);
    }
}
