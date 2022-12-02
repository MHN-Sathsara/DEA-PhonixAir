<%-- 
    Document   : addnewflight
    Created on : Dec 2, 2022, 2:10:26 PM
    Author     : Raffael
--%>
<%@page import="DEA.PhoniexAirlines.Staff.model.StaffMember"%>
<%@page import="DEA.PhoniexAirlines.Admin.model.Admin"%>
<% 
    String user = (String) session.getAttribute("type");
    if(user == null){
        
        response.sendRedirect("/DEAPhoniexAirlines/index.html");
        
    }else if("admin".equals(user)){
        Admin admin = (Admin) session.getAttribute("loggedAdmin"); 
        if(admin == null) {
            response.sendRedirect("adminlogin.jsp");
        }
    }else{
        StaffMember staff = (StaffMember) session.getAttribute("loggedStaff"); 
        if(staff == null) {
            response.sendRedirect("Staff-Login.html");
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
        <h1>Add Flight</h1>
        <form action ="addflight" method="post">
            <table>
                <tr>
                    <td>
                        Arrival/Departure Time :
                    </td>
                    <td>
                        <input type="datetime-local" name="time"/>
                    </td>
                    <td>
                        <select name="ftype">
                            <option value="arrival">Arrival</option>
                            <option value="departure">Departure</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        Flight :
                    </td>
                    <td>
                        <input type="text" name="flight"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Destination :
                    </td>
                    <td>
                        <input type="text" name="loc"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Airline :
                    </td>
                    <td>
                        <input type="text" name="airlines"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Aircraft :
                    </td>
                    <td>
                        <input type="text" name="aircraft"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Status :
                    </td>
                    <td>
                        <select name="status">
                            <option value="arrived">Arrived</option>
                            <option value="departured">Departured</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Add Flight"/>
                    </td> 
                </tr>
            </table>
        </form>
    </body>
</html>
