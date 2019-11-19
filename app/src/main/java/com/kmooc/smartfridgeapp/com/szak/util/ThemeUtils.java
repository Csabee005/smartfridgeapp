package com.kmooc.smartfridgeapp.com.szak.util;

import android.app.Activity;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.kmooc.smartfridgeapp.R;

public class ThemeUtils {
    private static int sTheme;

    public final static int THEME_MATERIAL_LIGHT = 0;
    public final static int BASE_GREEN_AND_YELLOW = 1;
    public final static int BLACK_AND_RED = 2;
    public final static int BLUE_AND_CYAN = 3;

    public static void changeToTheme(Activity activity, int theme) {
        sTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
        activity.overridePendingTransition(android.R.anim.fade_in,
                android.R.anim.fade_out);
    }

    public static void onActivityCreateSetTheme(Activity activity) {
        switch (sTheme) {
            default:
            case THEME_MATERIAL_LIGHT:
                activity.setTheme(R.style.Theme_Material_Light);
                break;
            case BASE_GREEN_AND_YELLOW:
                activity.setTheme(R.style.Theme_Green_and_Yellow);
                break;
            case BLACK_AND_RED:
                activity.setTheme(R.style.Theme_Black_and_Red);
                break;
            case BLUE_AND_CYAN:
                activity.setTheme(R.style.Theme_Blue_and_Cyan);
                break;
        }
    }
}
