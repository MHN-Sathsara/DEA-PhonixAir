<%-- 
    Document   : clients
    Created on : Nov 1, 2022, 1:58:48 PM
    Author     : Raffael
--%>
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
        <title>Clients</title>
    </head>
    <body>
        <h1>Customers</h1>
                <%
            String query = "SELECT * FROM client";
            PreparedStatement ps = con.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
            out.print("<table border = '1'>" 
                    +"<tr>" 
                    +"<td></td>"
                    +"<td>Username</td>"
                    + "<td>Email</td>"
                    + "<td>NIC</td>"
                    + "<td>Password</td>"
                    +"</tr>");
           

            while(rs.next()){
                
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String NIC = rs.getString("nic");
                String password = rs.getString("password");
                
                
                out.print("<tr>"
                        +"<form action='clientmod' method='post'>"
                            + "<td>" + "<input type='hidden' value='"+id+"' name='id' readonly> " + "</td>"
                            + "<td>" + "<input type='text' value='"+username+"' name='username' readonly> " + "</td>"
                            + "<td>" + "<input type='text' value='"+email+"' name='email' readonly>" + "</td>"
                            + "<td>" + "<input type='text' value='"+NIC+"' name='nic' readonly>" + "</td>"
                            + "<td>" + "<input type='password' value='"+password+"' name='password' readonly>" + "</td>"
                            + "<td>" 
                                        
                                    + "<input type='submit' value ='Block' name='button'/>"
                                    + "<input type='submit' value ='Edit' name='button'/>"
                        +"</form>"
                        +"</tr>");
            }
            
            out.print("</table>"); 
        %>
    </body>
    </body>
</html>
