package com.tiooooo.mymovie.ui.main;

import com.tiooooo.mymovie.R;
import com.tiooooo.mymovie.entity.movie.Movie;
import com.tiooooo.mymovie.entity.tvseries.TvSeries;
import com.tiooooo.mymovie.utils.DataDummy;

import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.action.ViewActions.swipeRight;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest {

    private ArrayList<Movie> dummyMovies = DataDummy.getMovies();
    private ArrayList<TvSeries> dummyTvSeries = DataDummy.getTvSeries();


    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void swipePage() {
        onView(withId(R.id.viewpager))
                .check(matches(isDisplayed()));

        onView(withId(R.id.viewpager))
                .perform(swipeLeft());

        onView(withId(R.id.viewpager))
                .perform(swipeRight());
    }

    @Test
    public void loadMovie() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition(dummyMovies.size()));
    }

    @Test
    public void loadDetailMovie(){
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_title_detail)).check(matches(withText(dummyMovies.get(0).getTitle())));
        onView(withId(R.id.tv_desc_detail)).check(matches(withText(dummyMovies.get(0).getDesc())));
        onView(withId(R.id.tv_popularity_detail)).check(matches(withText(String.valueOf(dummyMovies.get(0).getPopularity()))));
    }

    @Test
    public void loadTvSeries() {
        onView(withId(R.id.viewpager)).perform(swipeLeft());
        onView(withId(R.id.rv_tv_series)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tv_series)).perform(RecyclerViewActions.scrollToPosition(dummyTvSeries.size()));
    }

    @Test
    public void loadDetailTvSeries(){
        onView(withId(R.id.viewpager)).perform(swipeLeft());
        onView(withId(R.id.rv_tv_series)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_title_detail)).check(matches(withText(dummyTvSeries.get(0).getName())));
        onView(withId(R.id.tv_desc_detail)).check(matches(withText(dummyTvSeries.get(0).getDesc())));
        onView(withId(R.id.tv_popularity_detail)).check(matches(withText(String.valueOf(dummyTvSeries.get(0).getPopularity()))));
    }

}