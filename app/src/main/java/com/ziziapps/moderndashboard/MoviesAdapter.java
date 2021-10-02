package com.ziziapps.moderndashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;


public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>{

    private final List<Movie> movies;

    public MoviesAdapter(List<Movie> movies){
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_movie,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesAdapter.MovieViewHolder holder, int position) {
        holder.setMovie(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder{
        private final RoundedImageView imagePoster;
        private final TextView tvName, tvCategory, tvReleaseDate;
        private final RatingBar ratingBar;

        public MovieViewHolder(View view){
            super(view);
            imagePoster = view.findViewById(R.id.item_container_movie_iv_poster);
            tvName = view.findViewById(R.id.item_container_movie_tv_name);
            tvCategory = view.findViewById(R.id.item_container_movie_tv_category);
            tvReleaseDate = view.findViewById(R.id.item_container_movie_tv_release_date);
            ratingBar = view.findViewById(R.id.item_container_movie_rb_rate);
        }

        void setMovie(Movie movie){
            imagePoster.setImageResource(movie.poster);
            tvName.setText(movie.name);
            tvCategory.setText(movie.category);
            tvReleaseDate.setText(movie.releaseDate);
            ratingBar.setRating(movie.rating);
        }
    }
}
