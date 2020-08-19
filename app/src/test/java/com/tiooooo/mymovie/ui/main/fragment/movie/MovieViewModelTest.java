package com.tiooooo.mymovie.ui.main.fragment.movie;

import com.tiooooo.mymovie.entity.movie.Movie;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MovieViewModelTest {
    private MovieViewModel viewModel;
    private static final int DATA_LENGTH = 10;

    @Before
    public void setUp(){
        viewModel = new MovieViewModel();
    }

    @Test
    public void getDataMovie(){
        ArrayList<Movie> movie = viewModel.getMovies();
        assertNotNull(movie);
        assertEquals(DATA_LENGTH,movie.size());
    }


}