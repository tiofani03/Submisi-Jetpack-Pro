package com.tiooooo.mymovie.data;

import com.tiooooo.mymovie.data.local.LocalDataSource;
import com.tiooooo.mymovie.data.local.entitiy.Movie;
import com.tiooooo.mymovie.data.local.entitiy.TvSeries;
import com.tiooooo.mymovie.data.rest.ApiCall;
import com.tiooooo.mymovie.data.rest.ApiResponse;
import com.tiooooo.mymovie.data.rest.NetworkBoundResource;
import com.tiooooo.mymovie.data.rest.response.MovieResponse;
import com.tiooooo.mymovie.data.rest.response.TvSeriesResponse;
import com.tiooooo.mymovie.utils.AppExecutors;
import com.tiooooo.mymovie.vo.Resource;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

public class DataRepository implements MovieDataSource {

    private volatile static DataRepository INSTANCE = null;
    private ApiCall apiCall;
    private final LocalDataSource localDataSource;
    private final AppExecutors appExecutors;

    private DataRepository(@NonNull ApiCall apiCall, @NonNull LocalDataSource localDataSource, AppExecutors appExecutors) {
        this.apiCall = apiCall;
        this.localDataSource = localDataSource;
        this.appExecutors = appExecutors;
    }

    public static DataRepository getInstance(ApiCall apiCall, LocalDataSource localDataSource, AppExecutors appExecutors) {
        if (INSTANCE == null) {
            synchronized (DataRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DataRepository(apiCall, localDataSource, appExecutors);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<Resource<PagedList<Movie>>> getMovies() {
        return new NetworkBoundResource<PagedList<Movie>, List<MovieResponse>>(appExecutors) {

            @Override
            protected LiveData<PagedList<Movie>> loadFromDB() {
                PagedList.Config config = new PagedList.Config.Builder()
                        .setEnablePlaceholders(false)
                        .setInitialLoadSizeHint(4)
                        .setPageSize(4)
                        .build();

                return new LivePagedListBuilder<>(localDataSource.getAllMovie(),config).build();
            }

            @Override
            protected Boolean shouldFetch(PagedList<Movie> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<MovieResponse>>> createCall() {
                return apiCall.getMovies();
            }

            @Override
            protected void saveCallResult(List<MovieResponse> data) {
                ArrayList<Movie> listMovie = new ArrayList<>();
                for (MovieResponse response : data) {
                    Movie movie = new Movie(response.getId(),
                            response.getTitle(),
                            response.getImg(),
                            response.getVote_count(),
                            response.getVote_avg(),
                            response.getDesc(),
                            response.getRelease_date(),
                            response.getPopularity(),
                            false);

                    listMovie.add(movie);
                }

                localDataSource.insertMovie(listMovie);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<PagedList<TvSeries>>> getTvSeries() {
        return new NetworkBoundResource<PagedList<TvSeries>,List<TvSeriesResponse>>(appExecutors){

            @Override
            protected LiveData<PagedList<TvSeries>> loadFromDB() {
                PagedList.Config config = new PagedList.Config.Builder()
                        .setEnablePlaceholders(false)
                        .setInitialLoadSizeHint(4)
                        .setPageSize(4)
                        .build();

                return new LivePagedListBuilder<>(localDataSource.getAllTvSeries(),config).build();
            }

            @Override
            protected Boolean shouldFetch(PagedList<TvSeries> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<TvSeriesResponse>>> createCall() {
                return apiCall.getTvSeries();
            }

            @Override
            protected void saveCallResult(List<TvSeriesResponse> data) {
                ArrayList<TvSeries> listTvSeries = new ArrayList<>();
                for(TvSeriesResponse response:data){
                    TvSeries tvSeries = new TvSeries(response.getId(),
                            response.getName(),
                            response.getImg(),
                            response.getVote_count(),
                            response.getVote_avg(),
                            response.getDesc(),
                            response.getFirst_air_date(),
                            response.getPopularity(),
                            false
                            );

                    listTvSeries.add(tvSeries);
                }

                localDataSource.insertTvSeries(listTvSeries);
            }
        }.asLiveData();

    }

    @Override
    public LiveData<Resource<Movie>> getMovieDetail(String id) {
        return new NetworkBoundResource<Movie,MovieResponse>(appExecutors){


            @Override
            protected LiveData<Movie> loadFromDB() {
                return localDataSource.getMovieWithId(id);
            }

            @Override
            protected Boolean shouldFetch(Movie data) {
                return data.getTitle() == null;
            }

            @Override
            protected LiveData<ApiResponse<MovieResponse>> createCall() {
                return apiCall.getMoviesDetail(id);
            }

            @Override
            protected void saveCallResult(MovieResponse data) {
                localDataSource.updateMovieDetail(data.getId(),
                        data.getTitle(),
                        data.getImg(),
                        data.getVote_count(),
                        data.getVote_avg(),
                        data.getDesc(),
                        data.getRelease_date(),
                        data.getPopularity());
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<TvSeries>> getTvSeriesDetail(String id) {
        return new NetworkBoundResource<TvSeries,TvSeriesResponse>(appExecutors){

            @Override
            protected LiveData<TvSeries> loadFromDB() {
                return localDataSource.getTvSeriesWithId(id);
            }

            @Override
            protected Boolean shouldFetch(TvSeries data) {
                return data.getName() == null;
            }

            @Override
            protected LiveData<ApiResponse<TvSeriesResponse>> createCall() {
                return apiCall.getTvSeriesDetail(id);
            }

            @Override
            protected void saveCallResult(TvSeriesResponse data) {
                localDataSource.updateTvSeriesDetail(data.getId(),
                        data.getName(),
                        data.getImg(),
                        data.getVote_count(),
                        data.getVote_avg(),
                        data.getDesc(),
                        data.getFirst_air_date(),
                        data.getPopularity());
            }
        }.asLiveData();
    }

    @Override
    public LiveData<PagedList<Movie>> getMovieFavorite() {
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(4)
                .setPageSize(4)
                .build();

        return new LivePagedListBuilder<>(localDataSource.getMovieFavorite(),config).build();
    }

    @Override
    public LiveData<PagedList<TvSeries>> getTvSeriesFavorite() {
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(4)
                .setPageSize(4)
                .build();

        return new LivePagedListBuilder<>(localDataSource.getTvSeriesFavorite(),config).build();
    }


    @Override
    public void setMovieFavorite(Movie movie, Boolean state) {
        appExecutors.diskIO().execute(() -> localDataSource.setMovieFavorite(movie, state));
    }

    @Override
    public void setTvSeriesFavorite(TvSeries tvSeries, Boolean state) {
        appExecutors.diskIO().execute(() -> localDataSource.setTvSeriesFavorite(tvSeries, state));
    }

}
