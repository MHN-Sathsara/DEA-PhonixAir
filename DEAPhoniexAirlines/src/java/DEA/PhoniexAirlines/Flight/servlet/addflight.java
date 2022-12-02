/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEA.PhoniexAirlines.Flight.servlet;

import DEA.PhoniexAirlines.ClientRegistration.DBC;
import DEA.PhoniexAirlines.Flight.model.flight;
import DEA.PhoniexAirlines.Flights.dao.addflightdao;
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
public class addflight extends HttpServlet {

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
            out.println("<title>Servlet addflight</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addflight at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        
        String time = request.getParameter("time");
        String flight = request.getParameter("flight");
        String from = request.getParameter("loc");
        String airline = request.getParameter("airlines");
        String aircraft = request.getParameter("aircraft");
        String status = request.getParameter("status");
        
        flight fl = new flight(time, flight, from, airline, aircraft, status);
        
        addflightdao afd = new addflightdao(DBC.getCon());
        
        if(afd.addFlightArrival(fl)){
            out.print("Added Successfully");
            response.sendRedirect("/DEAPhoniexAirlines/flights/flights.jsp");
        }else{
            out.print("Failed");
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
