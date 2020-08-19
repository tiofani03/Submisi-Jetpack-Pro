package com.tiooooo.mymovie.ui.favorite.tv;

import com.tiooooo.mymovie.data.DataRepository;
import com.tiooooo.mymovie.data.local.entitiy.TvSeries;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

public class TvSeriesFavoriteViewModel extends ViewModel {
    private DataRepository dataRepository;

    public TvSeriesFavoriteViewModel(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public LiveData<PagedList<TvSeries>> getMovieFavorite(){
        return dataRepository.getTvSeriesFavorite();
    }


}
