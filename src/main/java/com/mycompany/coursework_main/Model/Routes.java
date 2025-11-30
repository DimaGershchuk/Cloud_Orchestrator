/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.coursework_main.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Sergii
 */
public class Routes {
    
     private String code;

       private Route[] routes;

       private Waypoint[] waypoints;

       public String getCode() { return code; }

       public void setCode(String value) { this.code = value; }

       public Route[] getRoutes() { return routes; }

       public void setRoutes(Route[] value) { this.routes = value; }

       public Waypoint[] getWaypoints() { return waypoints; }

       public void setWaypoints(Waypoint[] value) { this.waypoints = value; }


   @JsonIgnoreProperties(ignoreUnknown = true)
   public static class Route {

       private Leg[] legs;

       private String weightName;

       private double weight;

       private double duration;

       private double distance;


       public Leg[] getLegs() { return legs; }

       public void setLegs(Leg[] value) { this.legs = value; }



       public String getWeightName() { return weightName; }

       public void setWeightName(String value) { this.weightName = value; }



       public double getWeight() { return weight; }

       public void setWeight(double value) { this.weight = value; }



       public double getDuration() { return duration; }

       public void setDuration(double value) { this.duration = value; }



       public double getDistance() { return distance; }

       public void setDistance(double value) { this.distance = value; }

   }

   @JsonIgnoreProperties(ignoreUnknown = true)

   public static class Leg {

       private Object[] steps;

       private double weight;

       private String summary;

       private double duration;

       private double distance;



       public Object[] getSteps() { return steps; }

       public void setSteps(Object[] value) { this.steps = value; }



       public double getWeight() { return weight; }

       public void setWeight(double value) { this.weight = value; }



       public String getSummary() { return summary; }

       public void setSummary(String value) { this.summary = value; }



       public double getDuration() { return duration; }

       public void setDuration(double value) { this.duration = value; }



       public double getDistance() { return distance; }

       public void setDistance(double value) { this.distance = value; }

   }

   @JsonIgnoreProperties(ignoreUnknown = true)

   public static class Waypoint {

       private String hint;

       private double[] location;

       private String name;

       private double distance;



       public String getHint() { return hint; }

       public void setHint(String value) { this.hint = value; }



       public double[] getLocation() { return location; }

       public void setLocation(double[] value) { this.location = value; }



       public String getName() { return name; }

       public void setName(String value) { this.name = value; }



       public double getDistance() { return distance; }

       public void setDistance(double value) { this.distance = value; }

   }
}
