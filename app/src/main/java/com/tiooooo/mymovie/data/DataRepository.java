package com.tiooooo.mymovie.data;

import com.tiooooo.mymovie.data.source.MovieResponse;
import com.tiooooo.mymovie.data.source.TvSeriesResponse;
import com.tiooooo.mymovie.rest.ApiCall;

import java.util.List;

import androidx.lifecycle.LiveData;

public class DataRepository implements DataSource {

    private volatile static DataRepository INSTANCE = null;
    private ApiCall apiCall;

    public DataRepository(ApiCall apiCall) {
        this.apiCall = apiCall;
    }

    public static DataRepository getInstance(ApiCall apiCall) {
        if (INSTANCE == null) {
            synchronized (DataRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DataRepository(apiCall);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<List<MovieResponse>> getMovies() {
        return apiCall.getMovies();
    }

    @Override
    public LiveData<List<TvSeriesResponse>> getTvSeries() {
        return apiCall.getTvSeries();
    }

    @Override
    public LiveData<MovieResponse> getMovieDetail(int id) {
        return apiCall.getMoviesDetail(id);
    }

    @Override
    public LiveData<TvSeriesResponse> getTvSeriesDetail(int id) {
        return apiCall.getTvSeriesDetail(id);
    }
}
