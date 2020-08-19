package com.tiooooo.mymovie.data.local.room;


import com.tiooooo.mymovie.data.local.entitiy.Movie;
import com.tiooooo.mymovie.data.local.entitiy.TvSeries;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface FavoriteDao {

    @Query("SELECT * from movie")
    DataSource.Factory<Integer,Movie> getAllMovie();

    @Query("SELECT * from tvseries")
    DataSource.Factory<Integer,TvSeries> getAllTvSeries();

    @Query("SELECT * FROM movie WHERE bookmarked = 1 ")
    DataSource.Factory<Integer, Movie> getMovieFavorite();

    @Query("SELECT * FROM tvseries where bookmarked = 1")
    DataSource.Factory<Integer, TvSeries> getTvSeriesFavorite();

    @Query("SELECT * from movie WHERE id = :id")
    LiveData<Movie> getMovieById(String id);

    @Query("SELECT * from tvseries WHERE id = :id")
    LiveData<TvSeries> getTvSeriesById(String id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertMovieFavorite(List<Movie> movies);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertTVFavorite(List<TvSeries> tvSeries);

    @Query("UPDATE movie SET title = :title, poster_path = :img ,vote_count = :vote_count ," +
            "vote_average = :vote_avg, overview =:desc, release_date = :release_date, popularity = :popularity" +
            "  WHERE id = :id")
    void updateDetailMovie(String id, String title, String img, String vote_count, Double vote_avg, String desc, String release_date, Double popularity);

    @Query("UPDATE tvseries SET name = :title, poster_path = :img ,vote_count = :vote_count ," +
            "vote_average = :vote_avg, overview =:desc, first_air_date = :release_date, popularity = :popularity" +
            "  WHERE id = :id")
    void updateTvSeriesDetail(String id, String title, String img, String vote_count, Double vote_avg, String desc, String release_date, Double popularity);

    @Update
    void updateMovie(Movie movie);

    @Update
    void updateTvSeries(TvSeries tvSeries);
}
