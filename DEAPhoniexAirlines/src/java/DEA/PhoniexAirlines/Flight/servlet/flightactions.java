/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEA.PhoniexAirlines.Flight.servlet;

import DEA.PhoniexAirlines.ClientRegistration.DBC;
import DEA.PhoniexAirlines.Flight.model.flight;
import DEA.PhoniexAirlines.Flights.dao.flightdeletedao;
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
public class flightactions extends HttpServlet {

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
            out.println("<title>Servlet flightdelete</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet flightdelete at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        PrintWriter out = response.getWriter();
        int fid = Integer.parseInt(request.getParameter("id"));
        String formname = request.getParameter("formname");
        String button = request.getParameter("button");
        
        flightdeletedao fdd = new flightdeletedao(DBC.getCon());
        flight fl = new flight(fid);
        
        if("Departure".equals(formname)){
            
            if("Book".equals(button)){

                String id = request.getParameter("id");

                request.setAttribute("id",id);

                RequestDispatcher rd = request.getRequestDispatcher("/tickets/ticketbooking.jsp");

                rd.forward(request, response);

            }
            
        }else {
        
            if("arrival".equals(formname)){

                if(fdd.deleteflightfromArrival(fl)){
                    out.println("Successfully Deleted");
                }else{
                    out.println("Delete Failed");
                }
            }else{
                
                if(fdd.deleteflightfromDeparture(fl)){
                    out.println("Successfully Deleted");
                }else{
                    out.println("Delete Failed");
                }
                
            }
            response.sendRedirect("flights.jsp");
            

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
