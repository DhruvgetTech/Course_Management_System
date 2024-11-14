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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/CheckLogin"})
public class CheckLogin extends HttpServlet {

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
                
           String email=request.getParameter("email");
           String pwd=request.getParameter("pwd");
       
     //load the driver class
         Class.forName("com.mysql.jdbc.Driver");
      //Create connection
      
      Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management","root","");
      
      //make PrepaedStatement object
         PreparedStatement ps=cn.prepareStatement("select * from user_reg where email=? and binary password=?");
         ps.setString(1, email);
         ps.setString(2, pwd);
         
         
      ResultSet rs=ps.executeQuery();
       if(rs.next())
      {
         String user_id = rs.getString("id");
         String name = rs.getString("name");
         String mobile = rs.getString("mobile");
         
         HttpSession hs = request.getSession(true);
         
         hs.setAttribute("id", user_id);
         hs.setAttribute("naam", name);
         hs.setAttribute("mobile", mobile);
                 
         response.sendRedirect("home.jsp");
      }
      else
      {
          out.println("<h2>Email ID or password invalid</h2>");
          RequestDispatcher rd=request.getRequestDispatcher("index.html");
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
