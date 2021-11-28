package com.cum.roflanmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("database", "{}");
        editor.putString("active_email", "");
        editor.apply();
    }

    public void onSignInClick(View view) {
        Intent myIntent = new Intent(this, SignInActivity.class);
        startActivity(myIntent);
    }

    public void onSignUpClick(View view) {
        Intent myIntent = new Intent(this, SignUpActivity.class);
        startActivity(myIntent);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        String email = sharedPref.getString("active_email", "");
        if (email.equals(""))
            return;

        Intent myIntent = new Intent(this, MovieListActivity.class);
        startActivity(myIntent);
    }
}