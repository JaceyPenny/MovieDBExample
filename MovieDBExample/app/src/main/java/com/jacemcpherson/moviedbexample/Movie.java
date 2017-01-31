package com.jacemcpherson.moviedbexample;

import android.util.Log;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ParseClassName("Movie")
public class Movie extends ParseObject {

    public interface MoviesLoadedCallback {
        void moviesLoaded();
    }

    public static List<Movie> mMovies = new ArrayList<>();

    public static List<Movie> getLoadedMovies() {
        return mMovies;
    }

    public static void loadMovies() {
        loadMovies(null);
    }

    public static void loadMovies(MoviesLoadedCallback callback) {
        ParseQuery<Movie> movieQuery = new ParseQuery<>(Movie.class);
        movieQuery.findInBackground((result, error) -> {
            if (error == null) {
                mMovies = result;
                if (callback != null)
                    callback.moviesLoaded();
            } else {
                Log.wtf("Movie", "Loading movies returned an error from the Parse Server");
            }
        });
    }

    public String getName() {
        return getString("movieName");
    }

    public List<String> getCast() {
        return getList("cast");
    }

    public Date getReleaseDate() {
        return getDate("releaseDate");
    }

    public String getImageURL() {
        return getString("imageURL");
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        return "Movie: {" + getName() + " (" + format.format(getReleaseDate()) + "), featuring " + getCast().get(0) + ".";
    }
}
