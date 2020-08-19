package com.tiooooo.mymovie.ui.detail;

import com.tiooooo.mymovie.data.DataRepository;
import com.tiooooo.mymovie.data.local.entitiy.Movie;
import com.tiooooo.mymovie.data.local.entitiy.TvSeries;
import com.tiooooo.mymovie.vo.Resource;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class DetailViewModel extends ViewModel {
    private MutableLiveData<String> id = new MutableLiveData<>();
    private DataRepository repository;


    public DetailViewModel(DataRepository repository) {
        this.repository = repository;
    }

    public LiveData<Resource<Movie>> movieDetail = Transformations.switchMap(id,
            mId -> repository.getMovieDetail(mId));


    public LiveData<Resource<TvSeries>> tvDetail = Transformations.switchMap(id,
            mId -> repository.getTvSeriesDetail(mId));


    public String getId() {
        return id.getValue();
    }

    public void setId(String id) {
        this.id.setValue(id);
    }

    void setMovieFavorite() {
        if (movieDetail.getValue() != null) {
            Movie movie = movieDetail.getValue().data;
            assert movie != null;
            final boolean newState = !movie.isBookmarked();
            repository.setMovieFavorite(movie, newState);
        }
    }

    void setTvSeriesFavorite() {
        if (tvDetail.getValue() != null) {
            TvSeries tvSeries = tvDetail.getValue().data;
            assert tvSeries != null;
            final boolean newState = !tvSeries.isBookmarked();
            repository.setTvSeriesFavorite(tvSeries, newState);
        }
    }
}



