/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEA.PhoniexAirlines.ClientRegistration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Raffael
 */
public class registerdao {
    Connection con;

    public registerdao(Connection con) {
        this.con = con;
    }
     
    public boolean userRegistration(RegisteredUser Reguser){
        boolean registered = false;
        
        try{
            
            String query = "INSERT INTO client (nic, username, email, password) VALUES (?,?,?,?)";
           
            PreparedStatement ps = this.con.prepareStatement(query);
            ps.setString(1, Reguser.getNic());
            ps.setString(2, Reguser.getUsername());
            ps.setString(3, Reguser.getEmail());
            ps.setString(4, Reguser.getPassword());
           
           ps.executeUpdate();
           
           registered = true;
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return registered;
    }
}
