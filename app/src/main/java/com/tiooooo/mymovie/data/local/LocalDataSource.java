package com.tiooooo.mymovie.data.local;

import com.tiooooo.mymovie.data.local.entitiy.Movie;
import com.tiooooo.mymovie.data.local.entitiy.TvSeries;
import com.tiooooo.mymovie.data.local.room.FavoriteDao;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;

public class LocalDataSource {
    private static LocalDataSource INSTANCE;
    private final FavoriteDao favoriteDao;

    public LocalDataSource(FavoriteDao favoriteDao) {
        this.favoriteDao = favoriteDao;
    }

    public static LocalDataSource getInstance(FavoriteDao mFavoriteDao) {
        if (INSTANCE == null) {
            INSTANCE = new LocalDataSource(mFavoriteDao);
        }
        return INSTANCE;
    }

    public DataSource.Factory<Integer, Movie> getAllMovie() {
        return favoriteDao.getAllMovie();
    }

    public DataSource.Factory<Integer, TvSeries> getAllTvSeries() {
        return favoriteDao.getAllTvSeries();
    }

    public DataSource.Factory<Integer, Movie> getMovieFavorite() {
        return favoriteDao.getMovieFavorite();
    }

    public DataSource.Factory<Integer, TvSeries> getTvSeriesFavorite() {
        return favoriteDao.getTvSeriesFavorite();
    }

    public LiveData<Movie> getMovieWithId(final String id) {
        return favoriteDao.getMovieById(id);
    }

    public LiveData<TvSeries> getTvSeriesWithId(final String id) {
        return favoriteDao.getTvSeriesById(id);
    }

    public void setMovieFavorite(Movie movieFavorite, Boolean newState) {
        movieFavorite.setBookmarked(newState);
        favoriteDao.updateMovie(movieFavorite);
    }

    public void updateMovieDetail(String id, String title, String img, String vote_count, Double vote_avg, String desc, String release_date, Double popularity){
        favoriteDao.updateDetailMovie(id,title,img,vote_count,vote_avg,desc,release_date,popularity);
    }

    public void updateTvSeriesDetail(String id, String name, String img, String vote_count, Double vote_avg, String desc, String first_air_date, Double popularity){
        favoriteDao.updateTvSeriesDetail(id,name,img,vote_count,vote_avg,desc,first_air_date,popularity);
    }

    public void setTvSeriesFavorite(TvSeries tvSeries, Boolean newState) {
        tvSeries.setBookmarked(newState);
        favoriteDao.updateTvSeries(tvSeries);
    }

    public void insertMovie(List<Movie> movies) {
        favoriteDao.insertMovieFavorite(movies);
    }

    public void insertTvSeries(List<TvSeries> tvSeries) {
        favoriteDao.insertTVFavorite(tvSeries);
    }

}
