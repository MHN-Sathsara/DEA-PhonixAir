/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEA.PhoniexAirlines.tickets.model;

/**
 *
 * @author Raffael
 */
public class roundtrip extends ticket{
    private String depdate;
    private String returndate;

    public roundtrip(String tid, String type, String usermail, String userfname, String userpassportid, String destination,String tclass, String depdate, String returndate, int atickets, int ctickets, float price) {
        super(tid, type, usermail, userfname, userpassportid, destination, tclass, atickets, ctickets, price);
        this.depdate = depdate;
        this.returndate = returndate;
    }

    public String getDepdate() {
        return depdate;
    }

    public void setDepdate(String depdate) {
        this.depdate = depdate;
    }

    public String getReturndate() {
        return returndate;
    }

    public void setReturndate(String returndate) {
        this.returndate = returndate;
    }
    
    
    
}
