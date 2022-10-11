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
public class approvaldao {
    Connection con;

    public approvaldao(Connection con) {
        this.con = con;
    }
     
   public boolean staffApproval(StaffMember apprStaff){
        boolean registered = false;
        
        try{
            
            String query = "INSERT INTO staff (username, email, password, grade) VALUES (?,?,?,?)";
           
            
            PreparedStatement ps = this.con.prepareStatement(query);
      
            
            ps.setString(1, apprStaff.getUsername());
            ps.setString(2, apprStaff.getEmail());
            ps.setString(3, apprStaff.getPassword());
            ps.setString(4, apprStaff.getGrade());
           
       
            ps.executeUpdate();
            
    
           
            registered = true;
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return registered;
    }
}
