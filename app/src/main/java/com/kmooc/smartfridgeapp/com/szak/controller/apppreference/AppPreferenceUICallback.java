package com.kmooc.smartfridgeapp.com.szak.controller.apppreference;

import com.kmooc.smartfridgeapp.com.szak.model.AppPreference;

import java.util.List;

public interface AppPreferenceUICallback {
    void onPreferenceDataReady(List<AppPreference> appPreferences);
    void onPreferenceDataFail(String message);
}
