package com.example.mix_tailsapp;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mix_tailsapp.Adapter.SearchAdapter;
import com.example.mix_tailsapp.UserActivity.Settings;
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 18/02/2021
 * authors: An Huynh, Miguel, Vasily
 * This class decides the activities take place in the drink recommended page including ImageButton
 * menu, drink detail, add drink to favorite list and so on.
 *
 * Here the user can decide which activity takes place in the drink recommended page including
 * menu, drink detail, add drink to favorite list, set the fuel bar and search for drinks.
 *
 * @version 1: declare variables (Annie)
 * @version 1.2: binding the buttons and write functions for them (Annie)
 * @version 2: write function for pop up menu and surprise drink button (Annie)
 * @version 3: write function for search bar and listview
 * @version 3.1: binding database to search bar (Miguel)
 * @version 4: delete search bar and write search adapter (Annie)
 * @version 5: reimplement search bar from scratch, used materialSearchBar (Annie)
 * @version 6: set Text for recommended drinks display in the activity from database (Vasily)
 * References are listed at the end of the activity
 */

public class DrinkRecommendationPage extends AppCompatActivity {
    //Declare Variables
    private ImageButton menuBtn, drinkBtn1, drinkBtn2, drinkBtn3, drinkBtn4, drinkBtn5, drinkBtn6;
    private Button fuelBarResteButton;
    private SharedPreferences tempStorage;
    private TextView drink1, drink2, drink3, drink4, drink5, drink6;
    private int drinkLimitMax, drinksInsideFuelBar, drinksLeftinFuelBar;
    ProgressBar fuelBar;
    private ArrayList<String> recommendedDrinksList = new ArrayList<>();
    //Accessing database to show surprise drinks
    DatabaseAccess drinksAccess;



    //Recycler Searchbar
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    SearchAdapter searchAdapter;
    MaterialSearchBar materialSearchBar;
    List<String> suggestions = new ArrayList<>();
    DatabaseOpen database;


    /**
     * This onCreate method contains functions of searchView, pop-up menu and surprise drink buttons
     * @param savedInstanceState savedInstanceState
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_recommendation_page);
        tempStorage = getSharedPreferences(SignupActivity.TEMP_STORAGE, Activity.MODE_PRIVATE);
        drinksAccess = DatabaseAccess.getInstance(getApplicationContext());
        drinksAccess.open();
        recommendedDrinksList = drinksAccess.getRecom();


        //Initiate variables
        fuelBar = findViewById(R.id.FuelBar);
        drink1 = findViewById(R.id.drinkName1);
        drink2 = findViewById(R.id.drinkName2);
        drink3 = findViewById(R.id.drinkName3);
        drink4 = findViewById(R.id.drinkName4);
        drink5 = findViewById(R.id.drinkName5);
        drink6 = findViewById(R.id.drinkName6);

        drinkBtn1 = findViewById(R.id.drinkFrame);
        drinkBtn2 = findViewById(R.id.drinkFrame1);
        drinkBtn3 = findViewById(R.id.drinkFrame2);
        drinkBtn4 = findViewById(R.id.drinkFrame3);
        drinkBtn5 = findViewById(R.id.drinkFrame4);
        drinkBtn6 = findViewById(R.id.drink_frame2);

        // set Text for recommended drink display from database
        drink1.setText(recommendedDrinksList.get(0));
        drink2.setText(recommendedDrinksList.get(1));
        drink3.setText(recommendedDrinksList.get(2));
        drink4.setText(recommendedDrinksList.get(3));
        drink5.setText(recommendedDrinksList.get(4));
        drink6.setText(recommendedDrinksList.get(5));

        String nameAndIngs1 = recommendedDrinksList.get(0) + ":\n\n" + drinksAccess.getDrinkIngs(recommendedDrinksList.get(0));
        String nameAndIngs2 = recommendedDrinksList.get(1) + ":\n\n" + drinksAccess.getDrinkIngs(recommendedDrinksList.get(1));
        String nameAndIngs3 = recommendedDrinksList.get(2) + ":\n\n" + drinksAccess.getDrinkIngs(recommendedDrinksList.get(2));
        String nameAndIngs4 = recommendedDrinksList.get(3) + ":\n\n" + drinksAccess.getDrinkIngs(recommendedDrinksList.get(3));
        String nameAndIngs5 = recommendedDrinksList.get(4) + ":\n\n" + drinksAccess.getDrinkIngs(recommendedDrinksList.get(4));
        String nameAndIngs6 = recommendedDrinksList.get(5) + ":\n\n" + drinksAccess.getDrinkIngs(recommendedDrinksList.get(5));

        View.OnClickListener clicklistener = v -> {
            if (v == drinkBtn1) {

                Toast.makeText(DrinkRecommendationPage.this, nameAndIngs1, Toast.LENGTH_LONG).show();

            }
            if (v == drinkBtn2) {

                Toast.makeText(DrinkRecommendationPage.this, nameAndIngs2, Toast.LENGTH_LONG).show();

            }
            if (v == drinkBtn3) {

                Toast.makeText(DrinkRecommendationPage.this, nameAndIngs3, Toast.LENGTH_LONG).show();

            }
            if (v == drinkBtn4) {

                Toast.makeText(DrinkRecommendationPage.this, nameAndIngs4, Toast.LENGTH_LONG).show();

            }
            if (v == drinkBtn5) {

                Toast.makeText(DrinkRecommendationPage.this, nameAndIngs5, Toast.LENGTH_LONG).show();

            }
            if (v == drinkBtn6) {

                Toast.makeText(DrinkRecommendationPage.this, nameAndIngs6, Toast.LENGTH_LONG).show();

            }
        };

        //set clickListeners on Images
        drinkBtn1.setOnClickListener(clicklistener);
        drinkBtn2.setOnClickListener(clicklistener);
        drinkBtn3.setOnClickListener(clicklistener);
        drinkBtn4.setOnClickListener(clicklistener);
        drinkBtn5.setOnClickListener(clicklistener);
        drinkBtn6.setOnClickListener(clicklistener);


        //Initiate View
        recyclerView = findViewById(R.id.recycle_search);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        materialSearchBar = findViewById(R.id.searchView);

        //Initiate database
        database = new DatabaseOpen(this);


        //Set up search bar
        materialSearchBar.setHint("Search");
        materialSearchBar.setCardViewElevation(10);
        loadSuggestions();
        materialSearchBar.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                List<String> suggest = new ArrayList<>();

                for (String search : suggestions) {

                    /*this line of code taken  from
                    https://stackoverflow.com/questions/61905314/why-my-autocomplete-searchbar-isnt-working
                    */
                    if (search.toLowerCase().contains(materialSearchBar.getText().toLowerCase()))
                        suggest.add(search);
                }
                materialSearchBar.setLastSuggestions(suggest);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        /*
        reference used here
        https://www.codota.com/code/java/methods/com.mancj.materialsearchbar.MaterialSearchBar/setOnSearchActionListener
         */
        materialSearchBar.setOnSearchActionListener(new MaterialSearchBar.OnSearchActionListener() {
            @Override
            public void onSearchStateChanged(boolean enabled) {
                if (!enabled) {
                    recyclerView.setAdapter(searchAdapter);
                }
            }

            @Override
            public void onSearchConfirmed(CharSequence text) {
                startSearch(text.toString());
            }

            @Override
            public void onButtonClicked(int buttonCode) {

            }
        });

        //Initiate the search adapter at default to set all the result
        searchAdapter = new SearchAdapter(this, database.getCocktails());


        //Initiate ImageBtn menu with its id and create a pop-up menu inside it
        menuBtn = findViewById(R.id.menuBtn);
        menuBtn.setOnClickListener(v -> {
            //Creating an instance of PopupMenu
            PopupMenu popupMenu = new PopupMenu(DrinkRecommendationPage.this, menuBtn);

            //Inflating the popup using xml file popup_menu.xml
            popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

            //Creating the OnMenuItemClickListener
            popupMenu.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()) {
                    case R.id.home:
                        Intent toHome = new Intent(DrinkRecommendationPage.this,
                                HomePage.class);
                        startActivity(toHome);
                        break;
                    case R.id.drinkLimit:
                        Intent toLimit = new Intent(DrinkRecommendationPage.this, FuelBarSet.class);
                        startActivity(toLimit);
                        break;
                    case R.id.newDrink:
                        Intent addDrink = new Intent(DrinkRecommendationPage.this, AddingDrink.class);
                        startActivity(addDrink);
                        break;
                    case R.id.favorite:
                        Intent toFavoriteList = new Intent(DrinkRecommendationPage.this, FavoritesActivity.class);
                        startActivity(toFavoriteList);
                        break;
                    case R.id.settings:
                        Intent settings = new Intent(DrinkRecommendationPage.this,
                                Settings.class);
                        startActivity(settings);
                        break;
                    case R.id.signout:
                        Intent signOut = new Intent(DrinkRecommendationPage.this,
                                SplashScreen.class);
                        SharedPreferences.Editor deleter = tempStorage.edit();
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
/**
 * The section ofthe fuel bar functionality
 */

        //Assigning variables
        drinkLimitMax = tempStorage.getInt(FuelBarSet.LIMIT_AMOUNT, 0);
        drinksInsideFuelBar = drinksAccess.getChosen();
        drinksLeftinFuelBar = drinkLimitMax - drinksInsideFuelBar;

        //When the resetFuel Image(top right in recommendation page) Button clicked the method resets the bar
        fuelBarResteButton = findViewById(R.id.imageButton);
        fuelBarResteButton.setOnClickListener(v -> {
            SharedPreferences.Editor fuelResetter = tempStorage.edit();
            fuelResetter.putInt(FuelBarSet.LIMIT_AMOUNT, 0);
            if (fuelResetter.commit()) {
                fuelBar.setProgress(0, true);
                drinksAccess.resetChosen();
            }


        });

        //Checking if the Fuel bar is set or not
        if (drinkLimitMax == 0) {
            fuelBar.setProgress(0);
            fuelBar.setMax(25);
            drinksAccess.resetChosen();
        } else {
            fuelBar.setMax(drinkLimitMax);
            fuelBar.setProgress(drinksInsideFuelBar);
            if(drinksLeftinFuelBar == 0){
                Toast.makeText(DrinkRecommendationPage.this, "You have reached your limit! Don't drink anymore!", Toast.LENGTH_LONG).show();
            }
        }



    }

    //Toasting fuel bar on pause of the activity
    @Override
    protected void onPause() {

        super.onPause();


        if(drinksLeftinFuelBar == 0 && tempStorage.getInt(FuelBarSet.LIMIT_AMOUNT, 0) > 0){
            Toast.makeText(DrinkRecommendationPage.this, "You have reached your limit! Don't drink anymore!", Toast.LENGTH_LONG).show();
        }else if (drinkLimitMax == 0){
            Toast.makeText(DrinkRecommendationPage.this, "Remember to set the fuel bar!", Toast.LENGTH_SHORT).show();

        }else if (tempStorage.getInt(FuelBarSet.LIMIT_AMOUNT, 0) > 0){
            Toast.makeText(getApplicationContext(), "You have " + drinksLeftinFuelBar + " drinks left in your FuelBar", Toast.LENGTH_LONG).show();
        }
    }


    /**
     * create a start search method for search bar
     */

    private void startSearch(String text) {

        searchAdapter = new SearchAdapter(this, database.getDrinkByName(text));
        recyclerView.setAdapter(searchAdapter);

    }


    /**
     * Create a method to load suggestions for search bar
     */
    private void loadSuggestions() {
        suggestions = database.getDrinkName();
        materialSearchBar.setLastSuggestions(suggestions);

    }
}

/*
 * Reference material used in this activity: Android Popup menu mrBool.com
 * http://mrbool.com/android-menu-how-to-create-a-menu-in-android/30719
 * SearchView reference: https://developer.android.com/reference/android/widget/SearchView
 * Material Search Bar: https://github.com/mancj/MaterialSearchBar
 * https://stackoverflow.com/questions/32455745/recyclerview-and-cardview-click-listener-implementation
 * https://google-developer-training.github.io/android-developer-fundamentals-course-practicals/
 * en/Unit%204/101b_p_searching_an_sqlite_database.html
 * Progress bar https://www.tutlane.com/tutorial/android/android-progressbar-with-examples
 */