<%-- 
    Document   : blockedstaff
    Created on : Nov 1, 2022, 12:21:26 PM
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
        <title>Blocked Staff</title>
    </head>
    <body>
        <h1>Blocked Staff</h1>
        <%
            String query = "SELECT * FROM blockedstaff";
            PreparedStatement ps = con.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
            out.print("<table border = '1'>" 
                    +"<tr>" 
                    +"<td></td>"
                    +"<td>Username</td>"
                    + "<td>Email</td>"
                    + "<td>Grade</td>"
                    + "<td>Password</td>"
                    +"</tr>");
           

            while(rs.next()){
                
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String grade = rs.getString("grade");
                String password = rs.getString("password");
                
                
                out.print("<tr>"
                        +"<form action='staffmod' method='post'>"
                            + "<td>" + "<input type='hidden' value='"+id+"' name='id' readonly> " + "</td>"
                            + "<td>" + "<input type='text' value='"+username+"' name='username' readonly> " + "</td>"
                            + "<td>" + "<input type='text' value='"+email+"' name='email' readonly>" + "</td>"
                            + "<td>" + "<input type='text' value='"+grade+"' name='grade' readonly>" + "</td>"
                            + "<td>" + "<input type='password' value='"+password+"' name='password' readonly>" + "</td>"
                            + "<td>" 
                                        
                                    + "<input type='submit' value ='Unblock' name='button'/>"
                                    + "<input type='submit' value ='Edit' name='button'/>"
                        +"</form>"
                        +"</tr>");
            }
            
            out.print("</table>"); 
        %>
    </body>
</html>
