package org.apache.jsp.bookings;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import DEA.PhoniexAirlines.Client.model.Client;
import DEA.PhoniexAirlines.Staff.model.StaffMember;
import DEA.PhoniexAirlines.Admin.model.Admin;
import java.sql.Connection;
import DEA.PhoniexAirlines.connection.DBConnection;

public final class bookings_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
 
    DBConnection db = new DBConnection();
    
    Connection con = db.getCon();

      out.write('\n');
 
     
    String user = (String)session.getAttribute("type");
    String usermail;
    if(user != null){
        if("admin".equals(user)){
                Admin admin = (Admin) session.getAttribute("loggedAdmin");
                usermail = admin.getEmail();
                if(admin == null) {
                    response.sendRedirect("/DEAPhoniexAirlines/admin/adminlogin.jsp");
                }
        }else if("sg2".equals(user) || "sg1".equals(user)){
                StaffMember staff = (StaffMember) session.getAttribute("loggedStaff"); 
                usermail = staff.getEmail();
                if(staff == null) {
                    response.sendRedirect("/DEAPhoniexAirlines/Staff/Staff-Login.html");
                }
        }else{
                Client client = (Client) session.getAttribute("loggedClient"); 
                usermail = client.getEmail();
                if(client == null) {
                    response.sendRedirect("/DEAPhoniexAirlines/Client/Login.html");
                }
        }
    


      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>One Way Bookings</h1>\n");
      out.write("        ");


            String oneway ="SELECT * FROM onewaybookings WHERE usermail = ?";

            PreparedStatement ps = con.prepareStatement(oneway);
            
            ps.setString(1, usermail);

            ResultSet owb = ps.executeQuery();


            out.print("<table border = '1'>" 
                            +"<tr>" 
                            +"<td>TicketID</td>"
                            +"<td>Tickettype</td>"
                            +"<td>Fullname</td>"
                            + "<td>Passport</td>"
                            + "<td>Destination</td>"
                            + "<td>Class</td>"
                            + "<td>Departure</td>"
                            + "<td>AdultTickets</td>"
                            + "<td>ChildTickets</td>"
                            + "<td>Price</td>"
                            +"</tr>");

            while(owb.next()){
               String tid = owb.getString("ticketid");
               String ttype = owb.getString("tickettype");
               String userfullname = owb.getString("userfullname");
               String passportid = owb.getString("passportid");
               String destination = owb.getString("destination");
               String ticketclass = owb.getString("ticketclass");
               String depdate = owb.getString("depdate");
               int adult = owb.getInt("adult");
               int child = owb.getInt("child");
               float price = owb.getFloat("price");

               out.print("<tr>"
                                +"<form action='flightactions' method='post'>"
                                    + "<td>" + "<input type='hidden' value='"+tid+"' name='id' readonly> " + "</td>"
                                    + "<td>" + "<input type='text' value='"+ttype+"' name='ttype' readonly> " + "</td>"
                                    + "<td>" + "<input type='text' value='"+userfullname+"' name='duserfullname' readonly> " + "</td>"
                                    + "<td>" + "<input type='text' value='"+usermail+"' name='email' readonly>" + "</td>"
                                    + "<td>" + "<input type='text' value='"+passportid+"' name='passportid' readonly>" + "</td>"
                                    + "<td>" + "<input type='text' value='"+destination+"' name='destination' readonly>" + "</td>"
                                    + "<td>" + "<input type='text' value='"+ticketclass+"' name='ticketclass' readonly>" + "</td>"
                                    + "<td>" + "<input type='text' value='"+depdate+"' name='depdate' readonly>" + "</td>"
                                    + "<td>" + "<input type='text' value='"+adult+"' name='adult' readonly>" + "</td>"
                                    + "<td>" + "<input type='number' value='"+child+"' name='child' readonly>" + "</td>"
                                    + "<td>" + "<input type='number' value='"+price+"' name='price' readonly>" + "</td>"
                                    );

                        if("admin".equals(user) || "sg2".equals(user)){

                            out.print("<td>"
                                    + "<input type='submit' value ='Delete' name='button'/>"
                                    + "</td>"
                                    + "</form>");
                        }else{
                            out.print("</form>");
                        }

                }

                out.print("</table>"); 

        
      out.write("\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <h1>RoundTrip</h1>\n");
      out.write("        ");


            String roundtrip ="SELECT * FROM roundtripbookings WHERE usermail = ?";
    
            PreparedStatement rps = con.prepareStatement(roundtrip);
            
            rps.setString(1, usermail);
    
            ResultSet rtb = rps.executeQuery();


            out.print("<table border = '1'>" 
                            +"<tr>" 
                            +"<td>TicketID</td>"
                            +"<td>Tickettype</td>"
                            +"<td>Fullname</td>"
                            + "<td>Passport</td>"
                            + "<td>Destination</td>"
                            + "<td>Class</td>"
                            + "<td>Departure</td>"
                            + "<td>AdultTickets</td>"
                            + "<td>ChildTickets</td>"
                            + "<td>Price</td>"
                            +"</tr>");

            while(rtb.next()){
                
            
                String tid = rtb.getString("ticketid");
                String ttype = rtb.getString("tickettype");
                String userfullname = rtb.getString("userfullname");
                String passportid = rtb.getString("passportid");
                String destination = rtb.getString("destination");
                String ticketclass = rtb.getString("ticketclass");
                String depdate = rtb.getString("depdate");
                String rdate = rtb.getString("rdate");
                int adult = rtb.getInt("adult");
                int child = rtb.getInt("child");
                float price = rtb.getFloat("price");

               out.print("<tr>"
                                +"<form action='flightactions' method='post'>"
                                    + "<td>" + "<input type='hidden' value='"+tid+"' name='id' readonly> " + "</td>"
                                    + "<td>" + "<input type='text' value='"+ttype+"' name='ttype' readonly> " + "</td>"
                                    + "<td>" + "<input type='text' value='"+userfullname+"' name='duserfullname' readonly> " + "</td>"
                                    + "<td>" + "<input type='text' value='"+usermail+"' name='email' readonly>" + "</td>"
                                    + "<td>" + "<input type='text' value='"+passportid+"' name='passportid' readonly>" + "</td>"
                                    + "<td>" + "<input type='text' value='"+destination+"' name='destination' readonly>" + "</td>"
                                    + "<td>" + "<input type='text' value='"+ticketclass+"' name='ticketclass' readonly>" + "</td>"
                                    + "<td>" + "<input type='text' value='"+depdate+"' name='depdate' readonly>" + "</td>"
                                    + "<td>" + "<input type='text' value='"+rdate+"' name='rdate' readonly>" + "</td>"
                                    + "<td>" + "<input type='text' value='"+adult+"' name='adult' readonly>" + "</td>"
                                    + "<td>" + "<input type='number' value='"+child+"' name='child' readonly>" + "</td>"
                                    + "<td>" + "<input type='number' value='"+price+"' name='price' readonly>" + "</td>"
                                    );

                        if("admin".equals(user) || "sg2".equals(user)){

                            out.print("<td>"
                                    + "<input type='submit' value ='Delete' name='button'/>"
                                    + "</td>"
                                    + "</form>");
                        }else{
                            out.print("</form>");
                        }

                }

                out.print("</table>"); 

        
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
