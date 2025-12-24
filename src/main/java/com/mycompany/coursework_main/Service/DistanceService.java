/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.coursework_main.Service;
import com.azure.json.implementation.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.coursework_main.Model.Routes;
import java.io.IOException;
import java.net.URI;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.Map;
import java.net.http.HttpResponse;
import java.util.concurrent.ConcurrentHashMap;
import java.net.http.HttpTimeoutException;
import java.time.Duration;

/**
 *
 * @author Sergii
 */
public class DistanceService {
   
    private static final HttpClient client = HttpClient.newBuilder()
                                                .connectTimeout(Duration.ofSeconds(5))
                                                .build();
    
    private static final ObjectMapper mapper = new ObjectMapper();
    
    // Using ConcurrentHashMap to store API query results.
    // This ensures Thread-Safety when accessed by multiple concurrent users (simulating Big Data load).
    // Key (String): Unique composite key of coordinates.
    // Value (Double): Calculated distance in kilometers.
    private static final Map<String, Double> distanceCache = new ConcurrentHashMap<>();
    
    public Double getDistance(double userLon, double userLat, double itemLon, double itemLat) throws IOException, InterruptedException {
        
        //Generate cache key
        String cashKey = userLat + "," + userLon + "-" + itemLat + "," + itemLon;
        
        // Check if the distance for this specific route has already been computed.
        // If found, return the value instantly from memory (O(1) complexity),
        if(distanceCache.containsKey(cashKey)){
            return distanceCache.get(cashKey);
        }
        
        
        try {
            
            
            //Build URL to connect with external API
            String API_BASE_URL = String.format(java.util.Locale.US,"http://router.project-osrm.org/route/v1/driving/%f,%f;%f,%f?overview=false",
                userLon, userLat, itemLon, itemLat);

            //Creating HTTP GET request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_BASE_URL))
                    .GET()
                    .build();
            
             //Sending request and receiving response
             HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
             int status = response.statusCode();
             
             if(status == 200){
                //Deserializing, convert the JSON to Java object 
                Routes data = mapper.readValue(response.body(), Routes.class);
                
                if(data.getRoutes() != null && data.getRoutes().length > 0){
                    //Return distance of first found route
                    Double dist = data.getRoutes()[0].getDistance() / 1000;
                    // Store the valid result in the cache before returning.
                    distanceCache.put(cashKey, dist);
                    return dist;
                }
              } else if (status >= 400 && status < 500) {
                  System.err.println("Client Error (OSRM): " + status + " for URL: " + API_BASE_URL);
                  return null;
              } else if (status >= 500) {
                  System.err.println("Server Error (OSRM): " + status);
                  return null;
              }
        }
        
        catch(HttpTimeoutException e){
            System.err.println("Timeout Error: OSRM API took too long to respond.");
            return null;
        }
        
        catch (JsonProcessingException e) {
            System.err.println("Data Error: Could not parse OSRM response. " + e.getMessage());
        }
        
        catch(IOException | InterruptedException e){
            System.err.println("OSRM Error: " + e.getMessage());
            return null;
        } 
        
        return null; 
    }
    
    // Utility method to clear the cache.
    public void clearCache() {
        distanceCache.clear();
        System.out.println("--- CACHE CLEARED ---");
    }
}
