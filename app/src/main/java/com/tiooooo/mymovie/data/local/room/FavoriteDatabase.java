package com.tiooooo.mymovie.data.local.room;

import android.content.Context;

import com.tiooooo.mymovie.data.local.entitiy.Movie;
import com.tiooooo.mymovie.data.local.entitiy.TvSeries;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {Movie.class, TvSeries.class},
        version = 1,
        exportSchema = false)
public abstract class FavoriteDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "db_Favorite";
    private static volatile FavoriteDatabase INSTANCE;

    public static FavoriteDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (FavoriteDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), FavoriteDatabase.class,
                            DATABASE_NAME).build();
                }
            }
        }

        return INSTANCE;
    }

    public abstract FavoriteDao favoriteDao();
}
