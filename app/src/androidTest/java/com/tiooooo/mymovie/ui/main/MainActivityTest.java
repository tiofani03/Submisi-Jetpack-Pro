package com.tiooooo.mymovie.ui.main;

import com.tiooooo.mymovie.R;
import com.tiooooo.mymovie.data.rest.response.MovieResponse;
import com.tiooooo.mymovie.data.rest.response.TvSeriesResponse;
import com.tiooooo.mymovie.utils.EspressoIdlingResource;
import com.tiooooo.mymovie.utils.FakeDataDummy;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.action.ViewActions.swipeRight;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class MainActivityTest {

    private ArrayList<MovieResponse> dummyMovies = FakeDataDummy.generateDummyMovies();
    private ArrayList<TvSeriesResponse> dummyTvSeries = FakeDataDummy.generateDummyTvSeries();


    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp(){
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @After
    public void tearDown(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }


    @Test
    public void swipePage() {
        onView(withId(R.id.navigation_favorites)).perform(click());
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
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));
        onView(withId(R.id.action_favorite)).perform(click());
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_desc_detail)).check(matches(isDisplayed()));
    }

    @Test
    public void loadTvSeries() {
        onView(withId(R.id.navigation_tv_series)).perform(click());
        onView(withId(R.id.rv_tv_series)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tv_series)).perform(RecyclerViewActions.scrollToPosition(dummyTvSeries.size()));
    }

    @Test
    public void loadDetailTvSeries(){
        onView(withId(R.id.navigation_tv_series)).perform(click());
        onView(withId(R.id.rv_tv_series)).perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));
        onView(withId(R.id.action_favorite)).perform(click());
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_desc_detail)).check(matches(isDisplayed()));
    }

    @Test
    public void loadMovieAndTvSeriesFavorite(){
        onView(withId(R.id.navigation_favorites)).perform(click());
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition(dummyMovies.size()));
        onView(withId(R.id.viewpager)).check(matches(isDisplayed()));
        onView(withId(R.id.viewpager)).perform(swipeLeft());
        onView(withId(R.id.rv_tv_series)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tv_series)).perform(RecyclerViewActions.scrollToPosition(dummyTvSeries.size()));
    }

    @Test
    public void loadMovieFavorite(){
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.action_favorite)).perform(click());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(2, click()));
        onView(withId(R.id.action_favorite)).perform(click());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));
        onView(withId(R.id.action_favorite)).perform(click());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(withId(R.id.navigation_favorites)).perform(click());
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_desc_detail)).check(matches(isDisplayed()));
    }


}