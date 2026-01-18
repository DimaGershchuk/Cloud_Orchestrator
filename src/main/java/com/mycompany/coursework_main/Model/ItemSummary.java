/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.coursework_main.Model;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 *
 * @author Sergii
 */
public class ItemSummary {
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("location")
    private String location;
    
    @JsonProperty("condition")
    private String condition;
    
    @JsonProperty("description")
    private String description;
    
    @JsonProperty("distance")
    private Double distance;
    
    @JsonProperty("daily_rate")
    private Double dailyRate;

    // Mapping constructor from a complete Items object
    public ItemSummary(Items item) {
        this.name = item.getName();
        this.location = item.getLocation();
        this.condition = item.getCondition();
        this.description = item.getDescription();
        this.distance = item.getDistance();
        this.dailyRate = item.getDailyRate();
    }

    // Getters for Jackson deserialisation
    public String getName() { return name; }
    public String getLocation() { return location; }
    public String getCondition() { return condition; }
    public String getDescription() { return description; }
    public Double getDistance() { return distance; }
    public Double getDailtyRate() { return dailyRate; }
}
