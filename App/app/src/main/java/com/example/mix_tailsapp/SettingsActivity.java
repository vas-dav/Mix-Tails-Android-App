package com.example.mix_tailsapp;
/**
 * Created by Annie on 02/03/2021
 * authors Annie
 * Setting Activity
 * @version 1: adding settings fragment
 */

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.app.Fragment;


public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        //Add fragment to activity
        Fragment fragment = new SettingsScreen();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        if(savedInstanceState == null) {
            //created for the first time
            fragmentTransaction.add(R.id.relativeLayout,fragment,"settings_fragment");
            fragmentTransaction.commit();
        } else {
            fragment = getFragmentManager().findFragmentByTag("settings_fragment");
        }
    }


    /**
     * Create inner class extends preference fragment
     */
    public static class SettingsScreen extends PreferenceFragment {
        /**
         * Override onCreate method and load settings_screen.xml
         * then add this fragment to main activity above
         */
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings_screen);
        }
    }



}