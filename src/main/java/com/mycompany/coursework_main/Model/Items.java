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

    // Це унікальний ID документа в базі (той довгий GUID)
    @JsonProperty("id")
    private String id;

    // Це твій логічний ID товару ("i002")
    @JsonProperty("item_id")
    private String itemId;

    @JsonProperty("owner_id")
    private String ownerId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("category")
    private String category;

    // УВАГА: Поки що це String, бо в базі "Leeds". 
    // Для роботи OSRM пізніше треба буде змінити структуру в базі на координати.
    @JsonProperty("location")
    private String location;

    @JsonProperty("daily_rate")
    private double dailyRate;

    @JsonProperty("available")
    private boolean available; // В JSON "available", не "availability"

    @JsonProperty("condition")
    private String condition;

    @JsonProperty("description")
    private String description;

    // Обов'язковий порожній конструктор
    public Items() {}

    // --- Getters ---
    public String getItemId() { return itemId; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public double getDailyRate() { return dailyRate; }
    
    // Додай інші геттери та сеттери за потреби

    @Override
    public String toString() {
        return "Item{name='" + name + "', price=" + dailyRate + ", city='" + location + "'}";
    }
}
