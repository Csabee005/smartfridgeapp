package com.kmooc.smartfridgeapp.com.szak.util;

public enum ThemeType {
    GREEN_AND_YELLOW, BLACK_AND_RED, BLUE_AND_CYAN;

    private int value;

    static {
        GREEN_AND_YELLOW.value = 1;
        BLACK_AND_RED.value = 2;
        BLUE_AND_CYAN.value = 3;
    }

    public int getValue() {
        return this.value;
    }
}
