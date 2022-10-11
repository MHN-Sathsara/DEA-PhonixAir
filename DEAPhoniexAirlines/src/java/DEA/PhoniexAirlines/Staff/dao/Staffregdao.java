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
public class Staffregdao {
    Connection con;

    public Staffregdao(Connection con) {
        this.con = con;
    }
     
   public boolean staffRegistration(StaffMember regStaff){
        boolean registered = false;
        
        try{
            
            String query = "INSERT INTO staffrequest (username, email, grade, password) VALUES (?,?,?,?)";
           
            PreparedStatement ps = this.con.prepareStatement(query);
            ps.setString(1, regStaff.getUsername());
            ps.setString(2, regStaff.getEmail());
            ps.setString(3, regStaff.getGrade());
            ps.setString(4, regStaff.getPassword());
           
           ps.executeUpdate();
           
           registered = true;
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return registered;
    }
}
