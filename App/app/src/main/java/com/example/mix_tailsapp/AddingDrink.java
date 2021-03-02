package com.example.mix_tailsapp;
/**
 * Created by Annie on 02/03/2021
 * authors Annie, Miguel, Vasily
 * This is the activity for user adding a new drink
 */

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;

public class AddingDrink extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_drink);
        //get Intent
        Intent addDrink = getIntent();
    }
}