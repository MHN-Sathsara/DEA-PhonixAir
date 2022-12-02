<%-- 
    Document   : staffdashG2
    Created on : Oct 5, 2022, 1:44:11 PM
    Author     : Raffael
--%>
<%@page import="DEA.PhoniexAirlines.Staff.model.StaffMember"%>
<%@page import="DEA.PhoniexAirlines.connection.DBConnection"%>
<% 
    DBConnection db = new DBConnection();
%>
<% 
    StaffMember staff = (StaffMember) session.getAttribute("loggedStaff"); 
    if(staff == null) {
        response.sendRedirect("Staff-Login.html");
    }

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>StaffG2 Dashboaed></title>
    </head>
    <body>
        <h1>Hello <%= staff.getEmail() %> </h1>
        <form action="stafflogout" method="post">
            <button type="submit">Log Out</a></button>
        </form>
        <a href="/DEAPhoniexAirlines/flights/flights.jsp">Flights</a>
        <a href="/DEAPhoniexAirlines/flights/addnewflight.jsp">Add New Flight</a>
    </body>
</html>
