package com.cum.roflanmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }

    public void onSignInClick(View view) {
        String email = ((TextView)findViewById(R.id.editTextTextEmailAddress)).getText().toString();
        String password = ((TextView)findViewById(R.id.editTextTextPassword)).getText().toString();

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        String databaseString = sharedPref.getString("database", "");

        JSONObject database = null;
        try {
            database = new JSONObject(databaseString);

            if (!database.has(email)) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Такого аккаунта не существует", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }

            if (!password.equals(database.getJSONObject(email).getString("password")))
            {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Пароль не верен", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return;
        }

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("active_email", email);
        editor.apply();

        finish();
    }
}