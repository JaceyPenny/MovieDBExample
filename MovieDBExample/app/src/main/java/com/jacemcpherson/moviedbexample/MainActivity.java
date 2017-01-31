package com.jacemcpherson.moviedbexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar mProgressBar;
    Button mContinueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mContinueButton = (Button) findViewById(R.id.continueButton);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Movie.loadMovies(this::showContinueButton);
    }

    public void onContinueClicked(View v) {
        for (Movie m : Movie.getLoadedMovies()) {
            Log.d("MainActivity", m.toString());
        }
    }

    public void showContinueButton() {
        mProgressBar.setVisibility(View.GONE);
        mContinueButton.setVisibility(View.VISIBLE);
    }
}
