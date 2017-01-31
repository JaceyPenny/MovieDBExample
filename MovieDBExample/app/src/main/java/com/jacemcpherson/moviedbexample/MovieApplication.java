package com.jacemcpherson.moviedbexample;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;


public class MovieApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Movie.class);

        Parse.Configuration configuration = new Parse.Configuration.Builder(this)
                .applicationId("thisisanexampleappid")
                .clientKey("thisisanexamplemasterkey")
                .server("http://moviedbexample.herokuapp.com/parse")
                .build();

        Parse.initialize(configuration);
    }
}
