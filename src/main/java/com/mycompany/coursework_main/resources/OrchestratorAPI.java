package com.mycompany.coursework_main.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("rest")
public class OrchestratorAPI {
    
    @GET
    public Response ping(){
        return Response
                .ok("ping")
                .build();
    }
}
