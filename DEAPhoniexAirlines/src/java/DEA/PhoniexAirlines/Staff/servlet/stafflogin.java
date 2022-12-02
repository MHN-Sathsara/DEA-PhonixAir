/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEA.PhoniexAirlines.Staff.servlet;

import DEA.PhoniexAirlines.Staff.dao.Staffdao;
import DEA.PhoniexAirlines.Staff.model.StaffMember;
import DEA.PhoniexAirlines.connection.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Raffael
 */
public class stafflogin extends HttpServlet {

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
            out.println("<title>Servlet stafflogin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet stafflogin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String grade = request.getParameter("grades");
        try {
            Staffdao staffdao = new Staffdao(DBConnection.getCon());
            StaffMember staff = staffdao.logStaff(username,password,grade);
            if(staff!=null){
                HttpSession session = request.getSession();
                session.setAttribute("loggedStaff", staff);
                if("g1".equals(grade)){
                    
                    session.setAttribute("type", "sg1");
                    response.sendRedirect("staffdashG1.jsp");
                    
                }else{
                    session.setAttribute("type", "sg2");
                    response.sendRedirect("staffdashG2.jsp");
                     
                }
            }else{
                out.println("User Does Not Exist");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(stafflogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
