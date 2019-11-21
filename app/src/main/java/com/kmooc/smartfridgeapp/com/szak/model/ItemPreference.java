package com.kmooc.smartfridgeapp.com.szak.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "location",
        "createdAt",
        "updatedAt",
        "userId"
})
public class ItemPreference {

    @JsonProperty("name")
    private String name;

    @JsonProperty("location")
    private String location;

    @JsonProperty("createdAt")
    private Date createdAt;
    @JsonProperty("updatedAt")
    private Date updatedAt;
    @JsonProperty("userId")
    private int userId;

    public ItemPreference() {}

    public ItemPreference(String name, String location, Date createdAt, Date updatedAt, int userId) {
        this.name = name;
        this.location = location;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userId = userId;
    }
    @JsonProperty("name")
    public String getName() {
        return name;
    }
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }
    @JsonProperty("location")
    public String getLocation() {
        return location;
    }
    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
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
    @JsonProperty("userId")
    public int getUserId() {
        return userId;
    }
    @JsonProperty("userId")
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
