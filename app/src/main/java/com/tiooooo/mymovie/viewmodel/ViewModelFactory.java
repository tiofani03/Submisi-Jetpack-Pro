package com.tiooooo.mymovie.viewmodel;

import android.app.Application;

import com.tiooooo.mymovie.data.DataRepository;
import com.tiooooo.mymovie.di.Injection;
import com.tiooooo.mymovie.ui.detail.DetailViewModel;
import com.tiooooo.mymovie.ui.favorite.movie.MovieFavoriteViewModel;
import com.tiooooo.mymovie.ui.favorite.tv.TvSeriesFavoriteViewModel;
import com.tiooooo.mymovie.ui.main.movie.MovieViewModel;
import com.tiooooo.mymovie.ui.main.tv.TvSeriesViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile ViewModelFactory INSTANCE;

    private final DataRepository dataRepository;

    private ViewModelFactory(DataRepository academyRepository){
        this.dataRepository = academyRepository;
    }

    public static ViewModelFactory getInstance(Application context){
        if(INSTANCE == null){
            synchronized (ViewModelFactory.class){
                if(INSTANCE == null){
                    INSTANCE = new ViewModelFactory(Injection.provideRepository(context));
                }
            }
        }
        return INSTANCE;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MovieViewModel.class)) {
            return (T) new MovieViewModel(dataRepository);
        }else if(modelClass.isAssignableFrom(TvSeriesViewModel.class)){
            return (T) new TvSeriesViewModel(dataRepository);
        }else if(modelClass.isAssignableFrom(DetailViewModel.class)){
            return (T) new DetailViewModel(dataRepository);
        }else if(modelClass.isAssignableFrom(MovieFavoriteViewModel.class)){
            return (T) new MovieFavoriteViewModel(dataRepository);
        }else if(modelClass.isAssignableFrom(TvSeriesFavoriteViewModel.class)){
            return (T) new TvSeriesFavoriteViewModel(dataRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
