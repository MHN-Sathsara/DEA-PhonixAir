<%-- 
    Document   : ClientDash
    Created on : Oct 5, 2022, 4:23:17 PM
    Author     : Raffael
--%>
<%@page import="DEA.PhoniexAirlines.Client.model.Client"%>
<%@page import="DEA.PhoniexAirlines.connection.DBConnection"%>
<% 
    DBConnection db = new DBConnection();
%>
<% 
    Client client = (Client) session.getAttribute("loggedClient"); 
    if(client == null) {
        response.sendRedirect("Login.html");
    }

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Client Dashboard</title>
    </head>
    <body>
        <h1>Hello <%= client.getEmail() %> </h1>
        <form action="clientlogout" method="post">
            <button type="submit">Log Out</a></button>
        </form>
    </body>
</html>
