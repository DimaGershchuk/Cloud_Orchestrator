package com.mycompany.coursework_main.resources;

import com.mycompany.coursework_main.Model.Items;
import com.mycompany.coursework_main.Service.DatabaseService;
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
        @QueryParam("maxPrice") Double maxPrice) {
    return dbService.getItemsFiltered(city, maxPrice);
}
}

