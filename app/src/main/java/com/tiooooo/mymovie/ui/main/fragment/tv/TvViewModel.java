package com.tiooooo.mymovie.ui.main.fragment.tv;

import com.tiooooo.mymovie.entity.tvseries.TvSeries;
import com.tiooooo.mymovie.utils.DataDummy;

import java.util.ArrayList;

import androidx.lifecycle.ViewModel;

public class TvViewModel extends ViewModel {
    public ArrayList<TvSeries> getTvSeries() {
        return DataDummy.getTvSeries();
    }
}
