package com.kmooc.smartfridgeapp.com.szak.util;

import android.graphics.Color;

public enum LightDarkType {
    WHITE, BLACK;

    private int resourceInt;

    static {
        WHITE.resourceInt = Color.WHITE;
        BLACK.resourceInt = Color.BLACK;
    }

    public int getResourceInt() {
        return resourceInt;
    }
}
