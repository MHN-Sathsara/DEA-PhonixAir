/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEA.PhoniexAirlines.Flight.model;

/**
 *
 * @author Raffael
 */
public class flight {
    private int id;
    private int time;
    private String flight;
    private String from;
    private String airline;
    private String aircraft;
    private String status;

    public flight(int time, String flight, String from, String airline, String aircraft, String status) {
        this.time = time;
        this.flight = flight;
        this.from = from;
        this.airline = airline;
        this.aircraft = aircraft;
        this.status = status;
    }

    public flight(int id) {
        this.id = id;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
