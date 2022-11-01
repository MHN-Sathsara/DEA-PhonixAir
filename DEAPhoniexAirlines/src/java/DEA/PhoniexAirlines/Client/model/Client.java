/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEA.PhoniexAirlines.Client.model;

import DEA.PhoniexAirlines.Admin.model.Person;

/**
 *
 * @author Raffael
 */
public class Client extends Person{
   private int id;
   private String email;
   private String password;
   private String NIC;

    public Client() {
    }

    public Client(String username) {
        super(username);
    }

    public Client(int id, String email, String username) {
        super(username);
        this.id = id;
        this.email = email;
    }

    public Client(int id, String email, String password, String NIC, String username) {
        super(username);
        this.id = id;
        this.email = email;
        this.password = password;
        this.NIC = NIC;
    }

    public Client(int id, String email, String password, String NIC) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.NIC = NIC;
    }

    public Client(String email, String password, String NIC, String username) {
        super(username);
        this.email = email;
        this.password = password;
        this.NIC = NIC;
    }

    
    public Client(String email, String password, String NIC) {
        this.email = email;
        this.password = password;
        this.NIC = NIC;
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

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }
   
    
}
