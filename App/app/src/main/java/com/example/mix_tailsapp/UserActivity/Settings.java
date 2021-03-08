package com.example.mix_tailsapp.UserActivity;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

import com.example.mix_tailsapp.R;

/**
 * Created on 04/03/2021
 * author: An Huynh
 * A Settings activity for user to edit username and change the app orientation
 * Reference used:
 * Settings https://developer.android.com/guide/topics/ui/settings
 * Library Support https://developer.android.com/topic/libraries/support-library/revisions#28-0-0-alpha
 */
@SuppressWarnings("ALL")
public class Settings extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings_screen); //link the xml layout with the activity
        loadSetting();

    }

    /**
     * Create the settings method to change the app orientation
     */
    private void loadSetting() {
        //Create SharePreferences
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        //Create method for listPreference
        ListPreference listPreference = (ListPreference) findPreference("ORIENTATION");

        //Define String orientation
        String orientation = sharedPreferences.getString("ORIENTATION", "false");
        //Make conditions and set summary to screen on which orientation chosen
        if ("1".equals(orientation)) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_BEHIND);
            listPreference.setSummary(listPreference.getEntry()); //call the setSummary method
        } else if ("2".equals(orientation)) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            listPreference.setSummary(listPreference.getEntry());
        } else if ("3".equals(orientation)) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            listPreference.setSummary(listPreference.getEntry());
        }
        //Create a OnPreferenceChangeListener method that will call the conditions above
        listPreference.setOnPreferenceChangeListener(new android.preference.Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(android.preference.Preference prefs, Object obj) {

                String value = (String) obj;
                if (prefs.getKey().equals("ORIENTATION")) {
                    switch (value) {
                        case "1":
                            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_BEHIND);
                            break;
                        case "2":
                            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                            break;
                        case "3":
                            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                            break;
                    }
                    //set summary
                    ListPreference listPreference1 = (ListPreference) prefs;
                    listPreference1.setSummary(listPreference1.getEntries()[listPreference1.findIndexOfValue(value)]);


                }
                return true;
            }
        });


    }

    /**
     * the orientation of the app will stay when the app resumes with the called load_setting method
     */
    @Override
    protected void onResume() {
        loadSetting();
        super.onResume();
    }
}
