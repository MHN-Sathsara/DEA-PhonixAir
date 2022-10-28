<%-- 
    Document   : staffmod
    Created on : Oct 28, 2022, 5:12:28 PM
    Author     : Raffael
--%>
<%@page import="DEA.PhoniexAirlines.Admin.model.Admin"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
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
        <title>Update Profile</title>
        <link rel="stylesheet" href="./css/SR.css">
        <link rel="stylesheet" href="./css/bootstrap.min.css">

    </head>
    <body>
        <h1>Update Profile</h1>
        <div class="pag">
          <!--for-->
          <div class="photocardleft">
            <img src="./img/Left Side-min (1).jpg"
              alt="Sample photo" class="img-fluid" />
          </div>



        </div>


        <div class="cardreg">
          <section class="h-100 ">
              <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                  <div class="col">

                      <div class="row g-0">

                        <div class="col-xl-6" >
                          <div class="card-body p-md-5 text-black">
                            <div class="logoo">
                              <img src="./img/Phoenix Airline PVT_free-file 1-min (1).png" alt="logo" style="width: 156px;
                              height: 74.88px; margin-left: 196px;">
                            </div>
                            <h3 class="mb-5 text-uppercase" style="margin-top: 69px;">Update Profile</h3>
                            <form action="update" method="post">
                              <div class="formeka">

                              <div class="form-outline mb-4">
                                  <%
                                      Object oid = request.getAttribute("id");
                                      String sid = oid.toString();
                                      int id = Integer.valueOf(sid);
                                      out.print("<input type='hidden' id='form3Example8' name='staffid' class='form-control form-control-lg' value='"+id+"'/>");
                                  %>
                              </div>

                              <div class="form-outline mb-4">
                                <%
                                    String name = (String)request.getAttribute("username");
                                    out.print("<input type='text' id='form3Example8' name='username' class='form-control form-control-lg' value='"+name+"'/>");
                                %>
                                <label class="form-label" for="form3Example8">Name</label>
                              </div>

                              <div class="form-outline mb-4">
                                <%
                                      String email = (String)request.getAttribute("email");
                                      out.print("<input type='text' id='form3Example8' name='email' class='form-control form-control-lg' value='"+email+"'/>");
                                %>
                                <label class="form-label" for="form3Example9">Email</label>
                              </div>

                              <div class="form-outline mb-4">
                                <%
                                      String grade = (String)request.getAttribute("grade");
                                      out.print("<input type='text' id='form3Example8' name='grade' class='form-control form-control-lg' value='"+grade+"'/>");
                                %>
                                <label class="form-label" for="form3Example90">Grade</label>
                              </div>

                              <div class="d-grid gap-2 col-6 mx-auto btn-lg">
                                <button class="btn btn-primary" type="submit">Update</button>

                              </div>

                              </div>
                             <form>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </section>
              </div>

    <script src="./js/bootstrap.bundle.min.js"></script>
    <script src="./js/jqeuery.min.js"></script>

    </body>
</html>
