package com.tiooooo.mymovie.di;

import android.content.Context;

import com.tiooooo.mymovie.data.DataRepository;
import com.tiooooo.mymovie.data.local.LocalDataSource;
import com.tiooooo.mymovie.data.local.room.FavoriteDatabase;
import com.tiooooo.mymovie.data.rest.ApiCall;
import com.tiooooo.mymovie.utils.AppExecutors;

public class Injection {
    public static DataRepository provideRepository(Context context) {
        ApiCall networkCall = ApiCall.getInstance(context);
        FavoriteDatabase database = FavoriteDatabase.getInstance(context);

        LocalDataSource localDataSource = LocalDataSource.getInstance(database.favoriteDao());
        AppExecutors appExecutors = new AppExecutors();

        return DataRepository.getInstance(networkCall, localDataSource, appExecutors);
    }
}

