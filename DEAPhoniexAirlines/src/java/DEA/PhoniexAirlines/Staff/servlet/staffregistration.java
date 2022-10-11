/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEA.PhoniexAirlines.Staff.servlet;

import DEA.PhoniexAirlines.ClientRegistration.DBC;
import DEA.PhoniexAirlines.Staff.dao.Staffregdao;
import DEA.PhoniexAirlines.Staff.model.StaffMember;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Raffael
 */
public class staffregistration extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet staffregistration</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet staffregistration at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String grade = request.getParameter("grade");
            String password = request.getParameter("password");
                
            StaffMember sm = new  StaffMember(email, password, grade, username);
                
                
            Staffregdao reg = new Staffregdao(DBC.getCon());
                
                if (reg.staffRegistration(sm)) {
                    
                   response.sendRedirect("Staff-Login.html");
                   
                } else {
                    
                    String error = "Username Taken";
                    HttpSession regSession = request.getSession();
                    regSession.setAttribute("RegError", error);
                    response.sendRedirect("Staff-reg.html");
                    
                }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
