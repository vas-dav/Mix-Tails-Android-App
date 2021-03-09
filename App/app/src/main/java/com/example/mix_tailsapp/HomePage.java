package com.example.mix_tailsapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mix_tailsapp.UserActivity.Settings;

/**
 * Created by Annie (An Huynh) on 24/02/2021
 * authors: Annie, Miguel, Vasily
 *
 * If the user is logged in the app will be directed to a user menu with choosing a drink,
 * drink recommendations and favorites drinks options to click on.
 *
 * @version 1: declare variables and instantiate them (Annie)
 * @version 2: onClick listener method to decide what happen when the buttons are clicked (Annie)
 * @version 3: using SharePreference to get user's name (Vasily)
 * @version 4: added menu button to the activity (Annie)
 */

public class HomePage extends AppCompatActivity {
    //Declare variables
    private Button decideBtn, recommendBtn, favoriteBtn;
    private ImageButton logOut, menuBtn;
    private SharedPreferences tempStoragePut, permStorageGet, tempStorageGet;
    TextView welcomeText;

    /**
     * create an onClick listener when the buttons are clicked
     */

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == decideBtn) {
                Intent chooseDrink = new Intent(HomePage.this, QuestionSpinner.class);
                startActivity(chooseDrink);
            }
            if (v == recommendBtn) {
                Intent recommend = new Intent(HomePage.this, DrinkRecommendationPage.class);
                startActivity(recommend);
            }
            if (v == favoriteBtn) {
                Intent toFavorites = new Intent(HomePage.this, FavoritesActivity.class);
                startActivity(toFavorites);

            }
            if (v == logOut) {
                //Deleting the TEMPMEM signed boolean
                tempStoragePut = getSharedPreferences(SignupActivity.TEMP_STORAGE, Activity.MODE_PRIVATE);
                Intent signOut = new Intent(HomePage.this,
                        SplashScreen.class);
                SharedPreferences.Editor deleter = tempStoragePut.edit();
                deleter.clear();
                if (deleter.commit()) {
                    startActivity(signOut);
                }
            }
        }
    };

    /**
     * Initiate and calling the onClick methods
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        tempStorageGet = getSharedPreferences(SignupActivity.TEMP_STORAGE, Activity.MODE_PRIVATE);
        permStorageGet = getSharedPreferences(SignupActivity.PERM_STORAGE, Activity.MODE_PRIVATE);
        String name = permStorageGet.getString(SignupActivity.EXTRA_NAME, "User");
        welcomeText = findViewById(R.id.welcomeBack);
        welcomeText.setText(getString(R.string.wecome_back_text) + name);

        // Initiate variables with their ids
        decideBtn = findViewById(R.id.decideBtn);
        recommendBtn = findViewById(R.id.recommendBtn);
        favoriteBtn = findViewById(R.id.myfavoriteBtn);
        logOut = findViewById(R.id.logOut);

        //calling the onClick method
        decideBtn.setOnClickListener(clickListener);
        recommendBtn.setOnClickListener(clickListener);
        favoriteBtn.setOnClickListener(clickListener);
        logOut.setOnClickListener(clickListener);

        // function for menu button
        menuBtn = findViewById(R.id.menuBtn);
        menuBtn.setOnClickListener(v -> {
            //Creating an instance of PopupMenu
            PopupMenu popupMenu = new PopupMenu(HomePage.this, menuBtn);

            //Inflating the popup using xml file popup_menu.xml
            popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

            //Creating the OnMenuItemClickListener
            popupMenu.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()) {
                    case R.id.home:
                        Intent toHome = new Intent(HomePage.this,
                                HomePage.class);
                        startActivity(toHome);
                        break;
                    case R.id.drinkLimit:
                        Intent toLimit = new Intent(HomePage.this, FuelBarSet.class);
                        startActivity(toLimit);
                        break;
                        case R.id.newDrink:
                        Intent addDrink = new Intent(HomePage.this, AddingDrink.class);
                        startActivity(addDrink);
                        break;
                    case R.id.favorite:
                        Intent toFavoriteList = new Intent(HomePage.this, FavoritesActivity.class);
                        startActivity(toFavoriteList);
                    case R.id.settings:
                        Intent settings = new Intent(HomePage.this,
                                Settings.class);
                        startActivity(settings);
                        break;
                    case R.id.signout:
                        Intent signOut = new Intent(HomePage.this,
                                SplashScreen.class);
                        SharedPreferences.Editor deleter = tempStorageGet.edit();
                        deleter.clear();
                        if (deleter.commit()) {
                            startActivity(signOut);
                        }
                        break;
                }
                return true;
            });
            popupMenu.show();
        });
    }
}