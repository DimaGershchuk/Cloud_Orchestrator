package com.mycompany.coursework_main.resources;

import com.mycompany.coursework_main.Model.Items;
import com.mycompany.coursework_main.Service.DatabaseService;
import com.mycompany.coursework_main.Service.DistanceService;
import java.io.IOException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("rest")
public class OrchestratorAPI {
    
    private DatabaseService dbService = new DatabaseService();
    private DistanceService distanceService = new DistanceService();
    
    @GET
    @Path("/ping")
    public String ping() {
        return "Server is working!";
    }
    
    @GET
    @Path("/items")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Items> searchItems(
        @QueryParam("city") String city,
        @QueryParam("maxPrice") Double maxPrice,
        @QueryParam("userLat") Double userLat,
        @QueryParam("userLon") Double userLon) throws IOException, InterruptedException {
            
        List<Items> items = dbService.getItemsFiltered(city, maxPrice);
        if(userLat != null && userLon != null){
            for(Items item : items){
                if(item.getLatitude() != null && item.getLongitude() != null){
                    Double dist = distanceService.getDistance(userLon, userLat, item.getLatitude(), item.getLongitude());
                    item.setDistance(dist);
                }
            }
        }
        return items;
    }
    
}

