/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEA.PhoniexAirlines.Staff.dao;

import DEA.PhoniexAirlines.Staff.model.StaffMember;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Raffael
 */
public class denydao {
    Connection con;

    public denydao(Connection con) {
        this.con = con;
    }
     
   public boolean staffDenial(StaffMember denyStaff){
        boolean registered = false;
        
        try{
            
            String query = "DELETE FROM staffrequest WHERE email = ?";
           
            
            PreparedStatement ps = this.con.prepareStatement(query);
      
            
            ps.setString(1, denyStaff.getEmail());
            
           
       
            ps.executeUpdate();
            
    
           
            registered = true;
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return registered;
    }
}
