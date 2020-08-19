package com.tiooooo.mymovie.rest;

import com.tiooooo.mymovie.data.source.MovieResponse;
import com.tiooooo.mymovie.data.source.TvSeriesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("discover/movie")
    Call<MovieResponse> getMovies(
            @Query("api_key") String apiKey
    );

    @GET("movie/{movie_id}")
    Call<MovieResponse> getMovieById(
            @Path("movie_id") int id,
            @Query("api_key") String apiKey
    );

    @GET("discover/tv")
    Call<TvSeriesResponse> getTvSeries(
            @Query("api_key") String apiKey
    );


    @GET("tv/{tv_id}")
    Call<TvSeriesResponse> getTvSeriesById(
            @Path("tv_id") int id,
            @Query("api_key") String apiKey);
}
