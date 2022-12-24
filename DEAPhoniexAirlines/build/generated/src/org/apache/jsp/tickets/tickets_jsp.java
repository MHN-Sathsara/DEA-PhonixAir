package org.apache.jsp.tickets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DEA.PhoniexAirlines.Client.model.Client;
import DEA.PhoniexAirlines.Staff.model.StaffMember;
import DEA.PhoniexAirlines.Admin.model.Admin;
import java.sql.Connection;
import DEA.PhoniexAirlines.connection.DBConnection;

public final class tickets_jsp extends org.apache.jasper.runtime.HttpJspBase
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


      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Tickets</h1>\n");
      out.write("        ");

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
