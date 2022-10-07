/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEA.PhoniexAirlines.ClientRegistration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raffael
 */
public class DBC {
    private static Connection con;
    
    public static Connection getCon(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phoniex_airlines","root","");
                
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
