package com.tiooooo.mymovie.ui.main.fragment.tv;

import com.tiooooo.mymovie.data.DataRepository;
import com.tiooooo.mymovie.data.local.entitiy.TvSeries;
import com.tiooooo.mymovie.ui.main.tv.TvSeriesViewModel;
import com.tiooooo.mymovie.vo.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Objects;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TvViewModelTest {
    private TvSeriesViewModel viewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private DataRepository dataRepository;

    @Mock
    private Observer<Resource<PagedList<TvSeries>>> observer;

    @Mock
    private PagedList<TvSeries> pagedList;

    @Before
    public void setUp() {
        viewModel = new TvSeriesViewModel(dataRepository);
    }

    @Test
    public void getDataTv() {
        Resource<PagedList<TvSeries>> dummyTvSeries = Resource.success(pagedList);
        when(dummyTvSeries.data.size()).thenReturn(5);
        MutableLiveData<Resource<PagedList<TvSeries>>> tvSeries = new MutableLiveData<>();
        tvSeries.setValue(dummyTvSeries);

        when(dataRepository.getTvSeries()).thenReturn(tvSeries);
        List<TvSeries> courseEntities = Objects.requireNonNull(viewModel.getTvSeries().getValue()).data;
        verify(dataRepository).getTvSeries();
        assertNotNull(courseEntities);
        assertEquals(5, courseEntities.size());

        viewModel.getTvSeries().observeForever(observer);
        verify(observer).onChanged(dummyTvSeries);
    }

}