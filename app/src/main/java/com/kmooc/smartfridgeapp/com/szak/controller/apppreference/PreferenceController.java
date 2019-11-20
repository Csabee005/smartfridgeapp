package com.kmooc.smartfridgeapp.com.szak.controller.apppreference;

import androidx.fragment.app.Fragment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kmooc.smartfridgeapp.com.szak.app.AppController;
import com.kmooc.smartfridgeapp.com.szak.app.network.MethodType;
import com.kmooc.smartfridgeapp.com.szak.app.network.NetworkMapping;
import com.kmooc.smartfridgeapp.com.szak.model.AppPreference;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PreferenceController implements AppPreferenceCallback {
    private List<AppPreference> appPreferences;
    private AppPreferenceUICallback fragmentUI;
    private ObjectMapper objectMapper = new ObjectMapper();

    public PreferenceController(AppPreferenceUICallback fragmentUIContext) {
        this.fragmentUI = fragmentUIContext;
        retrieveAppPreferences();
    }

    public PreferenceController(List<AppPreference> appPreferences) {
        this.appPreferences = appPreferences;
    }

    public List<AppPreference> getAppPreferences() {
        return appPreferences;
    }

    public void setAppPreferences(List<AppPreference> appPreferences) {
        this.appPreferences = appPreferences;
    }

    @Override
    public void onRetrieveSuccessful(List<AppPreference> appPreferences) {
        fragmentUI.onPreferenceDataReady(appPreferences);
    }

    @Override
    public void onRetrieveFailed(String responseMessage) {
        fragmentUI.onPreferenceDataFail(responseMessage);
    }

    // objects[0] PROTOCOLTYPE = protocolType
    // objects[1] STRING = url
    // objects[2] METHODTYPE = methodType
    // objects[3] ARRAY = paramArray
    // objects[4] MAP = hashMap
    // objects[5] STRING = body

    // userId as parameter for everyPreference
    // userId as parameter and name for single preference
    // Post whole created preference for creations
    // userId in parameter, queryParams used for name and value for modification
    // userId in parameter, name in queryParams for deletion

    private void retrieveAppPreferences() {
        AppPreferenceService appPreferenceService = new AppPreferenceService(this);
        Map<String, String> hashQueryParams = new HashMap<>();
        hashQueryParams.put("name","theme");
        appPreferenceService.execute(NetworkMapping.PROTOCOL_TYPE, "preference", MethodType.GET, new String[]{Integer.toString(AppController.userId)}, hashQueryParams, new String[]{});
    }

    public void resetPreferences() {
        AppPreferenceService appPreferenceService = new AppPreferenceService(this);
        Map<String, String> hashQueryParams = new HashMap<>();
        hashQueryParams.put("name","theme");
        appPreferenceService.execute(NetworkMapping.PROTOCOL_TYPE, "preference", MethodType.DELETE, new String[]{Integer.toString(AppController.userId)}, hashQueryParams, new String[]{});
    }

    public void setNewPreference(String key, int position) throws JsonProcessingException {
        AppPreferenceService appPreferenceService = new AppPreferenceService(this);
        AppPreference appPreference = new AppPreference(key, Integer.toString(position), AppController.userId);
        String appPreferenceJSON = objectMapper.writeValueAsString(appPreference);
        appPreferenceService.execute(NetworkMapping.PROTOCOL_TYPE, "preference", MethodType.POST, new String[]{}, new HashMap<>(), appPreferenceJSON);
    }

    public void modifyPreference(String key, int position) throws JsonProcessingException {
        AppPreferenceService appPreferenceService = new AppPreferenceService(this);
        AppPreference appPreference = new AppPreference(key, Integer.toString(position), AppController.userId);
        Map<String, String> hashQueryParams = new HashMap<>();
        hashQueryParams.put("name", key);
        hashQueryParams.put("value", Integer.toString(position));
        appPreferenceService.execute(NetworkMapping.PROTOCOL_TYPE, "preference", MethodType.PUT,  new String[]{Integer.toString(AppController.userId)}, hashQueryParams, new String[]{});
    }
}
