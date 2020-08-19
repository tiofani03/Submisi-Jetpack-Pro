package com.tiooooo.mymovie.ui.main.movie;

import com.tiooooo.mymovie.data.DataRepository;
import com.tiooooo.mymovie.data.local.entitiy.Movie;
import com.tiooooo.mymovie.vo.Resource;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

public class MovieViewModel extends ViewModel {

    private DataRepository dataRepository;

    public MovieViewModel(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public LiveData<Resource<PagedList<Movie>>> getMovies() {
        return dataRepository.getMovies();
    }
}
