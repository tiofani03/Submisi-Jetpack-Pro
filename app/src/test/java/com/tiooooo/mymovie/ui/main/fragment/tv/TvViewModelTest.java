package com.tiooooo.mymovie.ui.main.fragment.tv;

import com.tiooooo.mymovie.entity.tvseries.TvSeries;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TvViewModelTest {
    private TvViewModel viewModel;
    private final static int DATA_LENGTH = 10;

    @Before
    public void setUp(){
        viewModel  = new TvViewModel();
    }

    @Test
    public void getDataTv(){
        ArrayList<TvSeries> tvSeries = viewModel.getTvSeries();
        assertNotNull(tvSeries);
        assertEquals(DATA_LENGTH,tvSeries.size());
    }

}