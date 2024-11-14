/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rahul
 */
@WebServlet(urlPatterns = {"/Fetch"})
public class Fetch extends HttpServlet {

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
        
         try
     {
                
     String pwd = request.getParameter("pwd");
     //load the driver class
         Class.forName("com.mysql.jdbc.Driver");
      //Create connection
      
      Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management","root","");
      
      //make PrepaedStatement object
         PreparedStatement ps=cn.prepareStatement("select * from user_reg where password=? ");
         ps.setString(1,pwd);
         
         ResultSet rs= ps.executeQuery();
         
        out.println("<table border='2'>");
          out.println("<tr><th>Id</th><th>Name</th><th>email</th><th>mobile</th><th>gender</th><th>state</th><th>city</th><th>college</th><th>degree</th></tr>");
           out.println("<caption><h2>User Details</h2></caption>");      
         
         while(rs.next())
        {
         String id = rs.getString(1);
         String name = rs.getString(2);
         String email = rs.getString(3);
         String mobile = rs.getString(4);
         String gender = rs.getString(6);
         String state = rs.getString(7);
         String city = rs.getString(8);
         String clg = rs.getString(9);
         String degree = rs.getString(10);
         
         
         out.println("<tr><td>"+id+"</td><td>"+name+"</td><td>"+email+"</td><td>"+mobile+"</td><td>"+gender+"</td><td>"+state+"</td><td>"+city+"</td><td>"+clg+"</td><td>"+degree+"</td></tr>");
         
     }
          cn.close();
     }
     catch(Exception e)
     {
         out.println(e.getMessage());   
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
        processRequest(request, response);
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
