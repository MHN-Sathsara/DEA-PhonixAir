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
public class block {
   Connection con;

    public block(Connection con) {
        this.con = con;
    }
     
   public boolean blockStaff(StaffMember apprStaff){
        boolean blocked = false;
        
        try{
            
            String query = "INSERT INTO blockedstaff (username, email, password, grade) VALUES (?,?,?,?)";
           
            
            PreparedStatement ps = this.con.prepareStatement(query);
      
            
            ps.setString(1, apprStaff.getUsername());
            ps.setString(2, apprStaff.getEmail());
            ps.setString(3, apprStaff.getPassword());
            ps.setString(4, apprStaff.getGrade());
           
       
            ps.executeUpdate();
            
    
           
            blocked = true;
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return blocked;
    } 
}
