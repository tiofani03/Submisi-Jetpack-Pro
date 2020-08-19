package com.tiooooo.mymovie.ui.main.movie;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.tiooooo.mymovie.R;
import com.tiooooo.mymovie.ui.favorite.FavoriteFragmentCallback;
import com.tiooooo.mymovie.ui.favorite.movie.PagedListMovieAdapter;
import com.tiooooo.mymovie.viewmodel.ViewModelFactory;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;


public class FragmentMovies extends Fragment implements FavoriteFragmentCallback {


    private PagedListMovieAdapter adapter;

    @BindView(R.id.rv_movies)
    RecyclerView rvMovies;
    @BindView(R.id.tv_information)
    TextView tvInformationData;
    @BindView(R.id.shimmerFrameLayout)
    ShimmerFrameLayout shimmerFrameLayout;

    public FragmentMovies() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        if (getActivity() != null) {
            initAdapter();
            showLoading(true);
            getMovies();
        }
    }

    private void initAdapter() {
        rvMovies.setLayoutManager(new LinearLayoutManager(this.getContext()));
        adapter = new PagedListMovieAdapter(this);
        adapter.notifyDataSetChanged();
    }

    private void showLoading(Boolean state) {
        if (state) {
            shimmerFrameLayout.setVisibility(View.VISIBLE);
            shimmerFrameLayout.startShimmer();
        } else {
            shimmerFrameLayout.stopShimmer();
            shimmerFrameLayout.setVisibility(View.GONE);
        }
    }


    private void getMovies() {
        ViewModelFactory factory = ViewModelFactory.getInstance(getActivity().getApplication());
        MovieViewModel viewModel = new ViewModelProvider(this, factory).get(MovieViewModel.class);
        viewModel.getMovies().observe(getViewLifecycleOwner(), listMovies -> {
            if (listMovies != null) {
                switch (listMovies.status) {
                    case LOADING:
                        showLoading(true);
                        Log.d("Coba", "Loading");
                        break;

                    case SUCCESS:
                        showLoading(false);
                        adapter.submitList(listMovies.data);
                        assert listMovies.data != null;
                        Log.d("Coba", "Jalan " + listMovies.data.size());
                        adapter.notifyDataSetChanged();
                        break;

                    case ERROR:
                        showLoading(false);
                        Toast.makeText(getContext(), "Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        rvMovies.setAdapter(adapter);

    }

}

