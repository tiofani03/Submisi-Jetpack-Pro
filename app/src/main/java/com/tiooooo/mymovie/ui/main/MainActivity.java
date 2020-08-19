package com.tiooooo.mymovie.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.tiooooo.mymovie.R;
import com.tiooooo.mymovie.ui.main.fragment.movie.FragmentMovies;
import com.tiooooo.mymovie.ui.main.fragment.tv.FragmentTvSeries;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.smart_tab_layout)
    SmartTabLayout smartTabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add(R.string.movie, FragmentMovies.class)
                .add(R.string.tv_series, FragmentTvSeries.class)
                .create()
        );

        viewPager.setAdapter(adapter);
        smartTabLayout.setViewPager(viewPager);

        if(getSupportActionBar() != null){
            getSupportActionBar().setElevation(0);
        }

    }
}
