/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEA.PhoniexAirlines.Client.dao;

import DEA.PhoniexAirlines.Client.model.Client;
import DEA.PhoniexAirlines.Client.services.logClient;
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
public class Clientdao implements logClient{
    private Connection con;
    private String query;
    private PreparedStatement ps;
    private ResultSet rs;

    public Clientdao(Connection con) {
        this.con = con;
    }
    
    @Override
    public Client logClient(String username,String password){
        Client client = null;
        
        query = "SELECT * FROM client WHERE username=? AND password=?"; //? is for the unknown
        try {
            ps = this.con.prepareStatement(query);
            ps.setString(1,username);
            ps.setString(2,password);
            
            rs = ps.executeQuery();
            if(rs.next()){
                
                client = new Client();
                
                client.setId(rs.getInt("id"));
                client.setUsername(rs.getString("username"));
                client.setEmail(rs.getString("email"));
                client.setPassword(rs.getString("password"));
                client.setNIC(rs.getString("nic"));
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Clientdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return client;
    }
}
