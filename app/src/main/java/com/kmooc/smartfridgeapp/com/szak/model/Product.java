package com.kmooc.smartfridgeapp.com.szak.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Date;

/* "id": 1,
    "name": "Milk",
    "category": "Dairy",
    "calories": "260",
    "unit": "l",
    "description": "Everyone's favourite.",
    "createdAt": "2019-09-07T00:00:00.000Z",
    "updatedAt": "2019-09-07T00:00:00.000Z"*/

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "category",
        "calories",
        "unit",
        "description",
        "createdAt",
        "updatedAt"
})
public class Product {
    @JsonProperty("id")
    private final String id;
    @JsonProperty("name")
    private final String name;
    @JsonProperty("category")
    private final String category;
    @JsonProperty("calories")
    private final String calories;
    @JsonProperty("unit")
    private final String unit;
    @JsonProperty("description")
    private final String description;
    @JsonProperty("createdAt")
    private final Date createdAt;
    @JsonProperty("updatedAt")
    private final Date updatedAt;

    public Product(String id, String name, String category, String calories, String unit, String description, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.calories = calories;
        this.unit = unit;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    @JsonProperty("id")
    public String getId() {
        return id;
    }
    @JsonProperty("name")
    public String getName() {
        return name;
    }
    @JsonProperty("category")
    public String getCategory() {
        return category;
    }
    @JsonProperty("calories")
    public String getCalories() {
        return calories;
    }
    @JsonProperty("unit")
    public String getUnit() {
        return unit;
    }
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }
    @JsonProperty("createdAt")
    public Date getCreatedAt() {
        return createdAt;
    }
    @JsonProperty("updatedAt")
    public Date getUpdatedAt() {
        return updatedAt;
    }
}
