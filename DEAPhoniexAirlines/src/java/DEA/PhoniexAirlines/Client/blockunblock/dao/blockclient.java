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
public class blockclient {
    Connection con;

    public blockclient(Connection con) {
        this.con = con;
    }
     
   public boolean blockClient(Client blockedclient){
        boolean blocked = false;
        
        try{
            
            String query = "INSERT INTO blockedclient (nic, username, email, password) VALUES (?,?,?,?)";
           
            
            PreparedStatement ps = this.con.prepareStatement(query);
      
            
            ps.setString(1, blockedclient.getNIC());
            ps.setString(2, blockedclient.getUsername());
            ps.setString(3, blockedclient.getEmail());
            ps.setString(4, blockedclient.getPassword());
           
       
            ps.executeUpdate();
            
    
           
            blocked = true;
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return blocked;
    } 
}
