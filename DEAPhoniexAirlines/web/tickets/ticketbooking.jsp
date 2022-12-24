<%-- 
    Document   : ticketbooking
    Created on : Dec 19, 2022, 3:26:18 PM
    Author     : Raffael
--%>
<%@page import="java.sql.Time"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.text.DateFormat"%>
<%@page import="DEA.PhoniexAirlines.Client.model.Client"%>
<%@page import="DEA.PhoniexAirlines.Staff.model.StaffMember"%>
<%@page import="DEA.PhoniexAirlines.Admin.model.Admin"%>
<%@page import="java.sql.Connection"%>
<%@page import="DEA.PhoniexAirlines.connection.DBConnection"%>
<%@page import="java.util.Date"%>
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
<%
        String query = "SELECT * FROM flightdeparture WHERE fid = ?";
        
        String id = (String)request.getAttribute("id");
            
        PreparedStatement ps = con.prepareStatement(query);
        
        ps.setString(1, id);
            
        ResultSet rs = ps.executeQuery();
        
        
    while(rs.next()){        
        String destination = rs.getString("where_to");
        Date date = rs.getDate("time");
        Time time = rs.getTime("time");
        float price = rs.getFloat("price"); 
        
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>TicketBooking</h1>
        <form action="ticketbooking" method="post">
            <table>
                <tr>
                    <td>
                        <select name="ttype" id="ttype" onclick="onewaydisable();">
                            <option value="oneway">One-Way</option>
                            <option value="round">Round-Trip</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Full Name :</td>
                    <td>
                        <input type="text" name="fullname"/>
                    </td>
                </tr>
                <tr>
                    <td>Passport Id :</td>
                    <td>
                        <input type="text" name="pid"/>
                    </td>
                </tr>
                <tr>
                    <td>Email :</td>
                    <td>
                        <%
                            out.print("<input type='text' name='email' value='" + usermail + "'/>");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Destination :</td>
                    <td>
                        <%
                            out.print("<input type='text' name='destination' value='" + destination + "'/>");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Departure Date :</td>
                    <td>
                        <%
                            out.print("<input type='text' name='ddate' value='" + date +"'/>");
                        %>
                    </td>
                </tr>
                <tr>
                    <td>Return Date :</td>
                    <td>
                        <input type="datetime-local" name="rdate" id="returndate"/>
                    </td>
                </tr>
                <tr>
                    <td>Class :</td>
                    <td>
                        <select name="tclass">
                            <option value="eco">Economy</option>
                            <option value="business">Business</option>
                            <option value="first">First</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Adult</td>
                    <td>
                        <input type="number" name="adult"/>
                    </td>
                    <td>Child</td>
                    <td>
                        <input type="number" name="child"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Price :
                    </td>
                    <td>
                        <%
                            out.print("<input type='number' name='price' value='" + price + "' readonly/>");
                            }
                            }
                        %>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Book"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
    <script>
        var ticketType = document.getElementById("ttype");
            
            if(ticketType.value === "oneway") {

                   console.log(ticketType.value);
                   document.getElementById("returndate").disabled = true;

            }
               
        function onewaydisable(){
        
            if(ticketType.value === "oneway") {

               console.log(ticketType.value);
               document.getElementById("returndate").disabled = true;

            }

            if(ticketType.value === "round"){

               console.log(ticketType.value);
               document.getElementById("returndate").disabled = false;

            }
        }
    </script>
</html>
