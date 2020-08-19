package com.tiooooo.mymovie.ui.main.fragment.movie;

import com.tiooooo.mymovie.data.DataRepository;
import com.tiooooo.mymovie.data.local.entitiy.Movie;
import com.tiooooo.mymovie.ui.main.movie.MovieViewModel;
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
public class MovieViewModelTest {
    private MovieViewModel viewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private DataRepository dataRepository;

    @Mock
    private Observer<Resource<PagedList<Movie>>> observer;

    @Mock
    private PagedList<Movie> pagedList;

    @Before
    public void setUp(){
        viewModel = new MovieViewModel(dataRepository);
    }

    @Test
    public void getDataMovie(){
        Resource<PagedList<Movie>> movies = Resource.success(pagedList);
        when(movies.data.size()).thenReturn(5);
        MutableLiveData<Resource<PagedList<Movie>>> movie = new MutableLiveData<>();
        movie.setValue(movies);

        when(dataRepository.getMovies()).thenReturn(movie);
        List<Movie> courseEntities = Objects.requireNonNull(viewModel.getMovies().getValue()).data;
        verify(dataRepository).getMovies();
        assertNotNull(courseEntities);
        assertEquals(5, courseEntities.size());

        viewModel.getMovies().observeForever(observer);
        verify(observer).onChanged(movies);

    }


}