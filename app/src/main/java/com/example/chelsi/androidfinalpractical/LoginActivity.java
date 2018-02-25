package com.example.chelsi.androidfinalpractical;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String SHARED_PREFS_KEY = "sharedPrefsLogin";
    private SharedPreferences login;
    private EditText username;
    private EditText password;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.usernameET);
        password = findViewById(R.id.passwordET);
        button = findViewById(R.id.submitButton);

        button.setOnClickListener((View.OnClickListener) this);
        login = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        if (login.contains("username")) {
            Intent intent = new Intent(this, BreedsActivity.class);
            intent.putExtra("prefs_key", SHARED_PREFS_KEY);
            startActivity(intent);
        }
    }


    @Override
    public void onClick(View view) {
        String user = username.getText().toString();
        String pass = password.getText().toString();
        Intent loginIntent = new Intent(this, BreedsActivity.class);

        if (user.equals("")) {
            username.setError("please enter a username");
        }
        if (pass.equals("")) {
            password.setError("please enter a password");
        }

        if (!user.equals("") && !pass.equals("")) {
            if (login.contains("username")) {
                if (pass.equals(login.getString(user, null))) {
                    startActivity(loginIntent);
                } else {
                    password.setError("enter the correct password");
                }
            } else {
                SharedPreferences.Editor editor = login.edit();
                editor.putString("username", user);
                editor.putString(user, pass);
                editor.apply();
                startActivity(loginIntent);

            }
        }
    }
}





