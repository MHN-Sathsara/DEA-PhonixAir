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
public class flightdeletedao{
    Connection con;

    public flightdeletedao(Connection con) {
        this.con = con;
    }
   boolean deleted;
   
   public boolean deleteflightfromArrival(flight flight){
       
        deleted = false;
        
        try{
            
            String query = "DELETE FROM flightarrival WHERE fid = ?";
           
            
            PreparedStatement ps = this.con.prepareStatement(query);
      
            
            ps.setInt(1, flight.getId());
            
           
       
            ps.executeUpdate();
            
    
           
            deleted = true;
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return deleted;
   }
   
      public boolean deleteflightfromDeparture(flight flight){
       
        deleted = false;
        
        try{
            
            String query = "DELETE FROM flightDeparture WHERE fid = ?";
           
            
            PreparedStatement ps = this.con.prepareStatement(query);
      
            
            ps.setInt(1, flight.getId());
            
           
       
            ps.executeUpdate();
            
    
           
            deleted = true;
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return deleted;
   }
}
