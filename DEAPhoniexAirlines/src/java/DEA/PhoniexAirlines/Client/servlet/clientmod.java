/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEA.PhoniexAirlines.Client.servlet;

import DEA.PhoniexAirlines.Client.blockunblock.dao.blockclient;
import DEA.PhoniexAirlines.Client.blockunblock.dao.clientunblock;
import DEA.PhoniexAirlines.Client.blockunblock.dao.clientunblockdelete;
import DEA.PhoniexAirlines.Client.blockunblock.dao.deleteclient;
import DEA.PhoniexAirlines.Client.model.Client;
import DEA.PhoniexAirlines.ClientRegistration.DBC;
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
public class clientmod extends HttpServlet {

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
            out.println("<title>Servlet clientmod</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet clientmod at " + request.getContextPath() + "</h1>");
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
            String nic = request.getParameter("nic");
            String password = request.getParameter("password");
            String op = request.getParameter("button");
            
            Client client;
            deleteclient dc;
            clientunblockdelete cd;
            
          
            if(op.equals("Block")){   
                client = new Client(email, password, nic, username);
                blockclient bc = new blockclient(DBC.getCon());
                dc = new deleteclient(DBC.getCon()); 
                
                if (bc.blockClient(client)) {
                    
                    out.println("Blocked");
                    
                    if(dc.deleteClient(client)){
                        out.println("Deleted");
                    }else{
                        out.println("Delete Failed");
                    }
                    
                   
                } else {
                    
                    out.println("Block Failed");
                    
                }
                
                response.sendRedirect("clients.jsp");
   
            }else if(op.equals("Unblock")){
                
                client = new Client(email, password, nic, username);
                clientunblock cu = new clientunblock(DBC.getCon());
                cd = new clientunblockdelete(DBC.getCon());
                

                if(cu.unblockClient(client)){
                    out.println("Unblocked");
                    
                    if(cd.deleteClient(client)){
                        out.println("Record Deleted");
                    }else{
                        out.println("Record not Deleted");
                    }
                }else {
                    out.println("Unblock failed");
                }
                
                response.sendRedirect("clients.jsp");
                
            }else {
                
                String url = "customerprofileupdate.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                
                request.setAttribute("id", id);
                request.setAttribute("username", username);
                request.setAttribute("email", email);
                
                
                	
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
