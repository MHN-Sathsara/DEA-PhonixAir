/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEA.PhoniexAirlines.tickets.dao;
import DEA.PhoniexAirlines.tickets.model.oneway;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Raffael
 */
public class addoneway {
    Connection con;
    
    public addoneway(Connection con){
        this.con = con;
    }
    
    public boolean addonewayTicket(oneway owt){
        boolean booked = false;
         
        try{
             
            String query = "INSERT INTO onewaybookings(ticketid, tickettype, usermail, userfullname, passportid, destination, ticketclass, depdate, adult, child, price) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement ps = this.con.prepareStatement(query);
            
            ps.setString(1, owt.getTid());
            ps.setString(2, owt.getType());
            ps.setString(3, owt.getUsermail());
            ps.setString(4, owt.getUserfname());
            ps.setString(5, owt.getUserpassportid());
            ps.setString(6, owt.getDestination());
            ps.setString(7, owt.getTclass());
            ps.setString(8, owt.getDepdate());
            ps.setInt(9, owt.getAtickets());
            ps.setInt(10, owt.getCtickets());
            ps.setFloat(11, owt.getPrice());
            
            booked = true;
            
            ps.executeUpdate();
             
        }catch(SQLException e){
            e.printStackTrace();
        }

         return booked;
    }
    
}
