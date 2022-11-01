/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEA.PhoniexAirlines.blockunblock.dao;

import DEA.PhoniexAirlines.Staff.model.StaffMember;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Raffael
 */
public class unblock {
    Connection con;

    public unblock(Connection con) {
        this.con = con;
    }
     
   public boolean unblockStaff(StaffMember unbStaff){
        boolean unblocked = false;
        
        try{
            
            String query = "INSERT INTO staff (username, email, password, grade) VALUES (?,?,?,?)";
           
            
            PreparedStatement ps = this.con.prepareStatement(query);
      
            
            ps.setString(1, unbStaff.getUsername());
            ps.setString(2, unbStaff.getEmail());
            ps.setString(3, unbStaff.getPassword());
            ps.setString(4, unbStaff.getGrade());
           
       
            ps.executeUpdate();
            
    
           
            unblocked = true;
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return unblocked;
    } 
}
