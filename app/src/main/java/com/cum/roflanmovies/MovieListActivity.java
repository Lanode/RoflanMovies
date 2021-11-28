package com.cum.roflanmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MovieListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
    }

    @Override
    public void onBackPressed() {
        finishAndRemoveTask();
    }
}