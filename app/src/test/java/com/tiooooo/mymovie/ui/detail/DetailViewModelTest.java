package com.tiooooo.mymovie.ui.detail;

import com.tiooooo.mymovie.entity.movie.Movie;
import com.tiooooo.mymovie.entity.tvseries.TvSeries;
import com.tiooooo.mymovie.utils.DataDummy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DetailViewModelTest {
    private DetailViewModel viewModel;
    private Movie dummyMovie = DataDummy.getMovies().get(0);
    private TvSeries dummyTvSeries = DataDummy.getTvSeries().get(0);
    private String movieID = dummyMovie.getId();
    private String tvSeriesID = dummyTvSeries.getId();

    @Before
    public void setUp(){
        viewModel = new DetailViewModel();
    }

    @Test
    public void getMovieDetails(){
        viewModel.setId(movieID);
        Movie movie = viewModel.getMovieDetails();
        assertNotNull(movie);
        assertEquals(dummyMovie.getId(),movie.getId());
        assertEquals(dummyMovie.getTitle(),movie.getTitle());
        assertEquals(dummyMovie.getVote_count(),movie.getVote_count());
        assertEquals(dummyMovie.getDesc(),movie.getDesc());
        assertEquals(dummyMovie.getPopularity(),movie.getPopularity());
    }

    @Test
    public void getTvSeriesDetail(){
        viewModel.setId(tvSeriesID);
        TvSeries tvSeries = viewModel.getTvSeriesDetails();
        assertNotNull(tvSeries);
        assertEquals(dummyTvSeries.getId(),tvSeries.getId());
        assertEquals(dummyTvSeries.getName(),tvSeries.getName());
        assertEquals(dummyTvSeries.getVote_count(),tvSeries.getVote_count());
        assertEquals(dummyTvSeries.getDesc(),tvSeries.getDesc());
        assertEquals(dummyTvSeries.getPopularity(),tvSeries.getPopularity());
    }


}