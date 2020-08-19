package com.tiooooo.mymovie.data.rest;

import android.content.Context;
import android.util.Log;

import com.tiooooo.mymovie.BuildConfig;
import com.tiooooo.mymovie.data.rest.response.MovieResponse;
import com.tiooooo.mymovie.data.rest.response.TvSeriesResponse;
import com.tiooooo.mymovie.utils.EspressoIdlingResource;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiCall {
    private static ApiCall INSTANCE;
    private static ApiInterface apiClient = ApiClient.getClient().create(ApiInterface.class);
    private static final String TAG = ApiCall.class.getSimpleName();

    private Context context;

    public ApiCall(Context context) {
        this.context = context;
    }

    public static ApiCall getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new ApiCall(context);
        }

        return INSTANCE;
    }

    public LiveData<ApiResponse<List<MovieResponse>>> getMovies() {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<MovieResponse>>> listMovies = new MutableLiveData<>();
        Call<MovieResponse> movieResponseCall = apiClient.getMovies(BuildConfig.API_KEY);
        movieResponseCall.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.body() != null) {
                    listMovies.setValue(ApiResponse.success(response.body().getList()));
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.d(TAG,"Empty Data");
            }
        });

        EspressoIdlingResource.decrement();
        return listMovies;
    }

    public LiveData<ApiResponse<MovieResponse>> getMoviesDetail(String id) {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<MovieResponse>> movieDetail = new MutableLiveData<>();
        Call<MovieResponse> movieDetailResponseCall = apiClient.getMovieById(id, BuildConfig.API_KEY);
        movieDetailResponseCall.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.body() != null) {
                    movieDetail.setValue(ApiResponse.success(response.body()));
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.d(TAG,"Empty Data");
            }
        });

        EspressoIdlingResource.decrement();
        return movieDetail;
    }


    public LiveData<ApiResponse<List<TvSeriesResponse>>> getTvSeries() {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<TvSeriesResponse>>> listTvSeries = new MutableLiveData<>();
        Call<TvSeriesResponse> movieResponseCall = apiClient.getTvSeries(BuildConfig.API_KEY);
        movieResponseCall.enqueue(new Callback<TvSeriesResponse>() {
            @Override
            public void onResponse(Call<TvSeriesResponse> call, Response<TvSeriesResponse> response) {
                if (response.body() != null) {
                    listTvSeries.setValue(ApiResponse.success(response.body().getTvSeriesList()));
                }
            }

            @Override
            public void onFailure(Call<TvSeriesResponse> call, Throwable t) {
                Log.d(TAG,"Empty Data");
            }
        });

        EspressoIdlingResource.decrement();
        return listTvSeries;
    }

    public LiveData<ApiResponse<TvSeriesResponse>> getTvSeriesDetail(String id) {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<TvSeriesResponse>> tvSeriesDetail = new MutableLiveData<>();
        Call<TvSeriesResponse> tvSeriesResponseCall = apiClient.getTvSeriesById(id, BuildConfig.API_KEY);
        tvSeriesResponseCall.enqueue(new Callback<TvSeriesResponse>() {
            @Override
            public void onResponse(Call<TvSeriesResponse> call, Response<TvSeriesResponse> response) {
                if(response.body() != null);
                tvSeriesDetail.setValue(ApiResponse.success(response.body()));
            }

            @Override
            public void onFailure(Call<TvSeriesResponse> call, Throwable t) {
                Log.d(TAG,"Empty Data");
            }
        });

        EspressoIdlingResource.decrement();
        return tvSeriesDetail;
    }
}
