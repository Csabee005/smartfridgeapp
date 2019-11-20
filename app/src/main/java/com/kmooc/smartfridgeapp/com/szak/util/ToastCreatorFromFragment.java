package com.kmooc.smartfridgeapp.com.szak.util;

import android.app.Activity;
import android.widget.Toast;

public class ToastCreatorFromFragment {
    public static void write(final Activity activity, final String message, final int duration) {
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(activity, message, duration).show();
                }
            });
        }
    }
}
