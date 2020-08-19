package com.tiooooo.mymovie.ui.detail;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.tiooooo.mymovie.R;
import com.tiooooo.mymovie.data.local.entitiy.Movie;
import com.tiooooo.mymovie.data.local.entitiy.TvSeries;
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
    public static final String EXTRA_FAVORITE = "extra_favorite";
    public static final String EXTRA_ROOM = "extra_favorite";

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

    DetailViewModel detailViewModel;
    private Menu menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        ViewModelFactory factory = ViewModelFactory.getInstance(this.getApplication());
        detailViewModel = new ViewModelProvider(this, factory).get(DetailViewModel.class);

        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            int type = getIntent().getIntExtra(EXTRA_CATEGORY, 0);
            String id = getIntent().getStringExtra(EXTRA_MOVIE);
            showLoading(true);

            switch (type) {
                case 1:
                    detailViewModel.setId(id);
                    favorite(1);
                    setFavorite(1);
                    detailViewModel.movieDetail.observe(this, movieResource -> {
                        if (movieResource != null) {
                            switch (movieResource.status) {
                                case LOADING:
                                    showLoading(true);
                                    break;

                                case SUCCESS:
                                    if (movieResource.data != null) {
                                        showLoading(false);
                                        setDataMovie(movieResource.data);
                                    }
                                    break;

                                case ERROR:
                                    showLoading(false);
                                    Toast.makeText(this, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
                                    break;
                            }
                        }
                    });

                    break;

                case 2:
                    detailViewModel.setId(id);
                    favorite(2);
                    setFavorite(2);
                    detailViewModel.tvDetail.observe(this, tvSeriesResource -> {
                        if(tvSeriesResource != null){
                            switch (tvSeriesResource.status){
                                case LOADING:
                                    showLoading(true);
                                    break;

                                case SUCCESS:
                                    if(tvSeriesResource.data != null){
                                        showLoading(false);
                                        setDataTVSeries(tvSeriesResource.data);
                                    }
                                    break;

                                case ERROR:
                                    showLoading(false);
                                    Toast.makeText(this, "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                                    break;
                            }
                        }
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

    private void setDataMovie(Movie movies) {
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

    private void setDataTVSeries(TvSeries tvSeries) {

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

    private void favorite(int type){
        if(type == 1){
            detailViewModel.movieDetail.observe(this, movieResource -> {
                if(movieResource != null){
                    switch (movieResource.status){
                        case LOADING:
                            showLoading(true);
                            break;

                        case SUCCESS:
                            if(movieResource.data != null){
                                showLoading(false);
                                boolean status = movieResource.data.isBookmarked();
                                setButtonFavorite(status);
                            }
                            break;

                        case ERROR:
                            showLoading(false);
                            Toast.makeText(this, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });

        }else{
            detailViewModel.tvDetail.observe(this, tvSeriesResource -> {
                if(tvSeriesResource != null){
                    switch (tvSeriesResource.status){
                        case LOADING:
                            showLoading(true);
                            break;

                        case SUCCESS:
                            if(tvSeriesResource.data != null){
                                showLoading(false);
                                boolean status = tvSeriesResource.data.isBookmarked();
                                setButtonFavorite(status);
                            }
                            break;

                        case ERROR:
                            showLoading(false);
                            Toast.makeText(this, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });

        }
    }

    private void setButtonFavorite(boolean status) {
        if(menu == null) return;
        MenuItem menuItem = menu.findItem(R.id.action_favorite);
        if(status){
            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white));
        }else{
            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_n_favorite_white));
        }
    }

    private void setFavorite(int type) {
        if(type == 1){
                detailViewModel.setMovieFavorite();
        }else{
                detailViewModel.setTvSeriesFavorite();
        }
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }else if(item.getItemId() == R.id.action_favorite){
            int type = getIntent().getIntExtra(EXTRA_CATEGORY, 0);
            setFavorite(type);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        this.menu = menu;
        int type = getIntent().getIntExtra(EXTRA_CATEGORY, 0);
        favorite(type);

        return true;
    }
}
