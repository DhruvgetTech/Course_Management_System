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
@WebServlet(urlPatterns = {"/Edit"})
public class Edit extends HttpServlet {

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
        String name="",email="",mobile="",gender="",state="",city="",clg="",degree="";
        String pwd = request.getParameter("pass");
        
         Class.forName("com.mysql.jdbc.Driver");
         
         Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management","root","");
         
         PreparedStatement ps = cn.prepareStatement("Select * from user_reg where password=?");
         
         ps.setString(1,pwd);
         ResultSet rs=ps.executeQuery();
         
         if(rs.next())
         {
              name =  rs.getString(2);
              email = rs.getString(3);
               mobile = rs.getString(4);
                gender = rs.getString(5);
                 state = rs.getString(6);
                  city = rs.getString(7);
                   clg = rs.getString(8);
                    degree = rs.getString(9);
         }
          cn.close();
          out.println("<h2>User Details</h2>");
        out.println("<form action='Update'>");
      
          out.println("<pre>");
        out.println("<input type='text' name='id' value='"+name+"' readonly>");  
        out.println("<input type='text' name='n' value='"+email+"'>");
        out.println("<input type='text' name='sal' value='"+mobile+"'>");
         out.println("<input type='text' name='sal' value='"+gender+"'>");
         out.println("<input type='text' name='sal' value='"+state+"'>");
          out.println("<input type='text' name='sal' value='"+city+"'>");
           out.println("<input type='text' name='sal' value='"+clg+"'>");
            out.println("<input type='text' name='sal' value='"+degree+"'>");
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
