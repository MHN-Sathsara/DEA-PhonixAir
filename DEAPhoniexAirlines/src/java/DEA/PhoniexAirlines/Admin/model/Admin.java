/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEA.PhoniexAirlines.Admin.model;

/**
 *
 * @author Raffael
 */
public class Admin extends Person{
   private int id;
   private String email;
   private String password;

    public Admin() {
    }

    public Admin(String username) {
        super(username);
    }

    public Admin(int id, String email, String password, String username) {
        super(username);
        this.id = id;
        this.email = email;
        this.password = password;
    }
    
    public Admin(String email, String password, String username) {
        super(username);
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
   
    
    
    
}
