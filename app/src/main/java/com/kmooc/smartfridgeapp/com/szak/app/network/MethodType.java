package com.kmooc.smartfridgeapp.com.szak.app.network;

public enum MethodType {
    GET, POST, PUT, DELETE;

    private String value;

    static {
        GET.value = "GET";
        POST.value = "POST";
        PUT.value = "PUT";
        DELETE.value = "DELETE";
    }

    public String getMethodType() {
        return this.value;
    }
}
