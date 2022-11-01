/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEA.PhoniexAirlines.Client.blockunblock.dao;

import DEA.PhoniexAirlines.Client.model.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Raffael
 */
public class clientunblock {
    Connection con;

    public clientunblock(Connection con) {
        this.con = con;
    }
     
   public boolean unblockClient(Client unbclient){
        boolean unblocked = false;
        
        try{
            
            String query = "INSERT INTO client (nic, username, email, password) VALUES (?,?,?,?)";
           
            
            PreparedStatement ps = this.con.prepareStatement(query);
      
            
            ps.setString(1, unbclient.getNIC());
            ps.setString(2, unbclient.getUsername());
            ps.setString(3, unbclient.getEmail());
            ps.setString(4, unbclient.getPassword());
           
       
            ps.executeUpdate();
            
    
           
            unblocked = true;
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return unblocked;
    } 
}
