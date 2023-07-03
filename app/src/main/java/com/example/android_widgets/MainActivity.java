package com.example.android_widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "prefs";
    private static final String PREF_THEME = "theme";
    private boolean useBlueTheme;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the application's theme
        preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean useBlueTheme = preferences.getBoolean(PREF_THEME, true);
        setTheme(useBlueTheme ? R.style.BlueTheme : R.style.RedTheme);

        setContentView(R.layout.activity_main);

        // Initialize the theme switch
        Switch themeSwitch = findViewById(R.id.theme_switch);
        themeSwitch.setChecked(useBlueTheme);
        themeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Save the new theme preference
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean(PREF_THEME, isChecked);
                editor.apply();

                // Restart the activity to apply the new theme
                recreate();
            }
        });



    }


}