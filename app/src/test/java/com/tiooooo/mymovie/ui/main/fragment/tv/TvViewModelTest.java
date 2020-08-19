package com.tiooooo.mymovie.ui.main.fragment.tv;

import com.tiooooo.mymovie.data.DataRepository;
import com.tiooooo.mymovie.data.source.TvSeriesResponse;
import com.tiooooo.mymovie.utils.FakeDataDummy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TvViewModelTest {
    private TvSeriesViewModel viewModel;
    private final static int FAKE_DATA_LENGTH = 1;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private DataRepository dataRepository;

    @Mock
    private Observer<List<TvSeriesResponse>> observer;

    @Before
    public void setUp(){
        viewModel  = new TvSeriesViewModel(dataRepository);
    }

    @Test
    public void getDataTv(){
        ArrayList<TvSeriesResponse> dummyTvSeries = FakeDataDummy.generateDummyTvSeries();
        MutableLiveData<List<TvSeriesResponse>> tvSeries = new MutableLiveData<>();
        tvSeries.setValue(dummyTvSeries);

        when(dataRepository.getTvSeries()).thenReturn(tvSeries);
        List<TvSeriesResponse> tvSeriesResponses = viewModel.getTvSeries().getValue();
        verify(dataRepository).getTvSeries();
        assertNotNull(tvSeriesResponses);
        assertEquals(FAKE_DATA_LENGTH,tvSeriesResponses.size());

        viewModel.getTvSeries().observeForever(observer);
        verify(observer).onChanged(dummyTvSeries);
    }

}