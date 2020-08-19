package com.tiooooo.mymovie.ui.main.fragment.movie;

import com.tiooooo.mymovie.data.DataRepository;
import com.tiooooo.mymovie.data.source.MovieResponse;
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
public class MovieViewModelTest {
    private MovieViewModel viewModel;
    private static final int FAKE_DATA_LENGTH = 1;
    //Karena saya memakai DataDummy dimana hanya memiliki 1 data saja

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private DataRepository dataRepository;

    @Mock
    private Observer<List<MovieResponse>> observer;

    @Before
    public void setUp(){
        viewModel = new MovieViewModel(dataRepository);
    }

    @Test
    public void getDataMovie(){
        ArrayList<MovieResponse> dummyMovies = FakeDataDummy.generateDummyMovies();
        MutableLiveData<List<MovieResponse>> movies = new MutableLiveData<>();
        movies.setValue(dummyMovies);

        when(dataRepository.getMovies()).thenReturn(movies);
        List<MovieResponse> movieResponses = viewModel.getMovies().getValue();
        verify(dataRepository).getMovies();
        assertNotNull(movieResponses);
        assertEquals(FAKE_DATA_LENGTH, movieResponses.size() );

        viewModel.getMovies().observeForever(observer);
        verify(observer).onChanged(dummyMovies);

    }


}