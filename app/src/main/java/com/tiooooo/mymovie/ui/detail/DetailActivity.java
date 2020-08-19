package com.tiooooo.mymovie.ui.detail;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.tiooooo.mymovie.R;
import com.tiooooo.mymovie.data.source.MovieResponse;
import com.tiooooo.mymovie.data.source.TvSeriesResponse;
import com.tiooooo.mymovie.viewmodel.ViewModelFactory;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "Movies";
    public static final String EXTRA_CATEGORY = "extra_category";

    @BindView(R.id.tv_title_detail)
    TextView tvTitle;
    @BindView(R.id.tv_desc_detail)
    TextView tvDesc;
    @BindView(R.id.tv_release_detail)
    TextView tvRelease;
    @BindView(R.id.tv_popularity_detail)
    TextView tvPopularity;
    @BindView(R.id.tv_title)
    TextView tvTitleCollapse;
    @BindView(R.id.rb_rating_detail)
    RatingBar rbRating;
    @BindView(R.id.img_photo_detail)
    ImageView imgMovie;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.shimmerFrameLayout)
    ShimmerFrameLayout shimmerFrameLayout;
    @BindView(R.id.constraint_detail)
    ConstraintLayout constraintLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        ViewModelFactory factory = ViewModelFactory.getInstance(this.getApplication());
        DetailViewModel detailViewModel = new ViewModelProvider(this, factory).get(DetailViewModel.class);

        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            int type = getIntent().getIntExtra(EXTRA_CATEGORY, 0);
            int id = getIntent().getIntExtra(EXTRA_MOVIE, 0);
            showLoading(true);

            switch (type) {
                case 1:
                    detailViewModel.setId(id);
                    detailViewModel.getMovieDetails().observe(this, movieResponse -> {
                        showLoading(false);
                        setDataMovie(movieResponse);
                    });

                    break;

                case 2:
                    detailViewModel.setId(id);
                    detailViewModel.getTvSeriesDetails().observe(this, tvSeriesResponse -> {
                        showLoading(false);
                        setDataTVSeries(tvSeriesResponse);
                    });

                    break;
            }
        }

    }

    private void setCollapsing(final String title) {
        final CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(" ");
        tvTitleCollapse.setText(" ");
        collapsingToolbarLayout.setCollapsedTitleTextColor(ContextCompat.getColor(this, R.color.white));
        AppBarLayout appBarLayout = findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.BaseOnOffsetChangedListener() {

            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + i == 0) {
                    collapsingToolbarLayout.setTitle(title);
                    tvTitleCollapse.setText(title);

                    isShow = true;
                } else if (isShow) {
                    collapsingToolbarLayout.setTitle(" ");
                    tvTitleCollapse.setText(" ");
                    isShow = false;
                }
            }
        });
    }

    private String changeFormatDate(String date) {
        String[] splitDate = date.split("-");
        String part1 = splitDate[0];
        int part2 = Integer.parseInt(splitDate[1]);
        String part3 = splitDate[2];
        String[] month = getResources().getStringArray(R.array.month);

        String monthConvert = "month";

        for (int i = 1; i <= 12; i++) {
            if (i == part2) {
                monthConvert = month[i - 1];
            }
        }

        return part3 + " " + monthConvert + " " + part1;
    }

    private void setDataMovie(MovieResponse movies) {
        setCollapsing(movies.getTitle());
        String popularity = Double.toString(movies.getPopularity());
        Double rating = movies.getVote_avg() / 2;
        String rate = String.valueOf(rating);
        String date = movies.getRelease_date();
        if (!date.equals("")) {
            date = changeFormatDate(movies.getRelease_date());
        }
        tvRelease.setText(date);

        String img = "https://image.tmdb.org/t/p/w500/" + movies.getImg();

        tvTitle.setText(movies.getTitle());
        rbRating.setRating(Float.parseFloat(rate));

        Glide.with(this)
                .load(img)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error).fitCenter())
                .into(imgMovie);


        if (movies.getDesc().equals("")) {
            String desc = getResources().getString(R.string.no_desc);
            tvDesc.setText(desc);
        } else {
            tvDesc.setText(movies.getDesc());
        }

        tvPopularity.setText(popularity);

    }

    private void setDataTVSeries(TvSeriesResponse tvSeries) {

        setCollapsing(tvSeries.getName());
        String popularity = Double.toString(tvSeries.getPopularity());
        Double rating = tvSeries.getVote_avg() / 2;
        String rate = String.valueOf(rating);

        String img = "https://image.tmdb.org/t/p/w500/" + tvSeries.getImg();

        tvTitle.setText(tvSeries.getName());
        rbRating.setRating(Float.parseFloat(rate));


        Glide.with(this)
                .load(img)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error).centerCrop())
                .into(imgMovie);

        if (tvSeries.getDesc().equals("")) {
            String desc = getResources().getString(R.string.no_desc);
            tvDesc.setText(desc);
        } else {
            tvDesc.setText(tvSeries.getDesc());
        }

        tvRelease.setText(tvSeries.getFirst_air_date());
        tvPopularity.setText(popularity);

    }

    private void showLoading(Boolean state) {
        if (state) {
            constraintLayout.setVisibility(View.GONE);
            shimmerFrameLayout.setVisibility(View.VISIBLE);
            shimmerFrameLayout.startShimmer();
        } else {
            shimmerFrameLayout.stopShimmer();
            shimmerFrameLayout.setVisibility(View.GONE);
            constraintLayout.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
