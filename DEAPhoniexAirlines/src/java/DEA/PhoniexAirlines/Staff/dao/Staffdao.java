/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEA.PhoniexAirlines.Staff.dao;


import DEA.PhoniexAirlines.Staff.model.StaffMember;
import DEA.PhoniexAirlines.Staff.services.logStaff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raffael
 */
public class Staffdao implements logStaff{
    private Connection con;
    private String query;
    private PreparedStatement ps;
    private ResultSet rs;

    public Staffdao(Connection con) {
        this.con = con;
    }
    
    @Override
    public StaffMember logStaff(String username,String password,String grade){
        StaffMember staff = null;
        
        query = "SELECT * FROM staff WHERE username=? AND password=? AND grade=?"; //? is for the unknown
        try {
            ps = this.con.prepareStatement(query);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,grade);//position, value to be put at that position
            
            rs = ps.executeQuery();
            if(rs.next()){
                
                staff = new StaffMember();
                
                staff.setId(rs.getInt("id"));
                staff.setUsername(rs.getString("username"));
                staff.setEmail(rs.getString("email"));
                staff.setPassword(rs.getString("password"));
                staff.setGrade(rs.getString("grade"));
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Staffdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return staff;
    }
}
