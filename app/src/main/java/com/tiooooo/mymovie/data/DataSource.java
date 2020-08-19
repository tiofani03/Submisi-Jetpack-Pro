package com.tiooooo.mymovie.data;

import com.tiooooo.mymovie.data.source.MovieResponse;
import com.tiooooo.mymovie.data.source.TvSeriesResponse;

import java.util.List;

import androidx.lifecycle.LiveData;

public interface DataSource {
    LiveData<List<MovieResponse>> getMovies();

    LiveData<List<TvSeriesResponse>> getTvSeries();

    LiveData<MovieResponse> getMovieDetail(int id);

    LiveData<TvSeriesResponse> getTvSeriesDetail(int id);
}
