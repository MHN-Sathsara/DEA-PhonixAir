package org.apache.jsp.tickets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Date;

public final class ticketbooking_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');

        String destination = (String)request.getAttribute("dep");
        Date depdate = (Date)request.getAttribute("depdate");
        Float price = Float.parseFloat(request.getParameter("price"));

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>TicketBooking</h1>\n");
      out.write("        <form action=\"ticketBooking\" method=\"post\">\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"ttype\" id=\"ttype\" onclick=\"onewaydisable();\">\n");
      out.write("                            <option value=\"oneway\">One-Way</option>\n");
      out.write("                            <option value=\"round\">Round-Trip</option>\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Full Name :</td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" name=\"fullname\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Passport Id :</td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" name=\"pid\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Email :</td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" name=\"email\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Destination :</td>\n");
      out.write("                    <td>\n");
      out.write("                        ");

                            out.print("<input type='text' name='destination' value" + destination + "/>");
                        
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Departure Date :</td>\n");
      out.write("                    <td>\n");
      out.write("                        ");

                            out.print("<input type='datetime-local' name='ddate' value" + depdate + "/>");
                        
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Return Date :</td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"datetime-local\" name=\"rdate\" id=\"returndate\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Class :</td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"class\">\n");
      out.write("                            <option value=\"eco\">Economy</option>\n");
      out.write("                            <option value=\"business\">Business</option>\n");
      out.write("                            <option value=\"first\">First</option>\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Adult</td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"number\" name=\"adult\"/>\n");
      out.write("                    </td>\n");
      out.write("                    <td>Child</td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"number\" name=\"child\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        Price :\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        ");

                            out.print("<input type='number' name='price' value" + price + "/>");
                        
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"submit\" value=\"Book\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("    <script>\n");
      out.write("        var ticketType = document.getElementById(\"ttype\");\n");
      out.write("            \n");
      out.write("            if(ticketType.value === \"oneway\") {\n");
      out.write("\n");
      out.write("                   console.log(ticketType.value);\n");
      out.write("                   document.getElementById(\"returndate\").disabled = true;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("               \n");
      out.write("        function onewaydisable(){\n");
      out.write("        \n");
      out.write("            if(ticketType.value === \"oneway\") {\n");
      out.write("\n");
      out.write("               console.log(ticketType.value);\n");
      out.write("               document.getElementById(\"returndate\").disabled = true;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            if(ticketType.value === \"round\"){\n");
      out.write("\n");
      out.write("               console.log(ticketType.value);\n");
      out.write("               document.getElementById(\"returndate\").disabled = false;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    </script>\n");
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
