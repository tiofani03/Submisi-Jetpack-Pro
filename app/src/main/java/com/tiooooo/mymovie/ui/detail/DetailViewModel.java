package com.tiooooo.mymovie.ui.detail;

import com.tiooooo.mymovie.data.DataRepository;
import com.tiooooo.mymovie.data.source.MovieResponse;
import com.tiooooo.mymovie.data.source.TvSeriesResponse;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class DetailViewModel extends ViewModel {
    private int id;
    private DataRepository repository;

    public DetailViewModel(DataRepository repository) {
        this.repository = repository;
    }

    public LiveData<MovieResponse> getMovieDetails() {
        return repository.getMovieDetail(id);
    }

    public LiveData<TvSeriesResponse> getTvSeriesDetails() {
        return repository.getTvSeriesDetail(id);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
