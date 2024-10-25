
<%@page contentType="text/html" import="java.sql.*"%> 
<!DOCTYPE html> 
<html> 
    <body> 
        <h1>LOGIN JSP PAGE</h1> 
        <% 
            String uname=request.getParameter("txtName"); 
            String pass=request.getParameter("txtPass"); 
            ResultSet rs=null; 
            try 
            { 
                Class.forName("com.mysql.jdbc.Driver"); 
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javpractical?autoReconnect=true&useSSL=false", "root", "root"); 
                Statement stmt=con.createStatement(); 
                rs=stmt.executeQuery("select password from user where name='"+uname+"'"); 
                rs.next(); 
                if(pass.equals(rs.getString(1))) 
                { 
                    out.println("<h1>LOGIN SUCCESSFULLL</h1>"); 
                } 
            else 
            { 
                out.println("<h1>PASSWORD DOES NOT MATCH!!!!!</h1>"); 
        %> 
        <jsp:include page="index.html"></jsp:include> 
        <% 
            } 
         } 
         catch(Exception e) 
         { 
         out.println("<h1>USER DOES NOT EXIST!!!!!</h1>"); 
         %> 
         <jsp:include page="index.html"></jsp:include> 
        <% 
         }    
        %> 
    </body> 
</html> 