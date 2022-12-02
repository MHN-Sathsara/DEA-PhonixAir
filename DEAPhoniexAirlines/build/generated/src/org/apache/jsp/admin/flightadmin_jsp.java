package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import DEA.PhoniexAirlines.Admin.model.Admin;
import java.sql.Connection;
import DEA.PhoniexAirlines.connection.DBConnection;

public final class flightadmin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
 
    DBConnection db = new DBConnection();
    
    Connection con = db.getCon();

      out.write('\n');
 
     
    String user = (String)session.getAttribute("type");
    if("admin".equals(user)){
        Admin admin = (Admin) session.getAttribute("loggedAdmin");
        if(admin == null) {
            response.sendRedirect("adminlogin.jsp");
        }
    }


      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Flights</title>\n");
      out.write("       \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Arrivals</h1>\n");
      out.write("        ");

            String query = "SELECT * FROM flightarrival";
            PreparedStatement ps = con.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
            out.print("<table border = '1'>" 
                    +"<tr>" 
                    +"<td></td>"
                    +"<td>Time</td>"
                    +"<td>Date</td>"
                    + "<td>Flight</td>"
                    + "<td>From</td>"
                    + "<td>Airline</td>"
                    + "<td>AirCraft</td>"
                    + "<td>Status</td>"
                    +"</tr>");
           

            while(rs.next()){
                
                int id = rs.getInt("fid");
                Time Time = rs.getTime("arrival");
                Date date = rs.getDate("arrival");
                String flight = rs.getString("flight");
                String from = rs.getString("departed_from");
                String airline = rs.getString("airline");
                String aircraft = rs.getString("aircraft");
                String status = rs.getString("status");
                
                
                
                out.print("<tr>"
                        +"<form action='flightdelete' method='post'>"
                            + "<td>" + "<input type='hidden' value='"+id+"' name='id' readonly> " + "</td>"
                            + "<td>" + "<input type='text' value='"+Time+"' name='time' readonly> " + "</td>"
                            + "<td>" + "<input type='text' value='"+date+"' name='date' readonly> " + "</td>"
                            + "<td>" + "<input type='text' value='"+flight+"' name='flight' readonly>" + "</td>"
                            + "<td>" + "<input type='text' value='"+from+"' name='from' readonly>" + "</td>"
                            + "<td>" + "<input type='text' value='"+airline+"' name='airline' readonly>" + "</td>"
                            + "<td>" + "<input type='text' value='"+aircraft+"' name='aircraft' readonly>" + "</td>"
                            + "<td>" + "<input type='text' value='"+status+"' name='status' readonly>" + "</td>");
                                        
                                   
                if("admin".equals(user)){
                    
                    out.print("<td>"
                            + "<input type='submit' value ='Delete' name='button'/>"
                            + "<input type='hidden' value ='arrival' name='formname'/>"
                            + "</td>"
                            + "</form>");
                }else{
                    out.print("</form>");
                }
            }
            
            out.print("</table>"); 
        
      out.write("\n");
      out.write("        \n");
      out.write("        <h1>Departures</h1>\n");
      out.write("        \n");
      out.write("        ");

            String dquery = "SELECT * FROM flightdeparture";
            PreparedStatement dps = con.prepareStatement(dquery);
            
            ResultSet drs = dps.executeQuery();
            
            out.print("<table border = '1'>" 
                    +"<tr>" 
                    +"<td></td>"
                    +"<td>Time</td>"
                    +"<td>Date</td>"
                    + "<td>Flight</td>"
                    + "<td>From</td>"
                    + "<td>Airline</td>"
                    + "<td>AirCraft</td>"
                    + "<td>Status</td>"
                    +"</tr>");
           

            while(drs.next()){
                
                int id = drs.getInt("fid");
                Time Time = drs.getTime("time");
                Date date = drs.getDate("time");
                String flight = drs.getString("flight");
                String whereto = drs.getString("where_to");
                String airline = drs.getString("airline");
                String aircraft = drs.getString("aircraft");
                String status = drs.getString("status");
                
                
                
                out.print("<tr>"
                        +"<form action='flightdelete' method='post'>"
                            + "<td>" + "<input type='hidden' value='"+id+"' name='id' readonly> " + "</td>"
                            + "<td>" + "<input type='text' value='"+Time+"' name='time' readonly> " + "</td>"
                            + "<td>" + "<input type='text' value='"+date+"' name='date' readonly> " + "</td>"
                            + "<td>" + "<input type='text' value='"+flight+"' name='flight' readonly>" + "</td>"
                            + "<td>" + "<input type='text' value='"+whereto+"' name='whereto' readonly>" + "</td>"
                            + "<td>" + "<input type='text' value='"+airline+"' name='airline' readonly>" + "</td>"
                            + "<td>" + "<input type='text' value='"+aircraft+"' name='aircraft' readonly>" + "</td>"
                            + "<td>" + "<input type='text' value='"+status+"' name='status' readonly>" + "</td>");
                
                if("admin".equals(user)){
                    
                    out.print("<td>"
                            + "<input type='submit' value ='Delete' name='button'/>"
                            + "<input type='hidden' value ='Departure' name='formname'/>"
                            + "</td>"
                            + "</form>");
                }else{
                    out.print("</form>");
                }
            }
            
            out.print("</table>"); 
        
      out.write("\n");
      out.write("        \n");
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
