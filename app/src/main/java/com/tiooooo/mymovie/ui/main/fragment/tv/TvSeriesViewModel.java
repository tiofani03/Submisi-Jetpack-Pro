package com.tiooooo.mymovie.ui.main.fragment.tv;

import com.tiooooo.mymovie.data.DataRepository;
import com.tiooooo.mymovie.data.source.TvSeriesResponse;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class TvSeriesViewModel extends ViewModel {
    private DataRepository dataRepository;

    public TvSeriesViewModel(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public LiveData<List<TvSeriesResponse>> getTvSeries(){
        return dataRepository.getTvSeries();
    }
}
