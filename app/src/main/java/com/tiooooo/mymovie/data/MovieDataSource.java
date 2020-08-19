package com.tiooooo.mymovie.data;

import com.tiooooo.mymovie.data.local.entitiy.Movie;
import com.tiooooo.mymovie.data.local.entitiy.TvSeries;
import com.tiooooo.mymovie.vo.Resource;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

public interface MovieDataSource {
    LiveData<Resource<PagedList<Movie>>> getMovies();

    LiveData<Resource<PagedList<TvSeries>>> getTvSeries();

    LiveData<Resource<Movie>> getMovieDetail(String  id);

    LiveData<Resource<TvSeries>> getTvSeriesDetail(String id);

    LiveData<PagedList<Movie>> getMovieFavorite();

    LiveData<PagedList<TvSeries>> getTvSeriesFavorite();

    void setMovieFavorite(Movie movie, Boolean state);

    void setTvSeriesFavorite(TvSeries tvSeries, Boolean state);


}
