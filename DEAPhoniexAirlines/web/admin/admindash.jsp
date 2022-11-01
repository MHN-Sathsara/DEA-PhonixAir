<%-- 
    Document   : admindash
    Created on : Oct 5, 2022, 7:40:05 AM
    Author     : Raffael
--%>

<%@page import="DEA.PhoniexAirlines.Admin.model.Admin"%>
<%@page import="DEA.PhoniexAirlines.connection.DBConnection"%>
<% 
    DBConnection db = new DBConnection();
    
%>
<% 
    Admin admin = (Admin) session.getAttribute("loggedAdmin"); 
    if(admin == null) {
        response.sendRedirect("adminlogin.jsp");
    }

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Dashboard</title>
    </head>
    <body>
        <h1>Hello <%= admin.getEmail() %> </h1>
        <form action="adminlogout" method="post">
            <button type="submit">Log Out</a></button>
        </form>
        <a href="staffrequests.jsp">New Requests</a><br>
        <a href="staff.jsp">Staff</a><br>
        <a href="blockedstaff.jsp">Blocked Staff</a><br>
        <a href="clients.jsp">Customers</a><br>
        <a href="blockedclients.jsp">Blocked Customers</a><br>
        
    </body>
</html>
