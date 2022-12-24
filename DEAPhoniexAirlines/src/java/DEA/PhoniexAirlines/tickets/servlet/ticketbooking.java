/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEA.PhoniexAirlines.tickets.servlet;

import DEA.PhoniexAirlines.ClientRegistration.DBC;
import DEA.PhoniexAirlines.tickets.dao.addoneway;
import DEA.PhoniexAirlines.tickets.dao.addroundtrip;
import DEA.PhoniexAirlines.tickets.model.oneway;
import DEA.PhoniexAirlines.tickets.model.roundtrip;
import DEA.PhoniexAirlines.tickets.model.ticketidgenerator;
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
public class ticketbooking extends HttpServlet {

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
            out.println("<title>Servlet ticketbooking</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ticketbooking at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        
        String ttype = request.getParameter("ttype");
        String fname = request.getParameter("fullname");
        String pid = request.getParameter("pid");
        String email = request.getParameter("email");
        String destination = request.getParameter("destination");
        String depdate = request.getParameter("ddate");
        String tclass = request.getParameter("tclass");
        int atickets = Integer.parseInt(request.getParameter("adult"));
        int ctickets = Integer.parseInt(request.getParameter("child"));
        float price = Float.parseFloat(request.getParameter("price"));
        
        ticketidgenerator tig = new ticketidgenerator();
        
        String tid = tig.generateTID(10);
        
        if("round".equals(ttype)){
            
            String rdate = request.getParameter("rdate");
            
            roundtrip round = new roundtrip(tid, ttype, email, fname, pid, destination, tclass, depdate, rdate, atickets, ctickets, price);
            
            addroundtrip art = new addroundtrip(DBC.getCon());
            
            if(art.addreturnTicket(round)){
                out.println("Booking Successful");
            }else {
                out.println("Booking Failed");
            }
        }else {
            
            oneway ow = new oneway(tid ,ttype, email, fname, pid, destination, tclass, depdate, atickets, ctickets, price);
            
            addoneway aow = new addoneway(DBC.getCon());
            
            if(aow.addonewayTicket(ow)){
                out.println("Booking Successful");
                out.println(tclass);
            }else {
                out.println("Booking Failed");
            }
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
