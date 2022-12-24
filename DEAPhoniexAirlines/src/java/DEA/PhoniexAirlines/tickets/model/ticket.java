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
public class ticket {
    
   private String tid; 
   private String type;
   private String usermail;
   private String userfname;
   private String userpassportid;
   private String destination;
   private String tclass;
   private int atickets;
   private int ctickets;
   private float price;

    public ticket(String tid, String type, String usermail, String userfname, String userpassportid, String destination, String tclass, int atickets, int ctickets, float price) {
        this.tid = tid;
        this.type = type;
        this.usermail = usermail;
        this.userfname = userfname;
        this.userpassportid = userpassportid;
        this.destination = destination;
        this.tclass = tclass;
        this.atickets = atickets;
        this.ctickets = ctickets;
        this.price = price;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTclass() {
        return tclass;
    }

    public void setTclass(String tclass) {
        this.tclass = tclass;
    }

    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsermail() {
        return usermail;
    }

    public void setUsermail(String usermail) {
        this.usermail = usermail;
    }

    public String getUserfname() {
        return userfname;
    }

    public void setUserfname(String userfname) {
        this.userfname = userfname;
    }

    public String getUserpassportid() {
        return userpassportid;
    }

    public void setUserpassportid(String userpassportid) {
        this.userpassportid = userpassportid;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getAtickets() {
        return atickets;
    }

    public void setAtickets(int atickets) {
        this.atickets = atickets;
    }

    public int getCtickets() {
        return ctickets;
    }

    public void setCtickets(int ctickets) {
        this.ctickets = ctickets;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
   
   
}
