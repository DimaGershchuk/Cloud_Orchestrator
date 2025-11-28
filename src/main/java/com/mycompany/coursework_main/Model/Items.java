/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.coursework_main.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 *
 * @author Sergii
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Items {

    // Unique id for each item
    @JsonProperty("id")
    private String id;

    @JsonProperty("item_id")
    private String itemId;

    @JsonProperty("owner_id")
    private String ownerId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("category")
    private String category;

    
    @JsonProperty("location")
    private String location;
    
    @JsonProperty("latitude")
    private Double latitude;
    
    @JsonProperty("longitude")
    private Double longitude;

    @JsonProperty("daily_rate")
    private double dailyRate;

    @JsonProperty("available")
    private boolean available;

    @JsonProperty("condition")
    private String condition;

    @JsonProperty("description")
    private String description;

    //Field does not exist in database, but we use it for calculating distance between user and item
    private Double distance;
    
    // Default empty constructor
    public Items() {}

    // --- Getters ---
    public String getItemId() { return itemId; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public Double getLatitude() {return latitude;}
    public Double getLongitude() {return longitude; }
    public double getDailyRate() { return dailyRate; }
    public boolean getAvailable() {return available;}
    public String getCondition() {return condition; }
    public String getDescription() {return description; }
    public Double getDistance() {return distance;}
    
    // --- Setters ---
    public void setId(String id) {
        this.id = id;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
    

    @Override
    public String toString() {
        return "Item{name='" + name + "', price=" + dailyRate + ", city='" + location + "'}";
    }
}
