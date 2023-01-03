<%-- 
    Document   : bookings
    Created on : Jan 3, 2023, 3:43:52 PM
    Author     : Raffael
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="DEA.PhoniexAirlines.Client.model.Client"%>
<%@page import="DEA.PhoniexAirlines.Staff.model.StaffMember"%>
<%@page import="DEA.PhoniexAirlines.Admin.model.Admin"%>
<%@page import="java.sql.Connection"%>
<%@page import="DEA.PhoniexAirlines.connection.DBConnection"%>
<% 
    DBConnection db = new DBConnection();
    
    Connection con = db.getCon();
%>
<% 
     
    String user = (String)session.getAttribute("type");
    String usermail;
    if(user != null){
        if("admin".equals(user)){
                Admin admin = (Admin) session.getAttribute("loggedAdmin");
                usermail = admin.getEmail();
                if(admin == null) {
                    response.sendRedirect("/DEAPhoniexAirlines/admin/adminlogin.jsp");
                }
        }else if("sg2".equals(user) || "sg1".equals(user)){
                StaffMember staff = (StaffMember) session.getAttribute("loggedStaff"); 
                usermail = staff.getEmail();
                if(staff == null) {
                    response.sendRedirect("/DEAPhoniexAirlines/Staff/Staff-Login.html");
                }
        }else{
                Client client = (Client) session.getAttribute("loggedClient"); 
                usermail = client.getEmail();
                if(client == null) {
                    response.sendRedirect("/DEAPhoniexAirlines/Client/Login.html");
                }
        }
        
    

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>One Way Bookings</h1>
        <%

            String oneway ="SELECT * FROM onewaybookings WHERE usermail = ?";

            PreparedStatement ps = con.prepareStatement(oneway);
            
            ps.setString(1, usermail);

            ResultSet owb = ps.executeQuery();


            out.print("<table border = '1'>" 
                            +"<tr>" 
                            +"<td>TicketID</td>"
                            +"<td>Tickettype</td>"
                            +"<td>Fullname</td>"
                            + "<td>Email</td>"
                            + "<td>Passport</td>"
                            + "<td>Destination</td>"
                            + "<td>Class</td>"
                            + "<td>Departure</td>"
                            + "<td>AdultTickets</td>"
                            + "<td>ChildTickets</td>"
                            + "<td>Price</td>"
                            +"</tr>");

            while(owb.next()){
               String tid = owb.getString("ticketid");
               String ttype = owb.getString("tickettype");
               String userfullname = owb.getString("userfullname");
               String passportid = owb.getString("passportid");
               String destination = owb.getString("destination");
               String ticketclass = owb.getString("ticketclass");
               String depdate = owb.getString("depdate");
               int adult = owb.getInt("adult");
               int child = owb.getInt("child");
               float price = owb.getFloat("price");

               out.print("<tr>"
                                +"<form action='flightactions' method='post'>"
                                    + "<td>" + "<input type='text' value='"+tid+"' name='id' readonly> " + "</td>"
                                    + "<td>" + "<input type='text' value='"+ttype+"' name='ttype' readonly> " + "</td>"
                                    + "<td>" + "<input type='text' value='"+userfullname+"' name='duserfullname' readonly> " + "</td>"
                                    + "<td>" + "<input type='text' value='"+usermail+"' name='email' readonly>" + "</td>"
                                    + "<td>" + "<input type='text' value='"+passportid+"' name='passportid' readonly>" + "</td>"
                                    + "<td>" + "<input type='text' value='"+destination+"' name='destination' readonly>" + "</td>"
                                    + "<td>" + "<input type='text' value='"+ticketclass+"' name='ticketclass' readonly>" + "</td>"
                                    + "<td>" + "<input type='text' value='"+depdate+"' name='depdate' readonly>" + "</td>"
                                    + "<td>" + "<input type='text' value='"+adult+"' name='adult' readonly>" + "</td>"
                                    + "<td>" + "<input type='number' value='"+child+"' name='child' readonly>" + "</td>"
                                    + "<td>" + "<input type='number' value='"+price+"' name='price' readonly>" + "</td>"
                                    );


                }

                out.print("</form>"
                        + "</table>"); 

        %>
        <br>
        <br>
        <h1>RoundTrip</h1>
        <%

            String roundtrip ="SELECT * FROM roundtripbookings WHERE usermail = ?";
    
            PreparedStatement rps = con.prepareStatement(roundtrip);
            
            rps.setString(1, usermail);
    
            ResultSet rtb = rps.executeQuery();


            out.print("<table border = '1'>" 
                            +"<tr>" 
                            +"<td>TicketID</td>"
                            +"<td>Tickettype</td>"
                            +"<td>Fullname</td>"
                            + "<td>Email</td>"
                            + "<td>Passport</td>"
                            + "<td>Destination</td>"
                            + "<td>Class</td>"
                            + "<td>Departure</td>"
                            + "<td>Return</td>"
                            + "<td>AdultTickets</td>"
                            + "<td>ChildTickets</td>"
                            + "<td>Price</td>"
                            +"</tr>");

            while(rtb.next()){
                
            
                String tid = rtb.getString("ticketid");
                String ttype = rtb.getString("tickettype");
                String userfullname = rtb.getString("userfullname");
                String passportid = rtb.getString("passportid");
                String destination = rtb.getString("destination");
                String ticketclass = rtb.getString("ticketclass");
                String depdate = rtb.getString("depdate");
                String rdate = rtb.getString("rdate");
                int adult = rtb.getInt("adult");
                int child = rtb.getInt("child");
                float price = rtb.getFloat("price");

               out.print("<tr>"
                                +"<form>"
                                    + "<td>" + "<input type='text' value='"+tid+"' name='id' readonly> " + "</td>"
                                    + "<td>" + "<input type='text' value='"+ttype+"' name='ttype' readonly> " + "</td>"
                                    + "<td>" + "<input type='text' value='"+userfullname+"' name='duserfullname' readonly> " + "</td>"
                                    + "<td>" + "<input type='text' value='"+usermail+"' name='email' readonly>" + "</td>"
                                    + "<td>" + "<input type='text' value='"+passportid+"' name='passportid' readonly>" + "</td>"
                                    + "<td>" + "<input type='text' value='"+destination+"' name='destination' readonly>" + "</td>"
                                    + "<td>" + "<input type='text' value='"+ticketclass+"' name='ticketclass' readonly>" + "</td>"
                                    + "<td>" + "<input type='text' value='"+depdate+"' name='depdate' readonly>" + "</td>"
                                    + "<td>" + "<input type='text' value='"+rdate+"' name='rdate' readonly>" + "</td>"
                                    + "<td>" + "<input type='text' value='"+adult+"' name='adult' readonly>" + "</td>"
                                    + "<td>" + "<input type='number' value='"+child+"' name='child' readonly>" + "</td>"
                                    + "<td>" + "<input type='number' value='"+price+"' name='price' readonly>" + "</td>");
                                    

            }
            
            out.print("</form>"
                      + "</table>");           
          }

        %>
    </body>
</html>
