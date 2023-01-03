<%-- 
    Document   : flights
    Created on : Dec 2, 2022, 9:49:08 AM
    Author     : Raffael
--%>
<%@page import="DEA.PhoniexAirlines.Client.model.Client"%>
<%@page import="DEA.PhoniexAirlines.Staff.model.StaffMember"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.Time"%>
<%@page import="java.time.LocalTime"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="DEA.PhoniexAirlines.Admin.model.Admin"%>
<%@page import="java.sql.Connection"%>
<%@page import="DEA.PhoniexAirlines.connection.DBConnection"%>
<% 
    DBConnection db = new DBConnection();
    
    Connection con = db.getCon();
%>
<% 
     
    String user = (String)session.getAttribute("type");
    if(user != null){
        if("admin".equals(user)){
                Admin admin = (Admin) session.getAttribute("loggedAdmin");
                if(admin == null) {
                    response.sendRedirect("/DEAPhoniexAirlines/admin/adminlogin.jsp");
                }
        }else if("sg2".equals(user) || "sg1".equals(user)){
                StaffMember staff = (StaffMember) session.getAttribute("loggedStaff"); 
                if(staff == null) {
                    response.sendRedirect("/DEAPhoniexAirlines/Staff/Staff-Login.html");
                }
        }else{
                Client client = (Client) session.getAttribute("loggedClient"); 
                if(client == null) {
                    response.sendRedirect("/DEAPhoniexAirlines/Client/Login.html");
                }
        }
    }

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flights</title>
       
    </head>
    <body>
        <h1>Arrivals</h1>
        <%
            String query = "SELECT * FROM flightarrival";
            PreparedStatement ps = con.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
            out.print("<table border = '1'>" 
                    +"<tr>" 
                    +"<td></td>"
                    +"<td>Time</td>"
                    +"<td>Date</td>"
                    + "<td>Flight</td>"
                    + "<td>From</td>"
                    + "<td>Airline</td>"
                    + "<td>AirCraft</td>"
                    + "<td>Status</td>"
                    + "<td>Price</td>"
                    +"</tr>");
           

            while(rs.next()){
                
                int id = rs.getInt("fid");
                Time Time = rs.getTime("arrival");
                Date date = rs.getDate("arrival");
                String flight = rs.getString("flight");
                String from = rs.getString("departed_from");
                String airline = rs.getString("airline");
                String aircraft = rs.getString("aircraft");
                String status = rs.getString("status");
                float price = rs.getFloat("price");
                
                
                
                out.print("<tr>"
                        +"<form action='flightactions' method='post'>"
                            + "<td>" + "<input type='hidden' value='"+id+"' name='id' readonly> " + "</td>"
                            + "<td>" + "<input type='text' value='"+Time+"' name='time' readonly> " + "</td>"
                            + "<td>" + "<input type='text' value='"+date+"' name='date' readonly> " + "</td>"
                            + "<td>" + "<input type='text' value='"+flight+"' name='flight' readonly>" + "</td>"
                            + "<td>" + "<input type='text' value='"+from+"' name='from' readonly>" + "</td>"
                            + "<td>" + "<input type='text' value='"+airline+"' name='airline' readonly>" + "</td>"
                            + "<td>" + "<input type='text' value='"+aircraft+"' name='aircraft' readonly>" + "</td>"
                            + "<td>" + "<input type='text' value='"+status+"' name='status' readonly>" + "</td>"
                            + "<td>" + "<input type='number' value='"+price+"' name='price' readonly>" + "</td>"
                            );
                                        
                                   
                if("admin".equals(user) || "sg2".equals(user)){
                    
                    out.print("<td>"
                            + "<input type='submit' value ='Delete' name='button'/>"
                            + "<input type='hidden' value ='arrival' name='formname'/>"
                            + "</td>"
                            + "</form>");
                }else{
                    out.print("</form>");
                }
            }
            
            out.print("</table>"); 
        %>
        
        <h1>Departures</h1>
        
        <%
            String dquery = "SELECT * FROM flightdeparture";
            PreparedStatement dps = con.prepareStatement(dquery);
            
            ResultSet drs = dps.executeQuery();
            
            out.print("<table border = '1'>" 
                    +"<tr>" 
                    +"<td></td>"
                    +"<td>Time</td>"
                    +"<td>Date</td>"
                    + "<td>Flight</td>"
                    + "<td>From</td>"
                    + "<td>Airline</td>"
                    + "<td>AirCraft</td>"
                    + "<td>Status</td>"
                    + "<td>Price</td>"
                    +"</tr>");
           

            while(drs.next()){
                
                int id = drs.getInt("fid");
                Time Time = drs.getTime("time");
                Date date = drs.getDate("time");
                String flight = drs.getString("flight");
                String whereto = drs.getString("where_to");
                String airline = drs.getString("airline");
                String aircraft = drs.getString("aircraft");
                String status = drs.getString("status");
                float price = drs.getFloat("price");
                
                
                out.print("<tr>"
                        +"<form action='flightactions' method='post'>"
                            + "<td>" + "<input type='hidden' value='"+id+"' name='id' readonly> " + "</td>"
                            + "<td>" + "<input type='text' value='"+Time+"' name='time' readonly> " + "</td>"
                            + "<td>" + "<input type='text' value='"+date+"' name='date' readonly> " + "</td>"
                            + "<td>" + "<input type='text' value='"+flight+"' name='flight' readonly>" + "</td>"
                            + "<td>" + "<input type='text' value='"+whereto+"' name='whereto' readonly>" + "</td>"
                            + "<td>" + "<input type='text' value='"+airline+"' name='airline' readonly>" + "</td>"
                            + "<td>" + "<input type='text' value='"+aircraft+"' name='aircraft' readonly>" + "</td>"
                            + "<td>" + "<input type='text' value='"+status+"' name='status' readonly>" + "</td>"
                            + "<td>" + "<input type='number' value='"+price+"' name='price' readonly>" + "</td>"
                            + "<td>" + "<input type='submit' value='Book' name='button'>"
                            + "<input type='hidden' value ='Departure' name='formname'/>");
                
                if("admin".equals(user) || "sg2".equals(user)){
                    
                    out.print("<td>"
                            + "<input type='submit' value ='Delete' name='button'/>"
                            + "</td>"
                            + "</form>");
                }else{
                    out.print("</form>");
                }
            }
            
            out.print("</table>"); 
        %>
        
    </body>
</html>
