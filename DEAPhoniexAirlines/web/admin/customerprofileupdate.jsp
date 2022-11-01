<%-- 
    Document   : customerprofileupdate
    Created on : Nov 1, 2022, 6:07:17 PM
    Author     : Raffael
--%>
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
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Profile</title>
    <link rel="stylesheet" href="./Client/CSS/CR.css">
    <link rel="stylesheet" href="./css/bootstrap.min.css">
</head>
<body>


  <div class="wrapper">
    <div class="inner">
      <div class="img-holder">
        <img src="./Img/Left Side-min.jpg" alt="Image">
      </div>
      <form action="clientupdate" method="post">
        <div class="logoo">
          <img src="./Img/Phoenix Airline PVT_free-file 1-min (1).png">
        </div>
        <h3>Update Profile</h3>
        <%
           
            Object oid = request.getAttribute("id");
            String cid = oid.toString();
            int id = Integer.valueOf(cid);
            out.print("<input type='hidden' id='form3Example8' name='clientid' class='form-control form-control-lg' value='"+id+"'/>");
                                 
        %>
        <div class="form-group">
        <%
            String name = (String)request.getAttribute("username");
            out.print("<input type='text' id='form3Example8' name='username' class='form-control form-control-lg' value='"+name+"'/>");
        %>
        </div>
        <div class="form-wrapper">
        <%
            String email = (String)request.getAttribute("email");
            out.print("<input type='text' id='form3Example8' name='email' class='form-control form-control-lg' value='"+email+"'/>");
        %>          
        </div>
        
        <button type="submit">Update</button>
      </form>
    </div>
  </div>


  
    <script src="./Js/bootstrap.bundle.min.js"></script>
    <script src="./Js/jqeuery.min.js"></script>
</body>
</html>
