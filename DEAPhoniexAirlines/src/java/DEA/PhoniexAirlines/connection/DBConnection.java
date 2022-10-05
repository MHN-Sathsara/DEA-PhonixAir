/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEA.PhoniexAirlines.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Raffael
 */
public class DBConnection {
    public static Connection getCon() throws SQLException, ClassNotFoundException{
        
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/phoniex_airlines";
            return DriverManager.getConnection(url, "root", "");
    }
}
