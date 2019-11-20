package com.kmooc.smartfridgeapp.com.szak.app.network;

public enum ProtocolType {
    HTTP, HTTPS;

    private String value;

    static {
        HTTP.value = "http";
        HTTPS.value = "https";
    }

    public String getProtocolValue() {
        return this.value;
    }
}
