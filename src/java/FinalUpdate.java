/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ankit
 */
@WebServlet(urlPatterns = {"/FinalUpdate"})
public class FinalUpdate extends HttpServlet {

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
    PrintWriter out = response.getWriter();

    try {
        String pwd = request.getParameter("pwd");
        String email = request.getParameter("mail");

        // Load the driver class
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Create connection
        Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Course_Management", "root", "");

        // Prepare the statement
        PreparedStatement ps = cn.prepareStatement("update user_reg set password=? where email=?");
        ps.setString(1, pwd);
        ps.setString(2, email);

        // Execute the update
        int rowsUpdated = ps.executeUpdate();

        if (rowsUpdated > 0) {
            out.println("<h2>Password updated successfully!!</h2>");
            // Optionally, redirect to another page using HttpServletResponse.sendRedirect("index.html");
             RequestDispatcher rd=request.getRequestDispatcher("index.html");
         rd.include(request, response);
        } else {
            out.println("<h2>Password update failed.</h2>");
        }

        cn.close();
        out.close(); // Close the PrintWriter
    } catch (Exception e) {
        // Properly handle the exception
        e.printStackTrace(); // Log the exception
        out.println("<h2>Error: " + e.getMessage() + "</h2>");
    }
}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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