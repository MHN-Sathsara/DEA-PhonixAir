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
import DEA.PhoniexAirlines.blockunblock.dao.block;
import DEA.PhoniexAirlines.blockunblock.dao.delete;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raffael
 */
public class staffmod extends HttpServlet {

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
            out.println("<title>Servlet staffmod</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet staffmod at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            
            int id = Integer.parseInt(request.getParameter("id"));
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String grade = request.getParameter("grade");
            String password = request.getParameter("password");
            String op = request.getParameter("button");
            
            StaffMember sm;
            delete del;
            
          
            if(op.equals("Block")){   
                sm = new StaffMember(email, password, grade, username);
                block apd = new block(DBC.getCon());
                del = new delete(DBC.getCon()); 
                
                if (apd.blockStaff(sm)) {
                    
                    out.println("Blocked");
                    
                    if(del.deleteStaff(sm)){
                        out.println("Deleted");
                    }else{
                        out.println("Delete Failed");
                    }
                   
                } else {
                    
                    out.println("Block Failed");
                    
                }
                
                response.sendRedirect("staff.jsp");
                
            } else {
                
                String url = "updateprofileform.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                
                request.setAttribute("id", id);
                request.setAttribute("username", username);
                request.setAttribute("email", email);
                request.setAttribute("grade", grade);
                
                	
                rd.forward(request, response);
                
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
