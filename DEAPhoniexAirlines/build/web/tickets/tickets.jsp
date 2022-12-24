<%-- 
    Document   : tickets
    Created on : Dec 14, 2022, 6:01:04 PM
    Author     : Raffael
--%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tickets</h1>
        <%
            String query = "SELECT * FROM tickets";
            PreparedStatement ps = con.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
            out.print("<table border = '1'>" 
                    +"<tr>"
                    + "<td>TicketID</td>"
                    + "<td>Flight</td>"
                    + "<td>Class</td>"
                    + "<td>To</td>"
                    + "<td>Price</td>"
                    +"</tr>");
           

            while(rs.next()){
                
                int id = rs.getInt("TicketID");
                String flight = rs.getString("flight");
                String tclass = rs.getString("class");
                String where = rs.getString("where_to");
                double price = rs.getDouble("price");
                
                
                
                
                out.print("<tr>"
                        +"<form action='flightdelete' method='post'>"
                            + "<td>" + "<input type='text' value='"+id+"' name='id' readonly> " + "</td>"
                            + "<td>" + "<input type='text' value='"+flight+"' name='flight' readonly>" + "</td>"
                            + "<td>" + "<input type='text' value='"+tclass+"' name='from' readonly>" + "</td>"
                            + "<td>" + "<input type='text' value='"+where+"' name='airline' readonly>" + "</td>"
                            + "<td>" + "<input type='text' value='"+price+"' name='aircraft' readonly>" + "</td>");
                                        
                                   
                if("admin".equals(user)){
                    
                    out.print("<td>"
                            + "<input type='submit' value ='Delete' name='button'/>"
                            + "</form>");
                }else {
                    out.print("</form>");
                }
            }
            
            out.print("</table>"); 
        %>
    </body>
</html>
