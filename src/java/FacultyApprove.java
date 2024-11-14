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
@WebServlet(urlPatterns = {"/FacultyApprove"})
public class FacultyApprove extends HttpServlet {

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
                
         
     //load the driver class
         Class.forName("com.mysql.jdbc.Driver");
      //Create connection
      
      Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management","root","");
      
      //make PrepaedStatement object
         PreparedStatement ps=cn.prepareStatement("select * from faculty_reg where status=false ");
         
         ResultSet rs= ps.executeQuery();
         out.println("<body background='exam.jpg'>");
        out.println("<table border='2' style='background-color:rgba(255,255,255,0.7);'>");
          out.println("<tr><th>ID</th><th> Name </th><th>Status</th><th>Email-Id</th><th>Mobile</th><th>Subject</th><th>Qualification</th><th>Experience</th><th>Edit</th><th>Delete</th></tr>");
           out.println("<caption><h2>Faculty Details</h2></caption>");      
         
         while(rs.next())
        {
         String id = rs.getString(1);
         String name = rs.getString(2);
         String email = rs.getString(3);
         String mobile = rs.getString(4);
         String subject = rs.getString(7);
         String qualification = rs.getString(8);
         String experience = rs.getString(9);
          boolean status = rs.getBoolean(10);
         
         out.println("<tr><td>"+id+"</td><td>"+name+"</td><td>"+status+"</td><td>"+email+"</td><td>"+mobile+"</td><td>"+subject+"</td><td>"+qualification+"</td><td>"+experience+"</td><td><a href='Approval_edit?iidd="+id+"'> Edit </a></td><td><a href='Delete?idd=" +id+"'> Delete </a></td></tr>");
         
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
