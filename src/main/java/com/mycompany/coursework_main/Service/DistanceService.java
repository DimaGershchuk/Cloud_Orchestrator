/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.coursework_main.Service;
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
import java.net.http.HttpResponse;

/**
 *
 * @author Sergii
 */
public class DistanceService {
   
    private static final HttpClient client = HttpClient.newBuilder().build();
    private static final ObjectMapper mapper = new ObjectMapper();
    
    public Double getDistance(double userLon, double userLat, double itemLon, double itemLat) throws IOException, InterruptedException {
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
             
             if(response.statusCode() == 200){
                //Deserializing, convert the JSON to Java object 
                Routes data = mapper.readValue(response.body(), Routes.class);
                
                if(data.getRoutes() != null && data.getRoutes().length > 0){
                    //Return distance of first found route
                    return data.getRoutes()[0].getDistance();
                }
              } 
              
        } catch(IOException | InterruptedException e){
            System.err.println("OSRM Error: " + e.getMessage());
            return null;
        }
        return null; 
    }
}
