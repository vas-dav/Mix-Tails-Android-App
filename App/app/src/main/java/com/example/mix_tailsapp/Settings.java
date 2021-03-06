package com.example.mix_tailsapp;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.widget.Toolbar;

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
        addPreferencesFromResource(R.xml.settings_screen);
        Load_setting();

    }
    /**
     * a load_settings method to change the app orientation
     */
    private void Load_setting() {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        ListPreference listPreference = (ListPreference) findPreference("ORIENTATION");

        String orien = sharedPreferences.getString("ORIENTATION", "false");
        if ("1".equals(orien)) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_BEHIND);
            listPreference.setSummary(listPreference.getEntry());
        } else if ("2".equals(orien)) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            listPreference.setSummary(listPreference.getEntry());
        } else if ("3".equals(orien)) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            listPreference.setSummary(listPreference.getEntry());
        }

        listPreference.setOnPreferenceChangeListener(new android.preference.Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(android.preference.Preference prefs, Object obj) {

                String items = (String) obj;
                if (prefs.getKey().equals("ORIENTATION")) {
                    switch (items) {
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

                    ListPreference listPreference1 = (ListPreference) prefs;
                    listPreference1.setSummary(listPreference1.getEntries()[listPreference1.findIndexOfValue(items)]);

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
        Load_setting();
        super.onResume();
    }
}
