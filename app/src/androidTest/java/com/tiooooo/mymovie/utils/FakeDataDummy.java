package com.tiooooo.mymovie.utils;

import com.tiooooo.mymovie.data.source.MovieResponse;
import com.tiooooo.mymovie.data.source.TvSeriesResponse;

import java.util.ArrayList;

public class FakeDataDummy {
    public static ArrayList<MovieResponse> generateDummyMovies() {

        ArrayList<MovieResponse> movies = new ArrayList<>();

        movies.add(new MovieResponse(
                419704,
                "Ad Astra",
                "/xBHvZcjRiWyobQ9kxBhO6B2dtRI.jpg",
                "3427",
                6.0,
                "The near future, a time when both hope and hardships drive humanity to look to the stars and beyond. While a mysterious phenomenon menaces to destroy life on planet Earth, astronaut Roy McBride undertakes a mission across the immensity of space and its many perils to uncover the truth about a lost expedition that decades before boldly faced emptiness and silence in search of the unknown.",
                "2019-09-17",
                355.229
        ));
        return movies;
    }

    public static ArrayList<TvSeriesResponse> generateDummyTvSeries() {

        ArrayList<TvSeriesResponse> tvSeries = new ArrayList<>();

        tvSeries.add(new TvSeriesResponse(
                60735,
                "The Flash",
                "/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                "4442",
                7.3,
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "2014-10-07",
                183.162
        ));

        return tvSeries;
    }


}

