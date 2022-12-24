/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEA.PhoniexAirlines.tickets.dao;

import DEA.PhoniexAirlines.tickets.model.roundtrip;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Raffael
 */
public class addroundtrip {
    Connection con;
    
    public addroundtrip(Connection con){
        this.con = con;
    }
    
    public boolean addreturnTicket(roundtrip rt){
        boolean booked = false;
         
        try{
             
            String query = "INSERT INTO roundtripbookings(ticketid, tickettype, usermail, userfullname, passportid, destination, ticketclass, depdate, rdate, adult, child, price) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement ps = this.con.prepareStatement(query);
            
            ps.setString(1, rt.getTid());
            ps.setString(2, rt.getType());
            ps.setString(3, rt.getUsermail());
            ps.setString(4, rt.getUserfname());
            ps.setString(5, rt.getUserpassportid());
            ps.setString(6, rt.getDestination());
            ps.setString(7, rt.getTclass());
            ps.setString(8, rt.getDepdate());
            ps.setString(9, rt.getReturndate());
            ps.setInt(10, rt.getAtickets());
            ps.setInt(11, rt.getCtickets());
            ps.setFloat(12, rt.getPrice());
            
            booked = true;
            
            ps.executeUpdate();
             
        }catch(SQLException e){
            e.printStackTrace();
        }

         return booked;
    }
}
