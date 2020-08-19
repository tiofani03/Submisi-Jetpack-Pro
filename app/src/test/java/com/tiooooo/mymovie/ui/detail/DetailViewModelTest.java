package com.tiooooo.mymovie.ui.detail;

import com.tiooooo.mymovie.data.DataRepository;
import com.tiooooo.mymovie.data.local.entitiy.Movie;
import com.tiooooo.mymovie.data.local.entitiy.TvSeries;
import com.tiooooo.mymovie.data.rest.response.TvSeriesResponse;
import com.tiooooo.mymovie.utils.FakeDataDummy;
import com.tiooooo.mymovie.vo.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DetailViewModelTest {
    private DetailViewModel viewModel;
    private Movie dummyMovie = FakeDataDummy.generateDummyMovies().get(0);
    private TvSeriesResponse dummyTvSeries =FakeDataDummy.generateDummyTvSeries().get(0);
    private String movieID = dummyMovie.getId();
    private String tvSeriesID = dummyTvSeries.getId();

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private DataRepository dataRepository;

    @Mock
    private Observer<Resource<Movie>> movieObserver;

    @Mock
    private Observer<Resource<TvSeries>> tvSeriesObserver;

    @Before
    public void setUp(){
        viewModel = new DetailViewModel(dataRepository);
    }

    @Test
    public void getMovieDetails(){
        viewModel.setId(movieID);
        Resource<Movie> dummyCourseWithModule = Resource.success(FakeDataDummy.generateDummyMovie());
        MutableLiveData<Resource<Movie>> course = new MutableLiveData<>();
        course.setValue(dummyCourseWithModule);

        when(dataRepository.getMovieDetail(movieID)).thenReturn(course);

        viewModel.movieDetail.observeForever(movieObserver);

        verify(movieObserver).onChanged(dummyCourseWithModule);
    }

    @Test
    public void getTvSeriesDetail(){
        viewModel.setId(tvSeriesID);
        Resource<TvSeries> dummyCourseWithModule = Resource.success(FakeDataDummy.generateDummyTv());
        MutableLiveData<Resource<TvSeries>> course = new MutableLiveData<>();
        course.setValue(dummyCourseWithModule);

        when(dataRepository.getTvSeriesDetail(tvSeriesID)).thenReturn(course);

        viewModel.tvDetail.observeForever(tvSeriesObserver);

        verify(tvSeriesObserver).onChanged(dummyCourseWithModule);

    }

}