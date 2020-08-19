package com.tiooooo.mymovie.ui.favorite.tv;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tiooooo.mymovie.BuildConfig;
import com.tiooooo.mymovie.R;
import com.tiooooo.mymovie.data.local.entitiy.TvSeries;
import com.tiooooo.mymovie.ui.detail.DetailActivity;
import com.tiooooo.mymovie.ui.favorite.FavoriteFragmentCallback;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PagedListTvSeriesAdapter extends PagedListAdapter<TvSeries, PagedListTvSeriesAdapter.TvSeriesViewHolder> {


    private static final int EXTRA_CATEGORY = 2;

    private final FavoriteFragmentCallback callback;

    public PagedListTvSeriesAdapter(FavoriteFragmentCallback callback) {
        super(DIFF_CALLBACK);
        this.callback = callback;
    }

    private static DiffUtil.ItemCallback<TvSeries> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<TvSeries>() {
                @Override
                public boolean areItemsTheSame(@NonNull TvSeries oldItem, @NonNull TvSeries newItem) {
                    return oldItem.getName().equals(newItem.getName());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull TvSeries oldItem, @NonNull TvSeries newItem) {
                    return oldItem.equals(newItem);
                }
            };

    @NonNull
    @Override
    public TvSeriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);
        return new TvSeriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvSeriesViewHolder holder, int position) {
        TvSeries tvSeries = getItem(position);
        assert tvSeries != null;
        holder.bind(tvSeries);
    }


    public  class TvSeriesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.img_item)
        ImageView ivImg;
        @BindView(R.id.item_tv_title)
        TextView tvTitle;
        @BindView(R.id.item_tv_release_date)
        TextView tvRelease;
        @BindView(R.id.item_tv_vote_count)
        TextView tvVoteCount;
        @BindView(R.id.item_tv_rating_ten)
        TextView tvRating;
        @BindView(R.id.item_ratingBar)
        RatingBar rbVoteAvg;

        TvSeriesViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

        void bind(TvSeries tvSeries) {
            String ratingTen = Double.toString(tvSeries.getVote_avg());
            Double rating = tvSeries.getVote_avg() / 2;
            String rate = String.valueOf(rating);

            String img = BuildConfig.LINK_IMAGE + tvSeries.getImg();

            tvTitle.setText(tvSeries.getName());

            tvRelease.setText(tvSeries.getFirst_air_date());
            String votes = "(" + tvSeries.getVote_count() + ")";

            tvVoteCount.setText(votes);
            tvRating.setText(ratingTen);
            rbVoteAvg.setRating(Float.parseFloat(rate));

            Glide.with(itemView.getContext())
                    .load(img)
                    .into(ivImg);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            TvSeries tvSeries = getItem(position);
            assert tvSeries != null;
            Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_MOVIE,tvSeries.getId());
            intent.putExtra(DetailActivity.EXTRA_CATEGORY,EXTRA_CATEGORY);
            itemView.getContext().startActivity(intent);

        }
    }
}
