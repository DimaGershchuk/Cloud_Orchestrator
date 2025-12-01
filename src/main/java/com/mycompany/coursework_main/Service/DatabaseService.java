/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.coursework_main.Service;
import com.azure.cosmos.*;
import com.azure.cosmos.models.CosmosQueryRequestOptions;
import com.azure.cosmos.models.SqlParameter;
import com.azure.cosmos.models.SqlQuerySpec;
import com.azure.cosmos.util.CosmosPagedIterable;
import com.mycompany.coursework_main.Model.Items;
import com.mycompany.coursework_main.Model.RentalRequest;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Sergii
 */
public class DatabaseService {
    private static final String HOST = "https://myfirstfreedb.documents.azure.com:443/";
    private static final String KEY = "AEdwAeGz2Ga7R0AOTaQ02uzgej2UeIUCGdghPYIWMfeCuuabBqiP3QAdicUyuVc14HsiuFsNxueHACDboJWLjg==";
    private static final String DATABASE_NAME = "coursework";
    
    private CosmosClient client;
    private CosmosContainer itemContainer;    
    private CosmosContainer requestContainer;

    //Create connection to CosmosDb
    public DatabaseService() {
        this.client = new CosmosClientBuilder()
            .endpoint(HOST)
            .key(KEY)
            .consistencyLevel(ConsistencyLevel.EVENTUAL)
            .buildClient();

        CosmosDatabase database = client.getDatabase(DATABASE_NAME);
        this.itemContainer = database.getContainer("items"); //Working with items container
        this.requestContainer = database.getContainer("requests"); // Working with requests container to manage item`s request
    }

    //Working with items requests
    public List<Items> getItemsFiltered(String city, Double maxPrice) {
        List<Items> resultList = new ArrayList<>();
        List<SqlParameter> params = new ArrayList<>();
        
        StringBuilder sql = new StringBuilder("Select * FROM c WHERE 1=1");
        
        //Fetching imems with only city parameter
        if(city != null && !city.isEmpty()){
            sql.append(" AND LOWER(c.location) = @city");
            params.add(new SqlParameter("@city", city.toLowerCase()));
        }
        
        //Fetching imems with only price parameter
        if(maxPrice != null && maxPrice > 0){
            sql.append(" AND c.daily_rate <= @maxPrice");
            params.add(new SqlParameter("@maxPrice", maxPrice));
        }
        
        SqlQuerySpec querySpec = new SqlQuerySpec(sql.toString(), params);
        try {
            CosmosPagedIterable<Items> response = itemContainer.queryItems(
                querySpec,
                new CosmosQueryRequestOptions(),
                Items.class
            );

            response.forEach(resultList::add);
            
        } catch (Exception e) {
            System.err.println("Searching error: " + e.getMessage());
            e.printStackTrace();
        }
        
        return resultList;
    }
    
    public void createRequest(RentalRequest request){
        requestContainer.createItem(request);
    }
    
    
}
