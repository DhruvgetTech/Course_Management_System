/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rahul
 */
@WebServlet(urlPatterns = {"/Approval_edit"})
public class Approval_edit extends HttpServlet {

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
            boolean status=false;
        String name="",email="";
        String id = request.getParameter("iidd");
        
         Class.forName("com.mysql.jdbc.Driver");
         
         Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management","root","");
         
         PreparedStatement ps = cn.prepareStatement("Select * from faculty_reg where id=?");
         
         ps.setString(1,id);
         ResultSet rs=ps.executeQuery();
         out.println("<table border='2'>");
         out.println("<tr><th>ID</th><th> Name </th><th>Email-Id</th><th>Status</th></tr>");
         if(rs.next())
         {
              name =  rs.getString(2);
              email = rs.getString(3);
              status = rs.getBoolean(10);
         }
          cn.close();
          out.println("<h2>Approval Form</h2>");
        out.println("<form action='Approval_update'>");
      
          out.println("<pre>");
          out.println("<tr><td><input type='hidden' name='id' value='"+id+"'></td><td>"+name+"</td><td>"+email+"</td><td>Status<select name='status'><option>true</option><option>false</option></select></td></tr>");
       
          out.println("<input type='submit' value='Update'>");
        
                        
        out.println("</pre>");
        
        out.println("</form>");
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
