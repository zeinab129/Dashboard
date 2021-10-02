package com.ziziapps.moderndashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupMoviesViewPager();
    }

    private void setupMoviesViewPager(){
        ViewPager2 moviesViewPager = findViewById(R.id.activity_main_vp_movies_view_pager);
        moviesViewPager.setClipToPadding(false);
        moviesViewPager.setClipChildren(false);
        moviesViewPager.setOffscreenPageLimit(3);
        moviesViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(10));
        compositePageTransformer.addTransformer((page, position) -> {
            float r = 1 - Math.abs(position);
            page.setScaleY(0.85f + r * 0.2f);
        });
        moviesViewPager.setPageTransformer(compositePageTransformer);
        moviesViewPager.setAdapter(new MoviesAdapter(getMovies()));
    }

    private List<Movie> getMovies(){
        List<Movie> movies = new ArrayList<>();
        Movie raya = new Movie();
        raya.poster = R.drawable.movie_1;
        raya.name = "Raya and the Last Dragon";
        raya.category = "Animation";
        raya.releaseDate = "January 26, 2021";
        raya.rating = 4.4f;
        movies.add(raya);

        Movie frozen = new Movie();
        frozen.poster = R.drawable.movie_2;
        frozen.name = "Frozen";
        frozen.category = "Animation";
        frozen.releaseDate = "November 27, 2013";
        frozen.rating = 4.2f;
        movies.add(frozen);

        Movie soul = new Movie();
        soul.poster = R.drawable.movie_3;
        soul.name = "Soul";
        soul.category = "Animation";
        soul.releaseDate = "October 11, 2020";
        soul.rating = 4.6f;
        movies.add(soul);

        Movie coco = new Movie();
        coco.poster = R.drawable.movie_4;
        coco.name = "Coco";
        coco.category = "Animation";
        coco.releaseDate = "November 22, 2017";
        coco.rating = 4.7f;
        movies.add(coco);

        Movie epic = new Movie();
        epic.poster = R.drawable.movie_5;
        epic.name = "Epic";
        epic.category = "Animation";
        epic.releaseDate = "May 29, 2013";
        epic.rating = 4.4f;
        movies.add(epic);

        Movie moana = new Movie();
        moana.poster = R.drawable.movie_6;
        moana.name = "Moana";
        moana.category = "Animation";
        moana.releaseDate = "November 23, 2016";
        moana.rating = 4.6f;
        movies.add(moana);

        Movie panda = new Movie();
        panda.poster = R.drawable.movie_7;
        panda.name = "Kung Fu Panda 2";
        panda.category = "Animation";
        panda.releaseDate = "May 26, 2011";
        panda.rating = 4.7f;
        movies.add(panda);

        return movies;
    }
}