/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEA.PhoniexAirlines.Staff.model;

import DEA.PhoniexAirlines.Admin.model.Person;

/**
 *
 * @author Raffael
 */
public class StaffMember extends Person{
   private int id;
   private String email;
   private String password;
   private String grade;

   public StaffMember() {}

    public StaffMember(String username) {
        super(username);
    }

    public StaffMember(int id, String email, String password, String grade, String username) {
        super(username);
        this.id = id;
        this.email = email;
        this.password = password;
        this.grade = grade;
    }

    public StaffMember(String email, String password, String grade, String username) {
        super(username);
        this.email = email;
        this.password = password;
        this.grade = grade;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
   
   
   
   
}
