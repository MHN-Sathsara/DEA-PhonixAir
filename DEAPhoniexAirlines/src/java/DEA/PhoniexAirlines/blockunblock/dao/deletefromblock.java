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
public class deletefromblock {
    Connection con;

    public deletefromblock(Connection con) {
        this.con = con;
    }
     
   public boolean deleteStaff(StaffMember delStaff){
        boolean deleted = false;
        
        try{
            
            String query = "DELETE FROM blockedstaff WHERE email = ?";
           
            
            PreparedStatement ps = this.con.prepareStatement(query);
      
            
            ps.setString(1, delStaff.getEmail());
            
           
       
            ps.executeUpdate();
            
    
           
            deleted = true;
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return deleted;
    }
}
