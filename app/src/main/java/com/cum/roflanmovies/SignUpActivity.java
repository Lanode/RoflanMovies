package com.cum.roflanmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void onSignUpClick(View view) {
        String email = ((TextView)findViewById(R.id.editTextTextEmailAddress2)).getText().toString();
        String password = ((TextView)findViewById(R.id.editTextTextPassword2)).getText().toString();
        String password2 = ((TextView)findViewById(R.id.editTextTextPassword3)).getText().toString();
        String name = ((TextView)findViewById(R.id.editTextTextPersonName)).getText().toString();

        if (email.isEmpty()) {
            ((TextView)findViewById(R.id.editTextTextEmailAddress2)).setError("Введите email");
        }
        if (password.isEmpty()) {
            ((TextView)findViewById(R.id.editTextTextPassword2)).setError("Введите пароль");
        }
        if (password2.isEmpty()) {
            ((TextView)findViewById(R.id.editTextTextPassword3)).setError("Введите повтор пароля");
        }
        if (name.isEmpty()) {
            ((TextView)findViewById(R.id.editTextTextPersonName)).setError("Введите ваше имя");
        }

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        String databaseString = sharedPref.getString("database", "");

        JSONObject database = null;
        try {
            database = new JSONObject(databaseString);

            if (database.has(email)) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Аккаунт с такой почтой уже существует", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }

            if (!password.equals(password2))
            {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Пароль не совпадает", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }

            JSONObject entry = new JSONObject();
            entry.put("email", email);
            entry.put("name", name);
            entry.put("password", password);

            database.put(email, entry);
        } catch (JSONException e) {
            e.printStackTrace();
            return;
        }

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("database", database.toString());
        editor.putString("active_email", email);
        editor.apply();

        finish();
    }
}