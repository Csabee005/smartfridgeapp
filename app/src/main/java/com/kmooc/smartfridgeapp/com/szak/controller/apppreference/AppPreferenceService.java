package com.kmooc.smartfridgeapp.com.szak.controller.apppreference;

import android.net.Network;
import android.net.Uri;
import android.os.AsyncTask;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kmooc.smartfridgeapp.R;
import com.kmooc.smartfridgeapp.com.szak.app.network.MethodType;
import com.kmooc.smartfridgeapp.com.szak.app.network.NetworkMapping;
import com.kmooc.smartfridgeapp.com.szak.app.network.ProtocolType;
import com.kmooc.smartfridgeapp.com.szak.model.AppPreference;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class AppPreferenceService extends AsyncTask<Object, String, String> {

    private AppPreferenceCallback controllerCallback;

    public AppPreferenceService(AppPreferenceCallback controllerCallback) {
        this.controllerCallback = controllerCallback;
    }

    // objects[0] PROTOCOLTYPE = protocolType
    // objects[1] STRING = url
    // objects[2] METHODTYPE = methodType
    // objects[3] ARRAY = paramArray
    // objects[4] MAP = hashMap
    // objects[5] STRING = body
    @Override
    protected String doInBackground(Object[] objects) {
        try {
            URL signInEndPoint = buildUrl((ProtocolType)objects[0], objects[1].toString(), (String[])objects[3], (HashMap<String, String>)objects[4]);

            HttpURLConnection connection = createHttpUrlConnection((MethodType)objects[2], signInEndPoint);
            connection.setConnectTimeout(5000);
            boolean shouldGetResponse = ((MethodType)objects[2]).getMethodType().equals("GET");
            connection.setDoOutput(((MethodType)objects[2]).getMethodType().equals("POST"));
            appendJsonString(objects[5], connection);

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpsURLConnection.HTTP_OK && shouldGetResponse) {
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String response = br.readLine();
                controllerCallback.onRetrieveSuccessful(getPreferencesFromString(response));
            }
            else if (responseCode == HttpsURLConnection.HTTP_OK) {
                String response = connection.getResponseMessage();
                controllerCallback.onRetrieveSuccessful(null);
            }
            else {
                String response = connection.getResponseMessage();
                controllerCallback.onRetrieveFailed(response);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<AppPreference> getPreferencesFromString(String response) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        try {
            return objectMapper.readValue(response, new TypeReference<ArrayList<AppPreference>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void appendJsonString(Object object, HttpURLConnection connection) throws IOException {
        if (object instanceof String && !object.toString().isEmpty()) {
            DataOutputStream os = new DataOutputStream(connection.getOutputStream());
            os.writeBytes(object.toString());
            os.flush();
            os.close();
        }
    }

    private HttpURLConnection createHttpUrlConnection(MethodType methodType, URL signInEndPoint) throws IOException {
        HttpURLConnection connection = (HttpURLConnection)signInEndPoint.openConnection();
        connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        connection.setRequestProperty("Accept","application/json");
        connection.setRequestMethod(methodType.getMethodType());
        return connection;
    }

    private URL buildUrl(ProtocolType protocolType, String urlString, String[] parameterArray, HashMap<String, String> queryParams) throws MalformedURLException {
        Uri.Builder urlBuilder = new Uri.Builder();
        urlBuilder.encodedAuthority(NetworkMapping.ADDRESS)
                .scheme(protocolType.getProtocolValue());
        urlBuilder.appendPath(urlString);
        addParameters(urlBuilder, parameterArray, queryParams);
        return new URL(urlBuilder.build().toString());
    }

    private void addParameters(Uri.Builder urlBuilder, String[] parameterArray, HashMap<String, String> queryParams) {
        for (String urlParameter : parameterArray
             ) {
            urlBuilder.appendPath(urlParameter);
        }
        for (Map.Entry<String, String> queryParameter : queryParams.entrySet()
             ) {
            urlBuilder.appendQueryParameter(queryParameter.getKey(), queryParameter.getValue());
        }
    }
}
