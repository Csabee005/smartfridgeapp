package com.kmooc.smartfridgeapp.com.szak;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.kmooc.smartfridgeapp.R;
import com.kmooc.smartfridgeapp.com.szak.util.ThemeUtils;

public class ThemeTestActivity extends AppCompatActivity {
    public static int currentPosition;
    private Spinner spThemes;

    // Here we set the theme for the activity
    // Note `Utils.onActivityCreateSetTheme` must be called before `setContentView`
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // MUST BE SET BEFORE setContentView
        ThemeUtils.onActivityCreateSetTheme(this);
        // AFTER SETTING THEME
        setContentView(R.layout.testlayout);
        setupSpinnerItemSelection();
    }

    private void setupSpinnerItemSelection() {
        spThemes = (Spinner) findViewById(R.id.spThemes);
        spThemes.setSelection(ThemeTestActivity.currentPosition);
        ThemeTestActivity.currentPosition = spThemes.getSelectedItemPosition();

        spThemes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                if (ThemeTestActivity.currentPosition != position) {
                    ThemeUtils.changeToTheme(ThemeTestActivity.this, position);
                }
                ThemeTestActivity.currentPosition = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
