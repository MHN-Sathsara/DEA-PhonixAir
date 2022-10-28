package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import DEA.PhoniexAirlines.Admin.model.Admin;
import java.sql.Connection;
import DEA.PhoniexAirlines.connection.DBConnection;

public final class staff_jsp extends org.apache.jasper.runtime.HttpJspBase
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
 
    DBConnection db = new DBConnection();
    
    Connection con = db.getCon();

      out.write('\n');
 
    Admin admin = (Admin) session.getAttribute("loggedAdmin"); 
    if(admin == null) {
        response.sendRedirect("adminlogin.jsp");
    }


      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Staff</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Staff</h1>\n");
      out.write("        ");

            String query = "SELECT * FROM staff";
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
