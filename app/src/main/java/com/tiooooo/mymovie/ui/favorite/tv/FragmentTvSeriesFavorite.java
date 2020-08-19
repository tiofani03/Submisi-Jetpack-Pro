package com.tiooooo.mymovie.ui.favorite.tv;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.tiooooo.mymovie.R;
import com.tiooooo.mymovie.ui.favorite.FavoriteFragmentCallback;
import com.tiooooo.mymovie.viewmodel.ViewModelFactory;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;


public class FragmentTvSeriesFavorite extends Fragment implements FavoriteFragmentCallback {

    private PagedListTvSeriesAdapter adapter;

    @BindView(R.id.rv_tv_series)
    RecyclerView rvTvSeries;
    @BindView(R.id.tv_information)
    TextView tvInformationData;
    @BindView(R.id.shimmerFrameLayout)
    ShimmerFrameLayout shimmerFrameLayout;


    public FragmentTvSeriesFavorite() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        if (getActivity() != null) {
            initAdapter();
            showLoading(true);
            getTvSeries();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tv_series_favorite, container, false);
    }

    private void initAdapter() {
        rvTvSeries.setLayoutManager(new LinearLayoutManager(this.getContext()));
        adapter = new PagedListTvSeriesAdapter(this);
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

    private void getTvSeries() {
        ViewModelFactory factory = ViewModelFactory.getInstance(getActivity().getApplication());
        TvSeriesFavoriteViewModel viewModel = new ViewModelProvider(this, factory).get(TvSeriesFavoriteViewModel.class);
        showLoading(true);
        viewModel.getMovieFavorite().observe(getViewLifecycleOwner(), tvSeries -> {
            showLoading(false);
            Log.d("COba", "Jumlah " + tvSeries.size());
            adapter.submitList(tvSeries);
            adapter.notifyDataSetChanged();
        });

        rvTvSeries.setAdapter(adapter);
    }
}