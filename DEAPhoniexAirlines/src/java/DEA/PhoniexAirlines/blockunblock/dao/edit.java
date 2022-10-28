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
public class edit {
    Connection con;

    public edit(Connection con) {
        this.con = con;
    }
     
   public boolean editStaff(StaffMember regStaff){
        boolean edited = false;
        
        try{
            
            String query = "UPDATE staff SET username = ?, email = ?, grade = ? WHERE id = ?";
           
            PreparedStatement ps = this.con.prepareStatement(query);
            ps.setString(1, regStaff.getUsername());
            ps.setString(2, regStaff.getEmail());
            ps.setString(3, regStaff.getGrade());
            ps.setInt(4, regStaff.getId());
           
           ps.executeUpdate();
           
           edited = true;
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return edited;
    }
}
