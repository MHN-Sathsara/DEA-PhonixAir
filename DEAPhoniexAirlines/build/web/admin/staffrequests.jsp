<%-- 
    Document   : staffreqests
    Created on : Oct 10, 2022, 2:26:35 PM
    Author     : Raffael
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="DEA.PhoniexAirlines.Admin.model.Admin"%>
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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Requests</h1>
        
        <%
            String query = "SELECT * FROM staffrequest";
            PreparedStatement ps = con.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
            out.print("<table border = '1'>" 
                    +"<tr>" 
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
                        +"<form action='requests' method='post'>"
                            + "<td>" + "<input type='text' value='"+username+"' name='username' readonly> " + "</td>"
                            + "<td>" + "<input type='text' value='"+email+"' name='email' readonly>" + "</td>"
                            + "<td>" + "<input type='text' value='"+grade+"' name='grade' readonly>" + "</td>"
                            + "<td>" + "<input type='password' value='"+password+"' name='password' readonly>" + "</td>"
                            + "<td>" 
                                        
                                    + "<input type='submit' value ='Allow' name='button'/>"
                                    + "<input type='submit' value ='Deny' name='button'/>"
                        +"</form>"
                        +"</tr>");
            }
            
            out.print("</table>");
        
        
        
        %>
        
    </body>
</html>
