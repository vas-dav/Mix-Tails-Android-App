package com.example.mix_tailsapp;
/**
 * authors: An Huynh, Migule, Vasily
 * This class decides the activites take place in the drink recommended page including ImageButton
 * menu, drink detail, add drink to favorite list and so on.
 * Reference material used in this activity: Android Popup menu mrBool.com
 * http://mrbool.com/android-menu-how-to-create-a-menu-in-android/30719
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

public class DrinkRecommendationPage extends AppCompatActivity {
    private ImageButton menuBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_recommendation_page);

        //casting ImageBtn menu with its id
        menuBtn = findViewById(R.id.menuBtn);
        menuBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Creating an instance of PopupMenu
                PopupMenu popupMenu = new PopupMenu(DrinkRecommendationPage.this, menuBtn);
                //Inflating the popup using xml file popup_menu.xml
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

                //Creating the OnMenuItemClickListener
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId())
                        {
                            case R.id.home:
                                Intent toHome = new Intent(DrinkRecommendationPage.this, AppWelcomeScreen.class);
                                startActivity(toHome);
                                break;
                            case R.id.signout:
                                Intent signOut = new Intent(DrinkRecommendationPage.this, AppLaunching.class);
                                startActivity(signOut);
                                break;
                        }

                        return true;
                    }
                });
                popupMenu.show();
            }
        });

    }
}