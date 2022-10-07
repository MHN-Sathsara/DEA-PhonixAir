/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEA.PhoniexAirlines.ClientRegistration;

/**
 *
 * @author Raffael
 */
public class RegisteredUser {
     int id;
     String username;
     String email;
     String nic;
     String password;

    public RegisteredUser() {
    }

    public RegisteredUser(int id, String username, String email, String nic, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.nic = nic;
        this.password = password;
    }

    public RegisteredUser(String username, String email, String nic, String password) {
        this.username = username;
        this.email = email;
        this.nic = nic;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     
     
}
