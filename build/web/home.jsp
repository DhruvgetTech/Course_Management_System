<%-- 
    Document   : one
    Created on : 01-Jul-2024, 7:40:19 pm
    Author     : ankit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
         <style type="text/css">
        
        .navigation
        {
            color:white;
            font-size:20px;
            font-family:arial;
            width:20px;
            height:60px;
        }
        .bartheme
        {
            font-size:20px;
            border-radius:30px;
            background-color:rgba(255,255,255,0.5);
            border:solid;
            border-color:blue;
        }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body background="exam.jpg">
        
        
         <table width="100%" style="background-color:rgba(145,155,201,0.5);">
            <tr>
                <td width="70%"> 
                    <table width="100%">
                        <tr>
                        <table width="100%">
                            <tr align="center">
            <td class="navigation" style="background-color:red;border-radius:30px"><a href="home.jsp">HOME</a></td>
            <td class="navigation"><a href="contact.jsp">Courses</a></td>
            <td class="navigation"><a href="setting.html">Setting</a></td>
            <td class="navigation"><a href="Logout">Logout</a></td>
            <td class="navigation"><a href="about.jsp">About</a></td>
                </tr>
                
                   </table>
                </tr>    
                </table>     
                    <br>
                 <br>
                    
                    <table>
                <tr align='center' bgcolor='sky blue' stlye='border-radius:30px;' >
                    <td colspan="2"  style="background-color:goldenrod;border-radius:19px"><h3> Course Management System</h3></td>   
                </tr>
                    </table>
                
                <br>   
                    
        <%
            try
            {
         HttpSession hs=request.getSession(false);
         String name = (String)hs.getAttribute("naam");
         
        out.println("<h2>Welcome "+name+"</h2>");
        out.println("<a href=Profile>Profile</a>");
        }
        catch(Exception e)
        {
             //out.println(e.getMessage());
        out.println("<h2>Please Login First</h2>");
        RequestDispatcher rd=request.getRequestDispatcher("index.html");
        rd.include(request, response);
        }
        %>
        <h2>Hello dear</h2>
        
        
      
       
        
      
      
      
      
    </body>
</html>
