package com.tiooooo.mymovie.ui.favorite;

import android.content.Context;

import com.tiooooo.mymovie.R;
import com.tiooooo.mymovie.ui.favorite.movie.FragmentMovieFavorite;
import com.tiooooo.mymovie.ui.favorite.tv.FragmentTvSeriesFavorite;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class SectionsPagerAdapter extends FragmentStatePagerAdapter {
    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.movie, R.string.tv_series};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new FragmentMovieFavorite();
        } else {
            return new FragmentTvSeriesFavorite();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return 2;
    }
}
