package com.example.chelsi.androidfinalpractical;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Chelsi on 2/25/2018.
 */

public class BreedsActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String SHARED_PREFS_KEY = "sharedPrefsLogin";
    private TextView welcome;
    private String username;
    private SharedPreferences userPrefs;
    CardView terrier;
    CardView spaniel;
    CardView poodle;
    CardView retriever;
    ImageView terrierPic;
    ImageView spanielPic;
    ImageView poodlePic;
    ImageView retrieverPic;
    String welcomeMessage = "What kind of dog would you like to see, ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breeds);

        userPrefs = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        welcome = findViewById(R.id.welcomeText);
        terrier = findViewById(R.id.terrierCard);
        spaniel = findViewById(R.id.spanielCard);
        poodle = findViewById(R.id.poodleCard);
        retriever = findViewById(R.id.retrieverCard);

        terrierPic = findViewById(R.id.terrierImg);
        spanielPic = findViewById(R.id.spanielImg);
        poodlePic = findViewById(R.id.poodleImg);
        retrieverPic = findViewById(R.id.retrieverImg);

        welcome.setText(welcomeMessage);

    }



    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, DogsActivity.class);
        int num = view.getId();
        switch (num) {
            case R.id.terrierCard:
                intent.putExtra("breed","terrier");
                startActivity(intent);
                break;
            case R.id.poodleCard:
                intent.putExtra("breed","poodle");
                startActivity(intent);
                break;
            case R.id.spanielCard:
                intent.putExtra("breed","spaniel");
                startActivity(intent);
                break;
            case R.id.retrieverCard:
                intent.putExtra("breed","retriever");
                startActivity(intent);
                break;
        }
    }
}

