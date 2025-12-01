/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.coursework_main.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

/**
 *
 * @author Sergii
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class RentalRequest {
    @JsonProperty("id")
    private String id;

    @JsonProperty("item_id")
    private String itemId;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("status")
    private String status; // "pending", "cancelled", "approved"

    // Default constructor
    public RentalRequest() {
        // Genarating randon UUID for each request
        this.id = UUID.randomUUID().toString();
        this.status = "pending"; // Default status
    }

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getItemId() { return itemId; }
    public void setItemId(String itemId) { this.itemId = itemId; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Request{id=" + id + ", item=" + itemId + ", status=" + status + "}";
    }
}
