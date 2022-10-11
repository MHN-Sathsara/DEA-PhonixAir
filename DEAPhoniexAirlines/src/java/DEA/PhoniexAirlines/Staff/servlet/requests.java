/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEA.PhoniexAirlines.Staff.servlet;

import DEA.PhoniexAirlines.ClientRegistration.DBC;
import DEA.PhoniexAirlines.Staff.dao.approvaldao;
import DEA.PhoniexAirlines.Staff.dao.denydao;
import DEA.PhoniexAirlines.Staff.model.StaffMember;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Raffael
 */
public class requests extends HttpServlet {

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
            out.println("<title>Servlet requests</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet requests at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            PrintWriter out = response.getWriter();
            
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String grade = request.getParameter("grade");
            String password = request.getParameter("password");
            String op = request.getParameter("button");
            
            StaffMember sm;
            denydao ddao;
            
            if("Allow".equals(op)){
                
                sm = new StaffMember(email, password, grade, username);
                approvaldao apd = new approvaldao(DBC.getCon());
                ddao = new denydao(DBC.getCon()); // to delete the record from the requests table
                
                if (apd.staffApproval(sm)) {
                    
                    out.println("Approved");
                    
                    
                    if(ddao.staffDenial(sm)){
                        out.println("Record Deleted");
                    }else{
                        out.println("Delete Failed");
                    }
                   
                } else {
                    
                    out.println("Approval Failed");
                    
                }
                
            }else {
                
                sm = new StaffMember(email, grade);
                
                ddao = new denydao(DBC.getCon());
                
                if(ddao.staffDenial(sm)) {
                    out.println("Declined");
                }else {
                    
                    out.println("Decline Failed");
                    
                }
            }
            
            response.sendRedirect("staffrequests.jsp");
            
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
