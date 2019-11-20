package com.kmooc.smartfridgeapp.com.szak.controller.apppreference;

import com.kmooc.smartfridgeapp.com.szak.model.AppPreference;

import java.util.List;

public interface AppPreferenceCallback {
    void onRetrieveSuccessful(List<AppPreference> appPreferences);
    void onRetrieveFailed(String responseMessage);
}
