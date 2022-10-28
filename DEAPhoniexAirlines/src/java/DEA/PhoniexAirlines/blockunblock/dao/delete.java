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
public class delete {
    Connection con;

    public delete(Connection con) {
        this.con = con;
    }
     
   public boolean deleteStaff(StaffMember denyStaff){
        boolean deleted = false;
        
        try{
            
            String query = "DELETE FROM staff WHERE email = ?";
           
            
            PreparedStatement ps = this.con.prepareStatement(query);
      
            
            ps.setString(1, denyStaff.getEmail());
            
           
       
            ps.executeUpdate();
            
    
           
            deleted = true;
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return deleted;
    }
}
