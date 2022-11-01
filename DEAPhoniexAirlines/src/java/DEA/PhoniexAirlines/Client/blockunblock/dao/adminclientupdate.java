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
public class adminclientupdate {
    Connection con;

    public adminclientupdate(Connection con) {
        this.con = con;
    }
     
   public boolean editClient(Client aupclient){
        boolean edited = false;
        
        try{
            
            String query = "UPDATE client SET username = ?, email = ? WHERE id = ?";
           
            PreparedStatement ps = this.con.prepareStatement(query);
            ps.setString(1, aupclient.getUsername());
            ps.setString(2, aupclient.getEmail());
            ps.setInt(3, aupclient.getId());
           
           ps.executeUpdate();
           
           edited = true;
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return edited;
   }
}
