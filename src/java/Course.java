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
 * @author rahul
 */
@WebServlet(urlPatterns = {"/Course"})
public class Course extends HttpServlet {

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
        
        try{
            String cname=request.getParameter("cname");
            String price=request.getParameter("price");
            String syllabus=request.getParameter("syllabus");
            String fname=request.getParameter("fname");
            String ql=request.getParameter("qualification");
            String exp=request.getParameter("fexperience");
            
            //load the driver class
         Class.forName("com.mysql.jdbc.Driver");
      //Create connection
      
      Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management","root","");
      
      //make PrepaedStatement object
         PreparedStatement ps=cn.prepareStatement("insert into course(course_name, price, syllabus, faculty_name, higher_qualification, faculty_experience) values(?,?,?,?,?,?)");
         ps.setString(1, cname);
         ps.setString(2, price);
         ps.setString(3, syllabus);
         ps.setString(4, fname);
         ps.setString(5, ql);
         ps.setString(6, exp);
        
         boolean b=ps.execute();
         if(b==false)
         {
             out.println("<h2>Course successfully Added</h2>");
                      
             RequestDispatcher rd=request.getRequestDispatcher("add_course.html");
             rd.include(request, response);
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
