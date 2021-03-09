package com.example.mix_tailsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

/**
 * created 08/03/2021
 * authors Miguel, An, Vasily
 *
 * The user has the options to add any drinks(included new added drinks)
 * to a favorites list by pressing the heart button when in drink details.
 *
 */

public class FavoritesActivity extends AppCompatActivity {

    ArrayList<String> favoriteDrinksList;
    DatabaseAccess db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        db = DatabaseAccess.getInstance(getApplicationContext());
        db.open();
        favoriteDrinksList = new ArrayList<String>();
        favoriteDrinksList = db.getFavs();


        ListView show = findViewById(R.id.favoriteList);
        show.setAdapter(new ArrayAdapter<String>(
                this, //activity instance
                android.R.layout.simple_expandable_list_item_1,
                favoriteDrinksList));

        show.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(FavoritesActivity.this,
                        db.getDrinkIngs2(favoriteDrinksList.get(position)),
                        Toast.LENGTH_LONG).show();

            }
            });
    }
}


