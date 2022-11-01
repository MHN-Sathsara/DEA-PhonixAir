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
public class deleteclient {
    Connection con;
    
    public deleteclient(Connection con){
        this.con = con;
    
    }
    
    public boolean deleteClient(Client delclient){
        boolean deleted = false;
        
        try{
            String query = "DELETE FROM client WHERE nic = ?";
            
            PreparedStatement ps = this.con.prepareStatement(query);
            
            ps.setString(1, delclient.getNIC());
            
            ps.executeUpdate();
            
            deleted = true;
            
        }catch(SQLException e){
            e.printStackTrace();

        }
        
        return deleted;
    }
}
