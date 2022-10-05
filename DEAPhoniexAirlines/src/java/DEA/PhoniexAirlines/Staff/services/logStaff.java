/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEA.PhoniexAirlines.Staff.services;

import DEA.PhoniexAirlines.Staff.model.StaffMember;



/**
 *
 * @author Raffael
 */
public interface logStaff {
    public StaffMember logStaff(String username,String password, String grade);
}
