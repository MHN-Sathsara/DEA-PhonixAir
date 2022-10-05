/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEA.PhoniexAirlines.Admin.DAO;

import DEA.PhoniexAirlines.Admin.model.Admin;
import DEA.PhoniexAirlines.Admin.services.logadmin;
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
public class Admindao implements logadmin{
    private Connection con;
    private String query;
    private PreparedStatement ps;
    private ResultSet rs;

    public Admindao(Connection con) {
        this.con = con;
    }
    
    @Override
    public Admin logAdmin(String username,String password){
        Admin admin = null;
        
        query = "SELECT * FROM admin WHERE username=? AND password=?"; //? is for the unknown
        try {
            ps = this.con.prepareStatement(query);
            ps.setString(1,username);
            ps.setString(2,password);//position, value to be put at that position
            
            rs = ps.executeQuery();
            if(rs.next()){
                
                admin = new Admin();
                
                admin.setId(rs.getInt("id"));
                admin.setUsername(rs.getString("username"));
                admin.setEmail(rs.getString("email"));
                admin.setPassword(rs.getString("password"));
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admindao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return admin;
    }
}
