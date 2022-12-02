/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEA.PhoniexAirlines.Flights.dao;

import DEA.PhoniexAirlines.Flight.model.flight;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Raffael
 */
public class addflightdao{
    
    Connection con;
    
    public addflightdao(Connection con){
        this.con = con;
    }
    
    public boolean addFlightArrival(flight fl){
        boolean added = false;
         
        try{
             
            String query = "INSERT INTO flightarrival(arrival, flight, departed_from, airline, aircraft, status) VALUES(?,?,?,?,?,?)";
            
            PreparedStatement ps = this.con.prepareStatement(query);
            
            ps.setString(1, fl.getTime());
            ps.setString(2, fl.getFlight());
            ps.setString(3, fl.getFrom());
            ps.setString(4, fl.getAirline());
            ps.setString(5, fl.getAircraft());
            ps.setString(6, fl.getStatus());
            
            added = true;
            
            ps.executeUpdate();
             
        }catch(SQLException e){
            e.printStackTrace();
        }
         
         return added;
    }
}
