package com.tiooooo.mymovie.data.local.entitiy;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TvSeries implements Parcelable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private String id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "poster_path")
    private String img;

    @ColumnInfo(name = "vote_count")
    private String vote_count;

    @ColumnInfo(name = "vote_average")
    private Double vote_avg;

    @ColumnInfo(name = "overview")
    private String desc;

    @ColumnInfo(name = "first_air_date")
    private String first_air_date;

    @ColumnInfo(name = "popularity")
    private Double popularity;

    @ColumnInfo(name = "bookmarked")
    private boolean bookmarked = false;


    public TvSeries(String id, String name, String img, String vote_count, Double vote_avg, String desc, String first_air_date, Double popularity, boolean bookmarked) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.vote_count = vote_count;
        this.vote_avg = vote_avg;
        this.desc = desc;
        this.first_air_date = first_air_date;
        this.popularity = popularity;
        this.bookmarked = bookmarked;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
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

    public boolean isBookmarked() {
        return bookmarked;
    }

    public void setBookmarked(boolean bookmarked) {
        this.bookmarked = bookmarked;
    }

    protected TvSeries(Parcel in) {
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
    }

    public static final Creator<TvSeries> CREATOR = new Creator<TvSeries>() {
        @Override
        public TvSeries createFromParcel(Parcel in) {
            return new TvSeries(in);
        }

        @Override
        public TvSeries[] newArray(int size) {
            return new TvSeries[size];
        }
    };

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
    }
}
