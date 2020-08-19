package com.tiooooo.mymovie.ui.detail;

import com.tiooooo.mymovie.entity.movie.Movie;
import com.tiooooo.mymovie.entity.tvseries.TvSeries;
import com.tiooooo.mymovie.utils.DataDummy;

import java.util.ArrayList;

import androidx.lifecycle.ViewModel;

public class DetailViewModel extends ViewModel {
    private String id;
    private Movie movie;
    private TvSeries tvSeries;

    Movie getMovieDetails() {
        ArrayList<Movie> movieArrayList = new ArrayList<>(DataDummy.getMovies());
        for (int i = 0; i < movieArrayList.size(); i++) {
            Movie mEntity = movieArrayList.get(i);
            if (mEntity.getId().equals(id)) {
                movie = mEntity;
            }
        }

        return movie;
    }

    TvSeries getTvSeriesDetails() {
        ArrayList<TvSeries> tvSeriesArrayList = new ArrayList<>(DataDummy.getTvSeries());
        for (int i = 0; i < tvSeriesArrayList.size(); i++) {
            TvSeries mEntity = tvSeriesArrayList.get(i);
            if (mEntity.getId().equals(id)) {
                tvSeries = mEntity;
            }
        }
        return tvSeries;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
