package com.tiooooo.mymovie.ui.main.fragment.movie;

import android.content.Context;
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
import com.tiooooo.mymovie.entity.movie.Movie;
import com.tiooooo.mymovie.ui.detail.DetailActivity;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private ArrayList<Movie> listMovies = new ArrayList<>();
    private Context context;
    private static final int EXTRA_CATEGORY = 1;

    MovieAdapter(Context context){
        this.context = context;
    }

    void setMovies(ArrayList<Movie> items){
        listMovies.clear();
        listMovies.addAll(items);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder holder, int position) {
        holder.bind(listMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

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


        MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

        void bind(Movie movies) {

            String ratingTen = Double.toString(movies.getVote_avg());
            Double rating = movies.getVote_avg()/2;
            String rate = String.valueOf(rating);

            String img = BuildConfig.LINK_IMAGE+movies.getImg();

            tvTitle.setText(movies.getTitle());
            String date = movies.getRelease_date();

            if(date.equals("")){
                tvRelease.setText(movies.getRelease_date());
            }else{
                date = changeFormatDate(movies.getRelease_date());
                tvRelease.setText(date);
            }

            String votes = "("+movies.getVote_count()+")";

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
            Movie movie = listMovies.get(position);
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_MOVIE,movie.getId());
            intent.putExtra(DetailActivity.EXTRA_CATEGORY,EXTRA_CATEGORY);
            context.startActivity(intent);
        }

        String changeFormatDate(String date) {
            String[] splitDate = date.split("-");
            String part1 = splitDate[0];
            int part2 = Integer.parseInt(splitDate[1]);
            String part3 = splitDate[2];
            String[] month = context.getResources().getStringArray(R.array.month);

            String monthConvert = "month";

            for (int i = 1; i <= 12; i++) {
                if (i == part2) {
                    monthConvert = month[i - 1];
                }
            }

            return part3 + " " + monthConvert + " " + part1;
        }
    }
}
