package com.mycompany.coursework_main.resources;

import com.mycompany.coursework_main.Model.Items;
import com.mycompany.coursework_main.Model.RentalRequest;
import com.mycompany.coursework_main.Service.DatabaseService;
import com.mycompany.coursework_main.Service.DistanceService;
import java.io.IOException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
        @QueryParam("userLon") Double userLon,
        @QueryParam("userLat") Double userLat) throws IOException, InterruptedException {
            
        List<Items> items = dbService.getItemsFiltered(city, maxPrice);
        if(userLat != null && userLon != null){
            for(Items item : items){
                if(item.getLatitude() != null && item.getLongitude() != null){
                    Double dist = distanceService.getDistance(userLon, userLat, item.getLongitude(), item.getLatitude());
                    item.setDistance(dist);
                }
            }
        }
        return items;
    }
    
    @POST
    @Path("/requests")
    @Consumes(MediaType.APPLICATION_JSON) // Consume JSON
    @Produces(MediaType.APPLICATION_JSON)
    public Response createRequest(RentalRequest request){
        request.setStatus("pending");
        try {
            dbService.createRequest(request);
            return Response.status(Response.Status.CREATED).entity(request).build();
        } catch (Exception e) {
            return Response.serverError().entity("Error creating request").build();
        }
    }
}

