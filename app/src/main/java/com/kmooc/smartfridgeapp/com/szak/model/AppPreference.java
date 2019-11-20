package com.kmooc.smartfridgeapp.com.szak.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.kmooc.smartfridgeapp.com.szak.app.AppController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "value",
        "userId",
        "createdAt",
        "updatedAt"
})
public class AppPreference {
    @JsonProperty("name")
    private String key;
    @JsonProperty("value")
    private String value;
    @JsonProperty("userId")
    private int userId;
    @JsonProperty("createdAt")
    private Date createdAt;
    @JsonProperty("updatedAt")
    private Date updatedAt;

    public AppPreference() {}

    public AppPreference(String key, String value) {
        this.key = key;
        this.value = value;
        this.userId = AppController.userId;
    }

    public AppPreference(String key, String value, int userId) {
        this.key = key;
        this.value = value;
        this.userId = userId;
    }

    public AppPreference(String key, String value, int userId, Date createdAt, Date updatedAt) {
        this.key = key;
        this.value = value;
        this.userId = userId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    @JsonProperty("createdAt")
    public Date getCreatedAt() {
        return createdAt;
    }
    @JsonProperty("createdAt")
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    @JsonProperty("updatedAt")
    public Date getUpdatedAt() {
        return updatedAt;
    }
    @JsonProperty("updatedAt")
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("name")
    public String getKey() {
        return key;
    }
    @JsonProperty("name")
    public void setKey(String key) {
        this.key = key;
    }
    @JsonProperty("value")
    public String getValue() {
        return value;
    }
    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }
    @JsonProperty("userId")
    public int getUserId() {
        return userId;
    }
    @JsonProperty("userId")
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
