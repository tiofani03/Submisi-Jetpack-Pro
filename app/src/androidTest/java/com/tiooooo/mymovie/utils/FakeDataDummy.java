package com.tiooooo.mymovie.utils;

import com.tiooooo.mymovie.data.rest.response.MovieResponse;
import com.tiooooo.mymovie.data.rest.response.TvSeriesResponse;

import java.util.ArrayList;

public class FakeDataDummy {
    public static ArrayList<MovieResponse> generateDummyMovies() {

        ArrayList<MovieResponse> movies = new ArrayList<>();

        movies.add(new MovieResponse(
                "554993",
                "Britt-Marie Was Here",
                "/1Duc3EBiegywczxTWekvy03HWai.jpg",
                "12",
                5.4,
                "Britt-Marie, a woman in her sixties, decides to leave her husband and start anew. Having been housewife for most of her life and and living in small backwater town of Borg, there isn't many jobs available and soon she finds herself fending a youth football team.",
                "2019-01-25",
                351.307
        ));
        return movies;
    }

    public static ArrayList<TvSeriesResponse> generateDummyTvSeries() {

        ArrayList<TvSeriesResponse> tvSeries = new ArrayList<>();

        tvSeries.add(new TvSeriesResponse(
                "60735",
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

